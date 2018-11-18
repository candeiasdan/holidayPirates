package com.example.holidaypirates.posts;

import com.example.holidaypirates.posts.viewModel.PostVM;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostsPresenter implements PostsMVP.Presenter {

    private final PostsMVP.Model model;
    private PostsMVP.View view;

    public PostsPresenter(final PostsMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(PostsMVP.View view) {
        this.view = view;
    }

    @Override
    public void loadPosts() {
        view.showLoading();
        model.getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<List<PostVM>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<PostVM> postVMS) {
                        if (view != null) {
                            view.displayData(postVMS);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            view.showError();
                        }
                    }
                });

    }
}
