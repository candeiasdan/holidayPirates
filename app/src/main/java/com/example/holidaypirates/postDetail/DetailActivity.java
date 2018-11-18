package com.example.holidaypirates.postDetail;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.holidaypirates.App;
import com.example.holidaypirates.R;
import com.example.holidaypirates.postDetail.adapter.CommentsAdapter;
import com.example.holidaypirates.postDetail.adapter.PhotosAdapter;
import com.example.holidaypirates.postDetail.viewModel.CommentVM;
import com.example.holidaypirates.postDetail.viewModel.PhotoVM;
import com.example.holidaypirates.postDetail.viewModel.PostDetailVM;
import com.example.holidaypirates.postDetail.viewModel.UserVM;
import com.example.holidaypirates.posts.viewModel.PostVM;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailMVP.View {

    @BindView(R.id.tvUser_username)
    TextView tvUsername;

    @BindView(R.id.tvUser_website)
    TextView tvUserWebsite;

    @BindView(R.id.recyclerView_photos)
    RecyclerView recyclerViewPhotos;

    @BindView(R.id.recyclerView_comments)
    RecyclerView recyclerViewComments;

    @Inject
    DetailMVP.Presenter presenter;

    PhotosAdapter photosAdapter;
    CommentsAdapter commentsAdapter;

    PostVM post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        ((App) getApplication())
                .getAppComponent()
                .inject(this);

        readArguments();

        recyclerViewPhotos.setLayoutManager(new GridLayoutManager(this, 2));
        photosAdapter = new PhotosAdapter(getBaseContext());
        recyclerViewPhotos.setAdapter(photosAdapter);

        recyclerViewComments.setLayoutManager(new LinearLayoutManager(this));
        commentsAdapter = new CommentsAdapter();
        recyclerViewComments.setAdapter(commentsAdapter);
    }

    private void readArguments() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            post = (PostVM) bundle.getSerializable("post");
        }
    }

    @Override
    public void displayPostDetails(PostDetailVM postDetail) {
        final UserVM user = postDetail.getUser();
        if (user != null) {
            tvUsername.setText(user.getUsername());
            tvUserWebsite.setText(user.getWebsite());
        }

        final List<PhotoVM> photos = postDetail.getPhotos();
        if (photos != null) {
            photosAdapter.setPhotos(photos);
        }

        final List<CommentVM> comments = postDetail.getComments();
        if (comments != null) {
            commentsAdapter.setComments(comments);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadPostDetails(post);
    }
}