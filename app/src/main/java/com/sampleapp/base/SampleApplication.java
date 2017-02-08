package com.sampleapp.base;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.sampleapp.BuildConfig;
import com.sampleapp.R;
import com.sampleapp.utils.UtilsModule;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


/**
 * Initialization of required libraries
 */
public class SampleApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //Fabric initialization for Crashlytics
        Fabric.with(this, new Crashlytics());

        //create component
        mAppComponent = DaggerAppComponent.builder()
                .utilsModule(new UtilsModule(this)).build();

        //configure timber for logging
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        //calligraphy for fonts
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
