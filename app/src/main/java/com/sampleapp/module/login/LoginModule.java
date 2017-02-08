package com.sampleapp.module.login;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * provides dependencies for {@link LoginActivity}
 */
@Module
class LoginModule {

    private Context mContext;

    LoginModule(Context mContext) {
        this.mContext = mContext;
    }

    //returns LoginPresenter object
    @Provides
    LoginPresenter getPresenter() {
        return new LoginPresenter(mContext);
    }
}
