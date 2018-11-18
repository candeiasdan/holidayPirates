package com.example.holidaypirates.postDetail;

import com.example.holidaypirates.repository.Repository;
import com.example.holidaypirates.repository.RepositoryModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = RepositoryModule.class)
public class DetailModule {

    @Provides
    @Singleton
    public DetailMVP.Presenter providePresenter(DetailMVP.Model model) {
        return new DetailPresenter(model);
    }

    @Provides
    public DetailMVP.Model provideModel(Repository repository) {
        return new DetailModel(repository);
    }
}