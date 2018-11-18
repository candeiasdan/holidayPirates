package com.example.holidaypirates.posts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.holidaypirates.App;
import com.example.holidaypirates.R;
import com.example.holidaypirates.postDetail.DetailActivity;
import com.example.holidaypirates.posts.viewModel.PostVM;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PostsActivity extends AppCompatActivity implements PostsMVP.View, PostClickCallback {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.viewLoading)
    ViewGroup loadingView;

    @BindView(R.id.viewError)
    ViewGroup errorView;

    @Inject
    PostsMVP.Presenter presenter;

    private PostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((App) getApplication())
                .getAppComponent()
                .inject(this);

        adapter = new PostsAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        loadingView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        loadingView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayData(List<PostVM> posts) {
        loadingView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        adapter.setPosts(posts);
    }

    @OnClick(R.id.btnRetry)
    public void onButtonRetryClick() {
        presenter.loadPosts();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadPosts();
    }

    @Override
    public void onPostClick(PostVM post) {
        Intent intent = new Intent(PostsActivity.this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("post", post);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
