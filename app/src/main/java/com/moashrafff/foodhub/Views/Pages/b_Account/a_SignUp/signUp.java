package com.moashrafff.foodhub.Views.Pages.b_Account.a_SignUp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Pages.b_Account.b_Login.LoginFragment;
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
        binding.signUpBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        Fragment fragment = null;
        FragmentManager fragmentManager = null;
        FragmentTransaction fragmentTransaction = null;

        switch (view.getId()){
            case R.id.login_tv:
                fragment = new LoginFragment();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.auth_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.sign_up_btn:

                Constants.setRegName(binding.etName.getText().toString());
                Constants.setRegEmail(binding.etEmail.getText().toString());
                Constants.setRegPass(binding.etPass.getText().toString());

                Log.e("TAG", "onClick: "+ binding.etName.getText().toString());
                Log.e("TAG", "onClick: "+ binding.etEmail.getText().toString());
                Log.e("TAG", "onClick: "+ binding.etPass.getText().toString());

                fragment = new NumberRegistrationScreen();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.auth_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

        }
    }
}