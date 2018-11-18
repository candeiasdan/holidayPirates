package com.example.holidaypirates.posts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.holidaypirates.R;
import com.example.holidaypirates.posts.viewModel.PostVM;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private final PostClickCallback clickCallback;
    private List<PostVM> posts;

    PostsAdapter(PostClickCallback clickCallback) {
        this.clickCallback = clickCallback;
    }

    public void setPosts(List<PostVM> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(v, clickCallback);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        if (posts != null) {
            viewHolder.bind(posts.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        if (posts != null) {
            return posts.size();

        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.tvBody)
        TextView tvBody;

        PostClickCallback clickCallback;

        public ViewHolder(View itemView, PostClickCallback clickCallback) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            this.clickCallback = clickCallback;
        }

        public void bind(PostVM post, int position) {
            if (position % 2 == 0) {
                itemView.setBackgroundResource(R.color.even_post_bg);
            } else {
                itemView.setBackgroundResource(R.color.odd_post_bg);
            }

            tvTitle.setText(post.getTitle());
            tvBody.setText(post.getDescription());

            itemView.setOnClickListener(view -> {
                if (clickCallback != null) {
                    clickCallback.onPostClick(post);
                }
            });
        }
    }
}