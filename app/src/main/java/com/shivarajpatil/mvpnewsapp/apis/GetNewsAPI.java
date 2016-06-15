package com.shivarajpatil.mvpnewsapp.apis;

import com.shivarajpatil.mvpnewsapp.models.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by SYS on 01-Jun-2016.
 */

public interface GetNewsAPI {

    @GET("news")
    Call<NewsModel> getNews();
}
