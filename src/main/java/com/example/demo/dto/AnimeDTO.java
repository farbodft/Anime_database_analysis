package com.example.demo.dto;



public class AnimeDTO {
    private String animeId;
    private String title;
    private String score;
    private String episodes;

    public AnimeDTO() {}

    public AnimeDTO(String animeId, String title, String score, String episodes) {
        this.animeId = animeId;
        this.title = title;
        this.score = score;
        this.episodes = episodes;
    }

    public String getAnimeId() {
        return animeId;
    }

    public void setAnimeId(String animeId) {
        this.animeId = animeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }
}
