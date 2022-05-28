package com.moashrafff.foodhub.Views.Pages.Favourite;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Adapters.FavouriteAdapters.FoodFavouriteAdapter;
import com.moashrafff.foodhub.Views.Adapters.FavouriteAdapters.RestaurantFavouriteAdapter;
import com.moashrafff.foodhub.databinding.FragmentFavouriteBinding;


public class FavouriteFragment extends Fragment implements View.OnClickListener {

    private FragmentFavouriteBinding binding;
    private FoodFavouriteAdapter foodAdapter;
    private RestaurantFavouriteAdapter restAdapter;

    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentFavouriteBinding.inflate(inflater,container,false);
        View v = binding.getRoot();

        foodAdapter = new FoodFavouriteAdapter(requireContext());
        restAdapter = new RestaurantFavouriteAdapter(requireContext());
        binding.recyclerViewFavourite.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false));

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.resBtn.setOnClickListener(this);
        binding.foodBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.res_btn:
                binding.recyclerViewFavourite.setAdapter(null);
                view.setBackground(getResources().getDrawable(R.drawable.login_btn_shape));
                binding.resBtn.setTextColor(requireContext().getColor(R.color.white));
                binding.foodBtn.setBackground(null);
                binding.foodBtn.setTextColor(requireContext().getColor(R.color.btn_color));
                binding.recyclerViewFavourite.setAdapter(restAdapter);
                restAdapter.notifyDataSetChanged();
                break;
            case R.id.food_btn:
                binding.recyclerViewFavourite.setAdapter(null);
                view.setBackground(getResources().getDrawable(R.drawable.login_btn_shape));
                binding.foodBtn.setTextColor(requireContext().getColor(R.color.white));
                binding.resBtn.setBackground(null);
                binding.resBtn.setTextColor(requireContext().getColor(R.color.btn_color));
                binding.recyclerViewFavourite.setAdapter(foodAdapter);
                foodAdapter.notifyDataSetChanged();
                break;
        }
    }
}