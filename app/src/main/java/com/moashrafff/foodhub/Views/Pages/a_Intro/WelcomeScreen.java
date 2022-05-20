package com.moashrafff.foodhub.Views.Pages.a_Intro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.WelcomeScreenBinding;

public class WelcomeScreen extends AppCompatActivity {

    WelcomeScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = WelcomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}