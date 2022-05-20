package com.moashrafff.foodhub.Views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.ActivityCartBinding;
import com.moashrafff.foodhub.databinding.AuthRegistrationScreenBinding;
import com.moashrafff.foodhub.databinding.AuthSignUpScreenBinding;


public class signUp extends Fragment {

    AuthSignUpScreenBinding binding;
    public signUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = AuthSignUpScreenBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }
}