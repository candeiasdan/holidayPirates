package com.example.holidaypirates.postDetail;

import com.example.holidaypirates.postDetail.viewModel.PostDetailVM;
import com.example.holidaypirates.posts.viewModel.PostVM;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailPresenter implements DetailMVP.Presenter {

    private final DetailMVP.Model model;
    private DetailMVP.View view;

    public DetailPresenter(final DetailMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(DetailMVP.View view) {
        this.view = view;
    }

    @Override
    public void loadPostDetails(PostVM post) {
        model.getPostDetails(post)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<PostDetailVM>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onSuccess(PostDetailVM postDetailVM) {
                                   if (view != null) {
                                       view.displayPostDetails(postDetailVM);
                                   }
                               }

                               @Override
                               public void onError(Throwable e) {
                                   //TODO - handle error
                               }
                           }
                );
    }

}
