package com.example.holidaypirates.repository;

import android.support.annotation.NonNull;

import com.example.holidaypirates.network.APIService;
import com.example.holidaypirates.network.model.Album;
import com.example.holidaypirates.network.model.Comment;
import com.example.holidaypirates.network.model.Photo;
import com.example.holidaypirates.network.model.Post;
import com.example.holidaypirates.network.model.User;

import java.util.List;

import io.reactivex.Observable;

public class PostsRepository implements Repository {

    private APIService apiService;

    PostsRepository(APIService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<List<Post>> getPosts() {
        return apiService.getListOfPosts();
    }

    @Override
    public Observable<Post> getPost(@NonNull Long postId) {
        return apiService.getPost(postId);
    }

    @Override
    public Observable<List<Comment>> getCommentsForPost(@NonNull Long postId) {
        return apiService.getComments(postId);
    }

    @Override
    public Observable<User> getUser(@NonNull Long userId) {
        return apiService.getUser(userId);
    }

    @Override
    public Observable<List<Album>> getUserAlbums(@NonNull Long userId) {
        return apiService.getUserAlbums(userId);
    }

    @Override
    public Observable<List<Photo>> getAlbumPhotos(@NonNull Long albumId) {
        return apiService.getAlbumPhotos(albumId);
    }
}