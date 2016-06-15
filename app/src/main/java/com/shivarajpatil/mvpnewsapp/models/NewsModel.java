package com.shivarajpatil.mvpnewsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SYS on 31-May-2016.
 */

public class NewsModel {

    @SerializedName("news")
    @Expose
    private List<NewsDetailsModel> news = new ArrayList<NewsDetailsModel>();

    /**
     *
     * @return
     * The news
     */
    public List<NewsDetailsModel> getNews() {
        return news;
    }

    /**
     *
     * @param news
     * The news
     */
    public void setNews(List<NewsDetailsModel> news) {
        this.news = news;
    }

}

