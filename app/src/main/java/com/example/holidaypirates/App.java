package com.example.holidaypirates;

import android.app.Application;

import com.example.holidaypirates.network.APIModule;
import com.example.holidaypirates.postDetail.DetailModule;
import com.example.holidaypirates.posts.PostsModule;
import com.example.holidaypirates.repository.RepositoryModule;

import timber.log.Timber;

public class App extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        initTimber();

        initDagger();
    }

    private void initDagger() {
        final AppModule appModule = new AppModule(this);
        final APIModule apiModule = new APIModule();
        final RepositoryModule repositoryModule = new RepositoryModule(apiModule.provideApiService());

        final PostsModule postsModule = new PostsModule();
        final DetailModule detailModule = new DetailModule();

        component = DaggerAppComponent.builder()
                .appModule(appModule)
                .aPIModule(apiModule)
                .repositoryModule(repositoryModule)
                .postsModule(postsModule)
                .detailModule(detailModule)
                .build();
    }

    public AppComponent getAppComponent() {
        return component;
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
