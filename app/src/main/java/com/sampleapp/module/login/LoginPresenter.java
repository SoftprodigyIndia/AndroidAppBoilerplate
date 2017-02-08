package com.sampleapp.module.login;

import android.content.Context;

import com.google.gson.Gson;
import com.sampleapp.api.NetModule;
import com.sampleapp.api.RestService;
import com.sampleapp.constants.ApiConstants;
import com.sampleapp.constants.ValueConstants;
import com.sampleapp.mvpbase.BasePresenter;
import com.sampleapp.utils.PreferenceManager;
import com.sampleapp.utils.UtilsModule;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Scheduler;

/**
 * Presenter class for {@link LoginActivity}
 * Contains all the business logic for main activity including API calls
 */
class LoginPresenter extends BasePresenter<LoginView> {

    //Injecting dependencies required  by our presenter
    @Inject
    @Named(ValueConstants.MAIN_THREAD)
    Scheduler mMainThread;

    @Inject
    @Named(ValueConstants.NEW_THREAD)
    Scheduler mNewThread;

    @Inject
    RestService mRestService;

    @Inject
    PreferenceManager mPrefs;


    LoginPresenter(Context context) {
        //creating component for injections
        DaggerLoginPresenterComponent.builder()
                .netModule(new NetModule())
                .utilsModule(new UtilsModule(context)).build().inject(this);
    }

    /**
     * login user API method using retrofit and Rx java
     * after successful login save data to SharedPreferences for easy access in app
     *
     * @param userName username of user
     * @param password password of user
     */
    void loginUser(String userName, String password) {
        getMvpView().showProgress();

        mRestService.login(userName, password).
                subscribeOn(mNewThread).
                observeOn(mMainThread).
                subscribe(loginResponse -> {
                    if (isViewAttached()) {
                        getMvpView().hideProgress();
                        if (loginResponse.getResponse().getResult() == ApiConstants.STATUS_SUCCESS) {
                            mPrefs.setUserLoggedIn(true);
                            mPrefs.setUserData(new Gson().toJson(loginResponse.getResponse()));
                            getMvpView().onLoginSuccess();
                        } else {
                            getMvpView().onException(loginResponse.getResponse().getErrorMSG());
                        }
                    }
                }, throwable -> {
                    if (isViewAttached()) {
                        getMvpView().hideProgress();
                        getMvpView().onError(throwable);
                    }
                });
    }
}
