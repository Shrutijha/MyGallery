package com.shrutijha.mygallery.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

public class Feed {
    @SerializedName("download_url")
    public String imageurl;
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView,String imagepath){
        Glide.with(imageView.getContext()).load(imagepath).into(imageView);
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