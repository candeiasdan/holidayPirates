package com.example.holidaypirates.repository;

import com.example.holidaypirates.network.APIService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    APIService apiService;

    @Singleton
    public RepositoryModule(APIService apiService) {
        this.apiService = apiService;
    }

    @Provides
    @Singleton
    public Repository provideRepository() {
        return new PostsRepository(apiService);
    }

}