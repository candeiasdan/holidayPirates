package com.example.holidaypirates.postDetail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.holidaypirates.customView.SquareImageView;
import com.example.holidaypirates.postDetail.viewModel.PhotoVM;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {
    private List<PhotoVM> photos = new ArrayList<>();
    private final Context context;

    public PhotosAdapter(Context context) {
        this.context = context;
    }

    public void setPhotos(List<PhotoVM> photos) {
        this.photos.clear();
        this.photos.addAll(photos);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(new SquareImageView(context));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(photos.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(SquareImageView itemView) {
            super(itemView);
        }

        void bind(String url) {
            Picasso.get()
                    .load(url)
                    .into((SquareImageView) itemView);
        }
    }
}