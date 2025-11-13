package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserAnimeId implements Serializable {
    private Anime anime;
    private User user;

    public UserAnimeId() {}

    public UserAnimeId(Anime anime, User user) {
        this.anime = anime;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAnimeId that)) return false;
        return Objects.equals(anime, that.anime) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anime, user);
    }
}
