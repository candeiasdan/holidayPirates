package com.example.holidaypirates.network.model;

public class Comment {
    private Long id;
    private Long postId;
    private String name;
    private String email;
    private String body;

    public Long getId() {
        return id;
    }

    public Long getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
