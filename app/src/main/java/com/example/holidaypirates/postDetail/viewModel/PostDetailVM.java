package com.example.holidaypirates.postDetail.viewModel;

import com.example.holidaypirates.network.model.Comment;
import com.example.holidaypirates.network.model.User;

import java.util.List;

public class PostDetailVM {
    private final String title;
    private final String body;
    private UserVM user;
    private List<CommentVM> comments;
    private List<PhotoVM> photos;

    public PostDetailVM(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public UserVM getUser() {
        return user;
    }

    public List<CommentVM> getComments() {
        return comments;
    }

    public void setUser(UserVM user) {
        this.user = user;
    }

    public void setComments(List<CommentVM> comments) {
        this.comments = comments;
    }

    public List<PhotoVM> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoVM> photos) {
        this.photos = photos;
    }
}
