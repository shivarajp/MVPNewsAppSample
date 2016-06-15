package com.shivarajpatil.mvpnewsapp.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shivarajpatil.mvpnewsapp.R;
import com.shivarajpatil.mvpnewsapp.models.NewsDetailsModel;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NewsDetailsActivity extends AppCompatActivity {

    @InjectView(R.id.ivPhoto)
    ImageView ivPhoto;
    @InjectView(R.id.tvHeadLine)
    TextView tvHeadLine;
    @InjectView(R.id.tvDetails)
    TextView tvDetails;
    private NewsDetailsModel newsDetailsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.inject(this);
        newsDetailsModel = (NewsDetailsModel) getIntent()
                .getSerializableExtra("newsDetailsModel");
        setViews();
    }

    private void setViews() {
        Glide.with(this).load(newsDetailsModel.getAvatarUrl()).into(ivPhoto);
        tvHeadLine.setText(newsDetailsModel.getHeadline());
        tvDetails.setText(newsDetailsModel.getDetails());
    }
}
