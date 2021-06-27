package com.shrutijha.mygallery.api;
import com.shrutijha.mygallery.model.Feed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GalleryApi {
    @GET("list?page=1")
    Call<List<Feed>> getImgData();
}