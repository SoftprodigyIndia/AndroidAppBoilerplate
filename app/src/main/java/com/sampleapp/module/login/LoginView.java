package com.sampleapp.module.login;

import com.sampleapp.mvpbase.MvpView;

/**
 * contains methods to perform action via presenter
 */
interface LoginView extends MvpView {
    void onLoginSuccess();
}
