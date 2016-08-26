package com.shivarajpatil.mvpnewsapp.presenter;

import com.shivarajpatil.mvpnewsapp.listeners.LoginInterface;

/**
 * Created by SYS on 26-Aug-2016.
 */

public class LoginPresenter {

    LoginInterface loginInterface;

    public LoginPresenter(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

    public void doLogin(String email, String pwd) {
        if (email.equals("shivaraj") && pwd.equals("password123")) {
            loginInterface.loginSuccess();
        } else {
            loginInterface.loginFailed("Wrong credentials");
        }
    }
}
