package com.sampleapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.sampleapp.constants.PreferenceConstants;
import com.sampleapp.model.UserData;


/**
 * Contains method to store and retrieve SharedPreferences data
 */
public class PreferenceManager {

    private Context mContext;

    public PreferenceManager(Context context) {
        this.mContext = context;
    }

    //get shared pref
    private SharedPreferences getPreferences() {
        return mContext.getSharedPreferences(PreferenceConstants.PREFERENCE_NAME, Context.MODE_PRIVATE);
    }


    //save data of current logged in user
    public void setUserData(String userData) {
        getPreferences().edit().putString(PreferenceConstants.USER_DATA, userData).apply();
    }

    //get user data as string
    private String getUserDataFromPref() {
        return getPreferences().getString(PreferenceConstants.USER_DATA, null);
    }

    //get saved data of current user as an object
    public UserData.ResponseBean.AuthBean getUserData() {
        UserData.ResponseBean.AuthBean userData = null;
        if (getUserDataFromPref() != null) {
            userData = new Gson().fromJson(getUserDataFromPref(), UserData.ResponseBean.AuthBean.class);
        }
        return userData;
    }

    //set true when user is logged in
    public void setUserLoggedIn(boolean isLogin) {
        getPreferences().edit().putBoolean(PreferenceConstants.IS_LOGIN, isLogin).apply();
    }

    //returns true when user is logged in else false
    public boolean isUserLoggedIn() {
        return getPreferences().getBoolean(PreferenceConstants.IS_LOGIN, false);
    }

    //clear user shared preferences
    public void clearPrefrences() {
        getPreferences().edit().clear().apply();
    }

}