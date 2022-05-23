package com.moashrafff.foodhub.Views.Pages.b_Account;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.ActivityCartBinding;
import com.moashrafff.foodhub.databinding.AuthRegistrationScreenBinding;
import com.moashrafff.foodhub.databinding.AuthSignUpScreenBinding;


public class signUp extends Fragment implements View.OnClickListener {

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

        binding.loginTv.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_tv:
                Fragment fragment = new LoginFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.auth_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
        }
    }
}