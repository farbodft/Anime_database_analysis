package com.example.demo.dto;

public class TopUserDTO {
    private String username;
    private String meanScore;

    public TopUserDTO() {}

    public TopUserDTO(String username, String meanScore) {
        this.username = username;
        this.meanScore = meanScore;
    }

    public String getUsername() {
        return username;
    }

    public String getMeanScore() {
        return meanScore;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMeanScore(String meanScore) {
        this.meanScore = meanScore;
    }
}
