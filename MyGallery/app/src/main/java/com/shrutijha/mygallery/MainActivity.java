package com.shrutijha.mygallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shrutijha.mygallery.adapter.FeedAdapter;
import com.shrutijha.mygallery.api.GalleryApi;
import com.shrutijha.mygallery.api.RetrofitInstance;
import com.shrutijha.mygallery.databinding.ActivityMainBinding;
import com.shrutijha.mygallery.model.Feed;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    GalleryApi myApi;
    private List<Feed>feedList;
    FeedAdapter feedAdapter;
    ActivityMainBinding  binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.feedRec.setLayoutManager(new GridLayoutManager(this,2));
        binding.feedRec.setHasFixedSize(true);
        getdata();

    }

    private void getdata() {
        myApi=RetrofitInstance.getRetrofitInstance().create(GalleryApi.class);
        Call<List<Feed>>call=myApi.getImgData();
        call.enqueue(new Callback<List<Feed>>() {
            @Override
            public void onResponse(Call<List<Feed>> call, Response<List<Feed>> response) {
                feedList=response.body();
                feedAdapter=new FeedAdapter(feedList);
                binding.feedRec.setAdapter(feedAdapter);
            }

            @Override
            public void onFailure(Call<List<Feed>> call, Throwable t) {

            }
        });
    }
}