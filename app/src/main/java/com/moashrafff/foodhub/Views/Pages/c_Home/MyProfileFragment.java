package com.moashrafff.foodhub.Views.Pages.c_Home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.User;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.FoodViewModel;
import com.moashrafff.foodhub.databinding.MyProfileScreenBinding;

import java.net.URI;

public class MyProfileFragment extends Fragment implements View.OnClickListener {

    private MyProfileScreenBinding binding;
    private FoodViewModel viewModel;
    private int SELECT_IMAGE_CODE = 1;

    public MyProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = MyProfileScreenBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        viewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        viewModel.login(requireContext());
        viewModel.loginTest.observe(requireActivity(), new Observer<User>() {
            @Override
            public void onChanged(User user) {
                binding.profileName.setText(user.getName());
                binding.profileName.setEnabled(false);
                binding.profileEmail.setText(user.getEmail());
                binding.profileEmail.setEnabled(false);
                binding.profileNumber.setText(user.getMobile());
                binding.profileNumber.setEnabled(false);

            }
        });

        binding.editProfileTv.setOnClickListener(this);
        binding.pickImage.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.edit_profile_tv :
                binding.profileName.setEnabled(true);
                binding.profileEmail.setEnabled(true);
                binding.profileNumber.setEnabled(true);
                break;
            case R.id.pick_image :
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Title"),SELECT_IMAGE_CODE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            Uri uri = data.getData();
            Log.e("TAG", "onActivityResult: " );
            Constants.setUserProfilePic(uri);
            binding.profileIcon.setImageURI(uri);
        }

    }
}