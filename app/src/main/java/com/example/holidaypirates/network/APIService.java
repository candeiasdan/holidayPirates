package com.example.holidaypirates.network;

import com.example.holidaypirates.network.model.Album;
import com.example.holidaypirates.network.model.Comment;
import com.example.holidaypirates.network.model.Photo;
import com.example.holidaypirates.network.model.Post;
import com.example.holidaypirates.network.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("posts")
    Observable<List<Post>> getListOfPosts();

    @GET("posts/{postId}")
    Observable<Post> getPost(@Path("postId") Long postId);

    @GET("users/{userId}")
    Observable<User> getUser(@Path("userId") Long userId);

    @GET("comments")
    Observable<List<Comment>> getComments(@Query("postId") Long posterId);

    @GET("albums")
    Observable<List<Album>> getUserAlbums(@Query("userId") Long userId);

    @GET("photos")
    Observable<List<Photo>> getAlbumPhotos(@Query("albumId") Long albumId);
}
