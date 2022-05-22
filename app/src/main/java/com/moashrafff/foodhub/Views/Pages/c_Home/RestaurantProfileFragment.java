package com.moashrafff.foodhub.Views.Pages.c_Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Restaurant;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.FragmentRestaurantProfileBinding;


public class RestaurantProfileFragment extends Fragment {


    FragmentRestaurantProfileBinding binding;


    public RestaurantProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRestaurantProfileBinding.inflate(inflater,container,false);
        View v = binding.getRoot();
        Bundle bundle = this.getArguments();
        String resName = bundle.getString("resName");
        String resCover = bundle.getString("resCover");
        String resImage = bundle.getString("resImage");
        String resRate = bundle.getString("resRate");
        String resDelTime = bundle.getString("resDelTime");
        String resDel = bundle.getString("resDel");


        binding.name.setText(resName);
        binding.lblName1.setText(resDel);
        binding.lblName2.setText(resDelTime);
        binding.rateOfRestaurant.setText(resRate);
        Glide.with(requireContext()).load(Constants.ImageFolderUrl + resImage).into(binding.resImage);
        Glide.with(requireContext()).load(Constants.ImageFolderUrl + resCover).into(binding.img);
        return v;
    }
}