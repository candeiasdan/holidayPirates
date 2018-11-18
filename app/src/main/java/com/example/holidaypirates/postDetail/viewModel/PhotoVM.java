package com.example.holidaypirates.postDetail.viewModel;

public class PhotoVM {
    private final String thumbnail;
    private final String url;

    public PhotoVM(String thumbail, String url) {
        this.thumbnail = thumbail;
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getUrl() {
        return url;
    }
}
