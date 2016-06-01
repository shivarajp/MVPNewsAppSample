package com.shivarajpatil.mvpnewsapp.view.adpaters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shivarajpatil.mvpnewsapp.R;
import com.shivarajpatil.mvpnewsapp.models.NewsModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by SYS on 31-May-2016.
 */
public class NewsheadlinesAdapter extends RecyclerView.Adapter<NewsheadlinesAdapter.ViewHolder> {

    private ArrayList<NewsModel> newsModels = new ArrayList<NewsModel>();
    private Context mContext;

    public NewsheadlinesAdapter(Context mContext, ArrayList<NewsModel> newsModels) {
        this.mContext = mContext;
        this.newsModels = newsModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_headline_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext)
                .load(newsModels.get(position).getNews().get(position).getAvatarUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivNewsIcon);
        holder.tvNewsHeading.setText(newsModels.get(position).getNews().get(position).getHeadline());
    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivNewsIcon;
        public TextView tvNewsHeading;

        public ViewHolder(View itemView) {
            super(itemView);
            ivNewsIcon = (ImageView) itemView.findViewById(R.id.ivNewsIcon);
            tvNewsHeading = (TextView) itemView.findViewById(R.id.tvNewsHeading);
        }
    }
}
