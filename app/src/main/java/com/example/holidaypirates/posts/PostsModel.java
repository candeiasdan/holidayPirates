package com.example.holidaypirates.posts;

import com.example.holidaypirates.posts.viewModel.PostVM;
import com.example.holidaypirates.repository.Repository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class PostsModel implements PostsMVP.Model {

    private final Repository repository;

    PostsModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Single<List<PostVM>> getPosts() {
        return Single.fromObservable(repository.getPosts().flatMap(list ->
                Observable.fromIterable(list)
                        .map(item -> new PostVM(item.getId(), item.getTitle(), item.getBody()))
                        .toList()
                        .toObservable()
        ));
    }
}
