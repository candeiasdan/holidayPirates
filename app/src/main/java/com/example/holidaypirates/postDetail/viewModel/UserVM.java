package com.example.holidaypirates.postDetail.viewModel;

public class UserVM {

    private final String username;
    private final String website;

    public UserVM(String username, String website) {
        this.username = username;
        this.website = website;
    }

    public String getUsername() {
        return username;
    }

    public String getWebsite() {
        return website;
    }
}
