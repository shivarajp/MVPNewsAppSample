package com.shivarajpatil.mvpnewsapp.listeners;

/**
 * Created by SYS on 26-Aug-2016.
 */

public interface LoginInterface {
    
    public void loginSuccess();

    public void loginFailed(String error);
}
