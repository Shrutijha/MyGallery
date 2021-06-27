package com.shrutijha.mygallery.api;

import android.content.Context;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit=null;
    private static final String BASE_URL = "https://picsum.photos/v2/";
    public static Retrofit getRetrofitInstance(Context context){
        if (retrofit == null) {
            int cacheSize = 10 * 1024 * 1024; // 10 MB
            Cache cache = new Cache(context.getCacheDir(), cacheSize);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .cache(cache)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}