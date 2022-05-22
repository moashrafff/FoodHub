package com.moashrafff.foodhub.Views.Pages.a_Intro;

import android.os.Bundle;
import android.os.Handler;

import com.moashrafff.foodhub.Config.BaseActivity;
import com.moashrafff.foodhub.R;

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateTo(WelcomeScreen.class);
                finish();
            }
        },3000);
    }
}