package com.moashrafff.foodhub.Views.Pages.a_Intro;

import android.os.Bundle;
import android.view.View;

import com.moashrafff.foodhub.Config.BaseActivity;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Pages.c_Home.MainActivity;
import com.moashrafff.foodhub.databinding.WelcomeScreenBinding;

public class WelcomeScreen extends BaseActivity implements View.OnClickListener {

    WelcomeScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = WelcomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnWelcomeFacebook.setOnClickListener(this);
        binding.startBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_btn:
                navigateTo(OnBoardingScreen.class);
                break;
            case R.id.btn_welcome_facebook:
                navigateTo(MainActivity.class);
                break;
        }
    }
}