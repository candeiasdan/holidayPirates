package com.example.holidaypirates.postDetail;


import com.example.holidaypirates.postDetail.viewModel.PostDetailVM;
import com.example.holidaypirates.posts.viewModel.PostVM;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface DetailMVP {
    interface View {
        void displayPostDetails(PostDetailVM postDetail);
    }

    interface Presenter {
        void setView(DetailMVP.View view);

        void loadPostDetails(PostVM post);
    }

    interface Model {
        Single<PostDetailVM> getPostDetails(PostVM post);
    }
}
