package com.example.holidaypirates.repository;

import android.support.annotation.NonNull;

import com.example.holidaypirates.network.model.Album;
import com.example.holidaypirates.network.model.Comment;
import com.example.holidaypirates.network.model.Photo;
import com.example.holidaypirates.network.model.Post;
import com.example.holidaypirates.network.model.User;

import java.util.List;

import io.reactivex.Observable;

public interface Repository {

    Observable<List<Post>> getPosts();

    Observable<Post> getPost(@NonNull Long postId);

    Observable<List<Comment>> getCommentsForPost(@NonNull Long postId);

    Observable<User> getUser(@NonNull Long userId);

    Observable<List<Album>> getUserAlbums(@NonNull Long userId);

    Observable<List<Photo>> getAlbumPhotos(@NonNull Long albumId);
}
