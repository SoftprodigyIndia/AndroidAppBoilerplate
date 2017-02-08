package com.sampleapp.module;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sampleapp.R;
import com.sampleapp.module.login.LoginActivity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;

/**
 * initial screen for application to present your app logo to users or maybe run a nice animation
 */

public class SplashActivity extends AppCompatActivity {

    /**
     * subscription to Observe our timer Observable
     */
    private Subscription mSubscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //start next activity after delay of 2 seconds
        mSubscriber = Observable.timer(2, TimeUnit.SECONDS).subscribe(aLong -> {
            startActivity(LoginActivity.createIntent(SplashActivity.this));
            finish();
        });
    }

    /**
     * un subscribe the subscriber
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSubscriber.unsubscribe();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
