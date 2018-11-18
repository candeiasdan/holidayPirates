package com.example.holidaypirates.posts;

import com.example.holidaypirates.repository.Repository;
import com.example.holidaypirates.repository.RepositoryModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = RepositoryModule.class)
public class PostsModule {

    @Provides
    @Singleton
    public PostsMVP.Presenter providePresenter(PostsMVP.Model model) {
        return new PostsPresenter(model);
    }

    @Provides
    public PostsMVP.Model provideModel(Repository repository) {
        return new PostsModel(repository);
    }

}