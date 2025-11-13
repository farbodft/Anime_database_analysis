package com.example.demo.dto;

public class WatchedAnimeDTO {
    private String animeId;
    private String title;
    private String myScore;
    private String episodes;

    public WatchedAnimeDTO() {}

    public WatchedAnimeDTO(String animeId, String title, String myScore, String episodes) {
        this.animeId = animeId;
        this.title = title;
        this.myScore = myScore;
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

    public String getMyScore() {
        return myScore;
    }

    public void setMyScore(String myScore) {
        this.myScore = myScore;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }
}
