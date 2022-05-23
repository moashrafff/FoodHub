package com.moashrafff.foodhub.Views.Pages.c_Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Pages.b_Account.LoginFragment;
import com.moashrafff.foodhub.Views.Pages.b_Account.signUp;
import com.moashrafff.foodhub.databinding.ActivityAuthBinding;

public class ActivityAuth extends AppCompatActivity {

    ActivityAuthBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.auth_container,new LoginFragment()).commit();
    }
}