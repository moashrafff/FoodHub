package com.moashrafff.foodhub.Views.Pages.b_Account;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Pages.c_Home.MainActivity;
import com.moashrafff.foodhub.databinding.AuthLoginScreenBinding;
import com.moashrafff.foodhub.databinding.BackHeaderBinding;


public class LoginFragment extends Fragment implements View.OnClickListener {


    AuthLoginScreenBinding binding;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = AuthLoginScreenBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        binding.signUup.setOnClickListener(this);
        binding.btnWelcomeFacebook.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.sign_uup:
                Fragment fragment = new signUp();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.auth_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.btn_welcome_facebook:
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
        }


    }
}