package com.example.holidaypirates;

import com.example.holidaypirates.network.APIModule;
import com.example.holidaypirates.postDetail.DetailActivity;
import com.example.holidaypirates.postDetail.DetailModule;
import com.example.holidaypirates.posts.PostsActivity;
import com.example.holidaypirates.posts.PostsModule;
import com.example.holidaypirates.repository.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, PostsModule.class, APIModule.class, DetailModule.class, RepositoryModule.class})
public interface AppComponent {
    void inject(PostsActivity postsActivity);

    void inject(DetailActivity detailActivity);
}
