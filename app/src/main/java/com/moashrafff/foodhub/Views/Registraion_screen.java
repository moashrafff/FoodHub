package com.moashrafff.foodhub.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.moashrafff.foodhub.databinding.AuthRegistrationScreenBinding;

public class Registraion_screen extends AppCompatActivity {

    AuthRegistrationScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AuthRegistrationScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}