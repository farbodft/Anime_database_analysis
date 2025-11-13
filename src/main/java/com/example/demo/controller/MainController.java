package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Anime;
import com.example.demo.entity.UserAnime;
import com.example.demo.repository.AnimeRepository;
import com.example.demo.repository.UserAnimeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController("")
public class MainController {

    private final AnimeRepository animeRepository;
    private final UserRepository userRepository;
    private final UserAnimeRepository userAnimeRepository;

    public MainController(AnimeRepository animeRepository, UserRepository userRepository, UserAnimeRepository userAnimeRepository) {
        this.animeRepository = animeRepository;
        this.userRepository = userRepository;
        this.userAnimeRepository = userAnimeRepository;
    }

    // Q1. Get top 10 anime by episode count (descending order)
    @GetMapping("/anime/top")
    public List<AnimeDTO> getTop10AnimesByEpisodes() {
        return animeRepository.findAll().stream()
                .filter(anime -> anime.getEpisodes() != null) // get animes that their episodes count is not null
                .sorted((a, b) -> Integer.compare(
                        Integer.parseInt(b.getEpisodes()),
                        Integer.parseInt(a.getEpisodes())
                )) // sort based on number of episodes desc
                .limit(10)// to get only top ten
                .map(anime -> new AnimeDTO(
                        anime.getAnimeId(),
                        anime.getTitle(),
                        anime.getScore(),
                        anime.getEpisodes()
                )) // map the result to DTO
                .toList(); // convert the result to list
    }

    // Q2. Get top users (by average score > 8, gender and join year filter, with pagination)
    @GetMapping("/users/top")
    public List<TopUserDTO> getTopUsers(
            @RequestParam(name = "page") int page,
            @RequestParam(name = "offset") int offset,
            @RequestParam(name = "year") int year,
            @RequestParam(name = "gender") String gender
    ) {
        // convert F and M to Female and Male (that is how gender is stored in database)
        String normalizedGender = gender.equalsIgnoreCase("F") ? "Female"
                : gender.equalsIgnoreCase("M") ? "Male"
                : gender.toLowerCase();

        return userRepository.findAll().stream()
                .filter(user -> normalizedGender.equals(user.getGender())) // select users with given gender
                .filter(user -> {
                    return Double.parseDouble(user.getStats_mean_score()) > 8; // users that have mean score > 8
                })
                .filter(user -> {
                    // extract users' join year from their join date
                    String date = user.getJoin_date();
                    if (date == null || date.length() < 4) return false;
                    int joinYear = Integer.parseInt(date.substring(0, 4));
                    return joinYear > year; // filter based on join year being bigger than given year
                })
                .sorted((u1, u2) -> {
                    // sort based on mean score desc
                    double d1 = Double.parseDouble(u1.getStats_mean_score());
                    double d2 = Double.parseDouble(u2.getStats_mean_score());
                    return Double.compare(d2, d1);
                })
                .skip((long) (page - 1) * offset) // implement paging by skipping the number of data previous pages
                .limit(offset) // to get offset number of data
                .map(user -> new TopUserDTO(
                        user.getUsername(),
                        user.getStats_mean_score()
                )) // map to DTO
                .toList(); // convert the final result to list
    }

    // Q3. Get list of anime watched by a user (sorted by user's score ascending)
    @GetMapping("/users/{username}/watched")
    public List<WatchedAnimeDTO> getWatchedAnimes(
            @PathVariable(name = "username") String username,
            @RequestParam(name = "count", defaultValue = "10") int count
    ) {
        return userAnimeRepository.findAll().stream()
                .filter(entry -> username.equals(entry.getUser().getUsername())) // filter based on given username
                .sorted((e1, e2) -> {
                    int s1 = Integer.parseInt(e1.getMy_score());
                    int s2 = Integer.parseInt(e2.getMy_score());
                    return Integer.compare(s1, s2);
                    // sort based on given score asc
                })
                .limit(count) // limit based on given count
                .map(entry -> new WatchedAnimeDTO(
                        entry.getAnime().getAnimeId(),
                        entry.getAnime().getTitle(),
                        entry.getMy_score(),
                        entry.getAnime().getEpisodes()
                ))// map to DTO
                .toList(); // convert final result to list
    }

    // Q4. Get top 3 most watched genres across all users
    @GetMapping("/anime/popular")
    public List<GenreCountDTO> getPopularGenres() {
        Map<String, Long> genreCountMap = new HashMap<>();

        userAnimeRepository.findAll().stream()
                .map(UserAnime::getAnime) // get all animes from user_anime_list
                .map(Anime::getGenre)// get genre of each anime
                .flatMap(genreString -> Arrays.stream(genreString.split(",")))// split genres to an array
                .map(String::trim)// removes extra white space from genres
                .filter(genre -> !genre.isEmpty())// skip empty strings that produced after trimming
                .forEach(genre -> {
                    genreCountMap.put(genre, genreCountMap.getOrDefault(genre, 0L) + 1);// add 1 to the count of that genre
                });

        return genreCountMap.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())) // sort genre based on count desc
                .limit(3) // limit 3 to get top 3
                .map(e -> new GenreCountDTO(e.getKey(), e.getValue()))// map to DTO
                .toList();// convert final result to list
    }

    // Q5. Get top 5 active users (most days spent watching) in a specific year
    @GetMapping("/users/active/{year}")
    public List<ActiveUserDTO> getActiveUsers(@PathVariable(name = "year") int year) {
        return userRepository.findAll().stream()
                .filter(user -> {
                    String date = user.getJoin_date();
                    if (date == null || date.length() < 4) return false;
                    int joinYear = Integer.parseInt(date.substring(0, 4));
                    return joinYear == year;
                }) // extract users join year from their join date and filter it based on input year
                .filter(user -> {
                    Double.parseDouble(user.getUser_days_spent_watching());
                    return true;
                }) // get users days spent watching
                .sorted((u1, u2) -> {
                    double d1 = Double.parseDouble(u1.getUser_days_spent_watching());
                    double d2 = Double.parseDouble(u2.getUser_days_spent_watching());
                    return Double.compare(d2, d1);
                }) // sort based on days spent watching
                .limit(5) // limit 5 to get top 5
                .map(user -> new ActiveUserDTO(
                        user.getUsername(),
                        user.getUser_days_spent_watching()
                ))// map to DTO
                .toList();// convert final result to list
    }

    // Q6. Find users with the most shared anime with the target user
    @GetMapping("users/{username}/similars")
    public List<SimilarUserDTO> getSimilarUsers(@PathVariable(name = "username") String username) {
        Set<String> targetUserAnimeIds = userAnimeRepository.findAll().stream()
                .filter(entry -> username.equals(entry.getUser().getUsername()))
                .map(entry -> entry.getAnime().getAnimeId())// get animes watched by given username
                .collect(Collectors.toSet()); // convert to set

        Map<String, Long> sharedCountMap = new HashMap<>();

        userAnimeRepository.findAll().stream()
                .filter(entry -> !entry.getUser().getUsername().equalsIgnoreCase(username)) // get other users
                .filter(entry -> targetUserAnimeIds.contains(entry.getAnime().getAnimeId())) // get animes that exist in the set
                .forEach(entry -> {
                    String otherUsername = entry.getUser().getUsername();
                    sharedCountMap.put(otherUsername, sharedCountMap.getOrDefault(otherUsername, 0L) + 1); // update the count of similars
                });

        return sharedCountMap.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())) // sort based on count desc
                .map(e -> new SimilarUserDTO(e.getKey(), e.getValue())) // map to DTO
                .toList(); // convert final result to list
    }

    // Q7. Update the episode count of a given anime by a specified value
    @PostMapping("/anime/{animeId}/episodes")
    public ResponseEntity<AnimeEpisodeUpdateDTO> updateAnimeEpisodes(
            @PathVariable(name = "animeId") String animeId,
            @RequestParam(name = "value", defaultValue = "1") int value
    ) {
        Optional<Anime> optionalAnime = animeRepository.findById(animeId); // optional in case movie not found

        if (optionalAnime.isEmpty()) {
            return ResponseEntity.notFound().build(); // inform not found
        }

        Anime anime = optionalAnime.get(); // get the anime based on the name

        int currentEpisodes = Integer.parseInt(anime.getEpisodes()); // get the count of episodes

        int updatedEpisodes = currentEpisodes + value; // calculate the new episodes count
        anime.setEpisodes(String.valueOf(updatedEpisodes)); // update the episodes count
        animeRepository.save(anime); // save the results to database

        return ResponseEntity.ok(new AnimeEpisodeUpdateDTO(anime.getAnimeId(), updatedEpisodes)); // inform the success
    }
}
