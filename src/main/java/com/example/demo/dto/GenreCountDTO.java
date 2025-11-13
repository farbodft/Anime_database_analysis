package com.example.demo.dto;

public class GenreCountDTO {
    private String genre;
    private long count;

    public GenreCountDTO() {}

    public GenreCountDTO(String genre, long count) {
        this.genre = genre;
        this.count = count;
    }

    public String getGenre() {
        return genre;
    }

    public long getCount() {
        return count;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
