package com.example.holidaypirates.posts.viewModel;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class PostVM implements Serializable {
    private Long id;
    private String title;
    private String description;

    public PostVM(@NonNull final Long id, @NonNull final String title, @NonNull final String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getDescription() {
        return description;
    }
}
