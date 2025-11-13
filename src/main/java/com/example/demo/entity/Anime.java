package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "anime_list")
public class Anime {
    // All attributes are Text so we use String
    @Id
    @Column(name = "anime_id", nullable = false)
    private String animeId;

    @Column(name = "studio")
    private String studio;

    @Column(name = "opening_theme")
    private String openingTheme;

    @Column(name = "episodes")
    private String episodes;

    @Column(name = "title_synonyms")
    private String titleSynonyms;

    @Column(name = "licensor")
    private String licensor;

    @Column(name = "score")
    private String score;

    @Column(name = "related")
    private String related;

    @Column(name = "aired")
    private String aired;

    @Column(name = "status")
    private String status;

    @Column(name = "broadcast")
    private String broadcast;

    @Column(name = "rating")
    private String rating;

    @Column(name = "aired_string")
    private String airedString;

    @Column(name = "type")
    private String type;

    @Column(name = "popularity")
    private String popularity;

    @Column(name = "favorites")
    private String favorites;

    @Column(name = "rank")
    private String rank;

    @Column(name = "members")
    private String members;

    @Column(name = "premiered")
    private String premiered;

    @Column(name = "ending_theme")
    private String endingTheme;

    @Column(name = "genre")
    private String genre;

    @Column(name = "duration")
    private String duration;

    @Column(name = "scored_by")
    private String scoredBy;

    @Column(name = "title_english")
    private String titleEnglish;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "airing")
    private String airing;

    @Column(name = "source")
    private String source;

    @Column(name = "title_japanese")
    private String titleJapanese;

    @Column(name = "background")
    private String background;

    @Column(name = "title")
    private String title;

    @Column(name = "producer")
    private String producer;


    // Constructor

    public Anime() {
    }


    // Getters and Setters

    public String getAnimeId() {
        return animeId;
    }

    public void setAnimeId(String animeId) {
        this.animeId = animeId;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getOpeningTheme() {
        return openingTheme;
    }

    public void setOpeningTheme(String openingTheme) {
        this.openingTheme = openingTheme;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public String getTitleSynonyms() {
        return titleSynonyms;
    }

    public void setTitleSynonyms(String titleSynonyms) {
        this.titleSynonyms = titleSynonyms;
    }

    public String getLicensor() {
        return licensor;
    }

    public void setLicensor(String licensor) {
        this.licensor = licensor;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    public String getAired() {
        return aired;
    }

    public void setAired(String aired) {
        this.aired = aired;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAiredString() {
        return airedString;
    }

    public void setAiredString(String airedString) {
        this.airedString = airedString;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getEndingTheme() {
        return endingTheme;
    }

    public void setEndingTheme(String endingTheme) {
        this.endingTheme = endingTheme;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getScoredBy() {
        return scoredBy;
    }

    public void setScoredBy(String scoredBy) {
        this.scoredBy = scoredBy;
    }

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAiring() {
        return airing;
    }

    public void setAiring(String airing) {
        this.airing = airing;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitleJapanese() {
        return titleJapanese;
    }

    public void setTitleJapanese(String titleJapanese) {
        this.titleJapanese = titleJapanese;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
