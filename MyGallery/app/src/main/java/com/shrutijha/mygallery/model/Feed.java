package com.shrutijha.mygallery.model;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.google.gson.annotations.SerializedName;
import com.shrutijha.mygallery.GlideImageLoader;
import com.shrutijha.mygallery.R;
import com.squareup.picasso.Picasso;

public class Feed {
    @SerializedName("download_url")
    public String imageurl;
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String imagepath){
//        RequestOptions options = new RequestOptions()
//                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.drawable.outline_refresh_24)
//                .error(R.drawable.outline_error_24)
//                .priority(Priority.HIGH);
//
//        new GlideImageLoader(imageView,progressBar).load(imagepath,options);
        Glide.with(imageView.getContext()).load(imagepath).diskCacheStrategy(DiskCacheStrategy.ALL).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                imageView.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                imageView.setVisibility(View.VISIBLE);
                return false;
            }
        }).into(imageView);

    }

    public Feed(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

}