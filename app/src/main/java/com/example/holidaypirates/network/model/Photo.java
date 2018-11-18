package com.example.holidaypirates.network.model;

public class Photo {
    private Long id;
    private Long albumId;
    private String title;
    private String thumbnailUrl;
    private String url;

    public Long getId() {
        return id;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getUrl() {
        return url;
    }
}
