package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_anime_list")
@IdClass(UserAnimeId.class) // to implement composite key of this entity

public class UserAnime {

    // All attributes are Text so we use String

    // using join column to implement foreign keys to other tables
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anime_id", referencedColumnName = "anime_id")
    private Anime anime;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    @Column(name = "my_score")
    private String my_score;

    @Column(name = "my_last_updated")
    private String my_last_updated;

    @Column(name = "my_start_date")
    private String my_start_date;

    @Column(name = "my_rewatching")
    private String my_rewatching;

    @Column(name = "my_rewatching_ep")
    private String my_rewatching_ep;

    @Column(name = "my_finish_date")
    private String my_finish_date;

    @Column(name = "my_watched_episodes")
    private String my_watched_episodes;

    @Column(name = "my_status")
    private String my_status;

    @Column(name = "my_tags")
    private String my_tags;

    // Getters and Setters

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMy_score() {
        return my_score;
    }

    public void setMy_score(String my_score) {
        this.my_score = my_score;
    }

    public String getMy_last_updated() {
        return my_last_updated;
    }

    public void setMy_last_updated(String my_last_updated) {
        this.my_last_updated = my_last_updated;
    }

    public String getMy_start_date() {
        return my_start_date;
    }

    public void setMy_start_date(String my_start_date) {
        this.my_start_date = my_start_date;
    }

    public String getMy_rewatching() {
        return my_rewatching;
    }

    public void setMy_rewatching(String my_rewatching) {
        this.my_rewatching = my_rewatching;
    }

    public String getMy_rewatching_ep() {
        return my_rewatching_ep;
    }

    public void setMy_rewatching_ep(String my_rewatching_ep) {
        this.my_rewatching_ep = my_rewatching_ep;
    }

    public String getMy_finish_date() {
        return my_finish_date;
    }

    public void setMy_finish_date(String my_finish_date) {
        this.my_finish_date = my_finish_date;
    }

    public String getMy_watched_episodes() {
        return my_watched_episodes;
    }

    public void setMy_watched_episodes(String my_watched_episodes) {
        this.my_watched_episodes = my_watched_episodes;
    }

    public String getMy_status() {
        return my_status;
    }

    public void setMy_status(String my_status) {
        this.my_status = my_status;
    }

    public String getMy_tags() {
        return my_tags;
    }

    public void setMy_tags(String my_tags) {
        this.my_tags = my_tags;
    }
}
