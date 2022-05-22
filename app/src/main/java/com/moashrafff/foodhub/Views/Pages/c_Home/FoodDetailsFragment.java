package com.moashrafff.foodhub.Views.Pages.c_Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Food;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.FoodViewModel;
import com.moashrafff.foodhub.databinding.FoodDetailsScreenBinding;
import com.moashrafff.foodhub.databinding.FragmentHomeScreenBinding;


public class FoodDetailsFragment extends Fragment {


    FoodDetailsScreenBinding binding;
    private FoodViewModel viewModel;

    public FoodDetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FoodDetailsScreenBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        viewModel.getFood();

        viewModel.foods.observe(requireActivity(), new Observer<Food>() {
            @Override
            public void onChanged(Food food) {
                Glide.with(requireContext()).load(Constants.ImageFolderUrl + food.getPic()).into(binding.foodItemImage);
                binding.rateTv.setText(food.getRating());
                binding.ratenumber.setText("("+food.getNumber_of_ratings()+")");
                binding.priceTv.setText(food.getPrice());
                binding.foodItemName.setText(food.getName());
                binding.foodDetailsTextView.setText(food.getDescription());

            }
        });

    }
}