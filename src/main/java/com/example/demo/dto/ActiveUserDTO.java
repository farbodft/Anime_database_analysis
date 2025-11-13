package com.example.demo.dto;

public class ActiveUserDTO {
    private String username;
    private String daysSpent;

    public ActiveUserDTO() {}

    public ActiveUserDTO(String username, String daysSpent) {
        this.username = username;
        this.daysSpent = daysSpent;
    }

    public String getUsername() {
        return username;
    }

    public String getDaysSpent() {
        return daysSpent;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDaysSpent(String daysSpent) {
        this.daysSpent = daysSpent;
    }
}
