package com.shivarajpatil.mvpnewsapp.views;

import android.support.test.espresso.IdlingResource;

/**
 * Created by SYS on 26-Aug-2016.
 */

class LoginIdlingResource implements IdlingResource {
    private long startTime = 0;
    private long waitingTime = 0;
    private ResourceCallback resourceCallback;

    public LoginIdlingResource(long waitingTime) {
        this.startTime = System.currentTimeMillis();
        this.waitingTime = waitingTime;
    }

    @Override
    public String getName() {
        return LoginIdlingResource.class.getName();
    }

    @Override
    public boolean isIdleNow() {
        long elapsed = System.currentTimeMillis() - startTime;
        boolean idle = (elapsed >= waitingTime);
        if (idle) {
            resourceCallback.onTransitionToIdle();
        }
        return idle;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }

}
