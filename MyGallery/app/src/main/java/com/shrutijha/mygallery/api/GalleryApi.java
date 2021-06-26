package com.shrutijha.mygallery.api;
import com.shrutijha.mygallery.model.Feed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GalleryApi {
    @GET("androidweb.php")
    Call<List<Feed>> geImgData();
}