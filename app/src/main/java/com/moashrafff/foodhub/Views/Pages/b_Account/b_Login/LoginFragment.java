package com.moashrafff.foodhub.Views.Pages.b_Account.b_Login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.User;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.FoodViewModel;
import com.moashrafff.foodhub.Views.Pages.b_Account.a_SignUp.signUp;
import com.moashrafff.foodhub.Views.Pages.c_Home.MainActivity;
import com.moashrafff.foodhub.databinding.AuthLoginScreenBinding;


public class LoginFragment extends Fragment implements View.OnClickListener {


    AuthLoginScreenBinding binding;
    private FoodViewModel viewModel;


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
        viewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        binding.loginBtn.setOnClickListener(this);

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
            case R.id.login_btn:
                Constants.setLogEmail(binding.loginEmailEt.getText().toString());
                Constants.setLogPass(binding.loginPassEt.getText().toString());

                viewModel.login(requireContext());

                viewModel.loginTest.observe(requireActivity(), new Observer<User>() {
                    @Override
                    public void onChanged(User user) {
                        startActivity(new Intent(getActivity(), MainActivity.class));
                        getActivity().finish();
                    }
                });
                break;

        }


    }

}