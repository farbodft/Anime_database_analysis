package com.example.demo.dto;

public class SimilarUserDTO {
    private String username;
    private long sharedCount;

    public SimilarUserDTO() {}

    public SimilarUserDTO(String username, long sharedCount) {
        this.username = username;
        this.sharedCount = sharedCount;
    }

    public String getUsername() {
        return username;
    }

    public long getSharedCount() {
        return sharedCount;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSharedCount(long sharedCount) {
        this.sharedCount = sharedCount;
    }
}
