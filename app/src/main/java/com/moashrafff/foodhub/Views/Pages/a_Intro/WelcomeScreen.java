package com.moashrafff.foodhub.Views.Pages.a_Intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.moashrafff.foodhub.Config.BaseActivity;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Pages.c_Home.MainActivity;
import com.moashrafff.foodhub.databinding.WelcomeScreenBinding;

public class WelcomeScreen extends BaseActivity {

    WelcomeScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = WelcomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnWelcomeFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(MainActivity.class);
            }
        });

    }
}