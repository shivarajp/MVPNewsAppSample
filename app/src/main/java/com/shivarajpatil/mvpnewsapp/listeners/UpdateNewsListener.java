package com.shivarajpatil.mvpnewsapp.listeners;

import com.shivarajpatil.mvpnewsapp.models.NewsDetailsModel;

import java.util.ArrayList;

/**
 * Created by Shivaraj on 01-Jun-2016.
 */

public interface UpdateNewsListener {

    public void onUpdateNews(ArrayList<NewsDetailsModel> newsModels);
    public void onFailure(String error);
}
