package com.shivarajpatil.mvpnewsapp.presenter;

import com.shivarajpatil.mvpnewsapp.models.NewsDetailsModel;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by SYS on 31-May-2016.
 */
public class NewsDetailsPresenter {

    public void loadNewsDetails(NewsDetailsModel mNewsDetailsModel) {
        EventBus.getDefault().post(mNewsDetailsModel);
    }
}
