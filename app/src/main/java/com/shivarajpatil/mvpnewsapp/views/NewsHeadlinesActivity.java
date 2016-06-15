package com.shivarajpatil.mvpnewsapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.shivarajpatil.mvpnewsapp.R;
import com.shivarajpatil.mvpnewsapp.models.NewsDetailsModel;
import com.shivarajpatil.mvpnewsapp.presenter.NewsHeadlinesPresenter;
import com.shivarajpatil.mvpnewsapp.listeners.UpdateNewsListener;
import com.shivarajpatil.mvpnewsapp.views.adpaters.NewsHeadlinesAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NewsHeadlinesActivity extends AppCompatActivity implements UpdateNewsListener {

    @InjectView(R.id.rvNewsHeadlines)
    RecyclerView rvNewsHeadlines;
    private NewsHeadlinesPresenter headlinesPresenter;
    private NewsHeadlinesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.inject(this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvNewsHeadlines.setLayoutManager(mLayoutManager);
        rvNewsHeadlines.setItemAnimator(new DefaultItemAnimator());
        headlinesPresenter = new NewsHeadlinesPresenter(this);
        headlinesPresenter.loadNews();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void showNewsDetailsEvent(NewsDetailsModel newsDetailsModel){
        Intent newsDetailsIntent = new Intent(NewsHeadlinesActivity.this,NewsDetailsActivity.class);
        newsDetailsIntent.putExtra("newsDetailsModel",newsDetailsModel);
        startActivity(newsDetailsIntent);
    }

    @Override
    public void onUpdateNews(ArrayList<NewsDetailsModel> newsModels) {
        adapter = new NewsHeadlinesAdapter(NewsHeadlinesActivity.this, newsModels);
        rvNewsHeadlines.setAdapter(adapter);
    }

    @Override
    public void onFailure(String error) {
        showToast(error);
    }

    private void showToast(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
