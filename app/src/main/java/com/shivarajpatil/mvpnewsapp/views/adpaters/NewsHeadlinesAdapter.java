package com.shivarajpatil.mvpnewsapp.views.adpaters;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shivarajpatil.mvpnewsapp.R;
import com.shivarajpatil.mvpnewsapp.models.NewsDetailsModel;
import com.shivarajpatil.mvpnewsapp.presenter.NewsDetailsPresenter;
import com.shivarajpatil.mvpnewsapp.views.NewsHeadlinesActivity;

import java.util.List;

/**
 * Created by Shivaraj on 31-May-2016.
 */
public class NewsHeadlinesAdapter extends RecyclerView.Adapter<NewsHeadlinesAdapter.ViewHolder> {

    private List<NewsDetailsModel> newsModels;
    private Context mContext;
    private NewsDetailsPresenter newsDetailsPresenter;

    public NewsHeadlinesAdapter(NewsHeadlinesActivity callback, List<NewsDetailsModel> newsModels) {
        this.mContext = callback;
        this.newsModels = newsModels;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_headline_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext)
                .load(newsModels.get(position).getAvatarUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivNewsIcon);
        holder.tvNewsHeading.setText(newsModels.get(position).getHeadline());
        holder.clNewsRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsDetailsPresenter = new NewsDetailsPresenter();
                newsDetailsPresenter.loadNewsDetails(newsModels.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivNewsIcon;
        public TextView tvNewsHeading;
        public ConstraintLayout clNewsRowContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            ivNewsIcon = (ImageView) itemView.findViewById(R.id.ivNewsIcon);
            tvNewsHeading = (TextView) itemView.findViewById(R.id.tvNewsHeading);
            clNewsRowContainer = (ConstraintLayout) itemView.findViewById(R.id.clNewsRowContainer);
        }
    }
}
