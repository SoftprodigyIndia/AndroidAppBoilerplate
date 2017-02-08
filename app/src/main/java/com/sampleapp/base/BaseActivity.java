package com.sampleapp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * To be extended by all Activities
 * binds butterknife injection and layout for Activity
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        //bind view here for all activities extending this Activity
        ButterKnife.bind(this);
    }

    /**
     * get layout to inflate
     */
    public abstract
    @LayoutRes
    int getLayout();

    //calligraphy configuration
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}