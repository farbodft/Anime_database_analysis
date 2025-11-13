package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_list")

public class User {
    // All attributes are Text so we use String
    @Column(name = "user_id")
    private String user_id;

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "stats_rewatched")
    private String stats_rewatched;

    @Column(name = "user_days_spent_watching")
    private String user_days_spent_watching;

    @Column(name = "join_date")
    private String join_date;

    @Column(name = "access_rank")
    private String access_rank;

    @Column(name = "last_online")
    private String last_online;

    @Column(name = "stats_episodes")
    private String stats_episodes;

    @Column(name = "user_onhold")
    private String user_onhold;

    @Column(name = "location")
    private String location;

    @Column(name = "user_dropped")
    private String user_dropped;

    @Column(name = "stats_mean_score")
    private String stats_mean_score;

    @Column(name = "user_completed")
    private String user_completed;

    @Column(name = "user_plantowatch")
    private String user_plantowatch;

    @Column(name = "birth_date")
    private String birth_date;

    @Column(name = "gender")
    private String gender;

    @Column(name = "user_watching")
    private String user_watching;

    // Getters and Setters

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStats_rewatched() {
        return stats_rewatched;
    }

    public void setStats_rewatched(String stats_rewatched) {
        this.stats_rewatched = stats_rewatched;
    }

    public String getUser_days_spent_watching() {
        return user_days_spent_watching;
    }

    public void setUser_days_spent_watching(String user_days_spent_watching) {
        this.user_days_spent_watching = user_days_spent_watching;
    }

    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }

    public String getAccess_rank() {
        return access_rank;
    }

    public void setAccess_rank(String access_rank) {
        this.access_rank = access_rank;
    }

    public String getLast_online() {
        return last_online;
    }

    public void setLast_online(String last_online) {
        this.last_online = last_online;
    }

    public String getStats_episodes() {
        return stats_episodes;
    }

    public void setStats_episodes(String stats_episodes) {
        this.stats_episodes = stats_episodes;
    }

    public String getUser_onhold() {
        return user_onhold;
    }

    public void setUser_onhold(String user_onhold) {
        this.user_onhold = user_onhold;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUser_dropped() {
        return user_dropped;
    }

    public void setUser_dropped(String user_dropped) {
        this.user_dropped = user_dropped;
    }

    public String getStats_mean_score() {
        return stats_mean_score;
    }

    public void setStats_mean_score(String stats_mean_score) {
        this.stats_mean_score = stats_mean_score;
    }

    public String getUser_completed() {
        return user_completed;
    }

    public void setUser_completed(String user_completed) {
        this.user_completed = user_completed;
    }

    public String getUser_plantowatch() {
        return user_plantowatch;
    }

    public void setUser_plantowatch(String user_plantowatch) {
        this.user_plantowatch = user_plantowatch;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUser_watching() {
        return user_watching;
    }

    public void setUser_watching(String user_watching) {
        this.user_watching = user_watching;
    }
}

