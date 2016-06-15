package com.shivarajpatil.mvpnewsapp.presenter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shivarajpatil.mvpnewsapp.models.NewsDetailsModel;
import com.shivarajpatil.mvpnewsapp.models.NewsModel;
import com.shivarajpatil.mvpnewsapp.apis.GetNewsAPI;
import com.shivarajpatil.mvpnewsapp.listeners.UpdateNewsListener;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SYS on 31-May-2016.
 */
public class NewsHeadlinesPresenter {

    private static final String BASE_URL = "https://gist.githubusercontent.com/shivarajp/1eec28ad8a0083e44faf17927cccaebf/raw/7c398dcb27fe732cd957dbcc3b39da1fa1ea2b55/";
    private UpdateNewsListener updateListener;
    private Retrofit retrofit;
    private Gson gson;
    private GetNewsAPI getNewsAPI;

    public NewsHeadlinesPresenter(UpdateNewsListener updateListener) {
        this.updateListener = updateListener;
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        getNewsAPI = retrofit.create(GetNewsAPI.class);

    }

    public void loadNews() {
        if (getNewsAPI != null) {
            Call<NewsModel> call = getNewsAPI.getNews();
            call.enqueue(new Callback<NewsModel>() {
                @Override
                public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                    NewsModel newsModels = response.body();
                    updateListener.onUpdateNews((ArrayList<NewsDetailsModel>) newsModels.getNews());
                }

                @Override
                public void onFailure(Call<NewsModel> call, Throwable t) {
                    updateListener.onFailure(t.getMessage());
                }
            });
        }
    }
}
