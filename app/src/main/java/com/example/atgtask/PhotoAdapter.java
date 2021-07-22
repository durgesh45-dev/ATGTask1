package com.example.atgtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private ArrayList<PhotoSources> photoSourcesArrayList;
    private Context context;

    //constructor
    public PhotoAdapter(ArrayList<PhotoSources> photosrcs, Context mContext) {
        this.photoSourcesArrayList = photosrcs;
        this.context = mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;

        public ViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.img);
        }

        public ImageView getImage() {
            return this.image;
        }
    }

    @NotNull
    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallary_item, parent, false);
//        v.setLayoutParams(new RecyclerView.LayoutParams(1080, 800));
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Glide.with(this.context)
                .load(photoSourcesArrayList.get(position).getUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.getImage());
    }

    @Override
    public int getItemCount() {
        return photoSourcesArrayList.size();
    }

}
