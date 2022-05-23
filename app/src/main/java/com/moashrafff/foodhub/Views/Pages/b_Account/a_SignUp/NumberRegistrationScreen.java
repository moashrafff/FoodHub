package com.moashrafff.foodhub.Views.Pages.b_Account.a_SignUp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.FoodViewModel;
import com.moashrafff.foodhub.Views.Pages.b_Account.b_Login.LoginFragment;
import com.moashrafff.foodhub.databinding.AuthRegistrationScreenBinding;


public class NumberRegistrationScreen extends Fragment implements View.OnClickListener {


    AuthRegistrationScreenBinding binding;
    private FoodViewModel viewModel;

    public NumberRegistrationScreen() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = AuthRegistrationScreenBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        viewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        binding.sendBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
        case R.id.send_btn:

            String code = binding.countryCodeHolder.getSelectedCountryCode();
            String number = binding.editNumber.getText().toString();
            String userNumber = code + number;
            Constants.setRegMobile(userNumber);
            viewModel.register();
            viewModel.registerTest.observe(requireActivity(), new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    Log.e("TAG", "onChanged: test "+s );
                }
            });
            LoginFragment fragment = new LoginFragment();
            getParentFragmentManager().beginTransaction().replace(R.id.auth_container,fragment).commit();
            break;
        }
    }
}