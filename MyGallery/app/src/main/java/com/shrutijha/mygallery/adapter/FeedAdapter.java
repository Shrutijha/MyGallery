package com.shrutijha.mygallery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shrutijha.mygallery.R;
import com.shrutijha.mygallery.databinding.ImageLayoutBinding;
import com.shrutijha.mygallery.model.Feed;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private List<Feed>feedList;
    private LayoutInflater layoutInflater;

    public FeedAdapter(List<Feed> feedList) {
        this.feedList = feedList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ImageLayoutBinding dataBinding= DataBindingUtil.inflate(layoutInflater, R.layout.image_layout, parent, false);
        return new ViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Feed feed=feedList.get(position);
        holder.feedDataBinding.setFeed(feed);
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageLayoutBinding feedDataBinding;

        public ViewHolder(final ImageLayoutBinding feedbind) {
            super(feedbind.getRoot());
            this.feedDataBinding=feedbind;
        }
    }
}