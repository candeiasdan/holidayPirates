package com.example.holidaypirates.posts;

import com.example.holidaypirates.posts.viewModel.PostVM;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface PostsMVP {
    interface View {
        void showLoading();

        void displayData(List<PostVM> posts);

        void showError();
    }

    interface Presenter {
        void setView(PostsMVP.View view);

        void loadPosts();
    }

    interface Model {
        Single<List<PostVM>> getPosts();
    }
}
