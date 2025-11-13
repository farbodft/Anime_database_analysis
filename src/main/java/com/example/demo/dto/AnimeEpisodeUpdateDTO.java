package com.example.demo.dto;

public class AnimeEpisodeUpdateDTO {
    private String animeId;
    private int episodes;

    public AnimeEpisodeUpdateDTO() {}

    public AnimeEpisodeUpdateDTO(String animeId, int episodes) {
        this.animeId = animeId;
        this.episodes = episodes;
    }

    public String getAnimeId() {
        return animeId;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setAnimeId(String animeId) {
        this.animeId = animeId;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }
}
