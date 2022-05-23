package com.moashrafff.foodhub.Views.Pages.b_Account;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.moashrafff.foodhub.databinding.AuthRegistrationScreenBinding;

public class RegistrationScreen extends AppCompatActivity {

    AuthRegistrationScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AuthRegistrationScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}