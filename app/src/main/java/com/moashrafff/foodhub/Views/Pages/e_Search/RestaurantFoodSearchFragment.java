package com.moashrafff.foodhub.Views.Pages.e_Search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Food;
import com.moashrafff.foodhub.Data.Model.Restaurant;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Adapters.SearchAdapters.FoodSearchAdapter;
import com.moashrafff.foodhub.Views.Adapters.SearchAdapters.RestaurantSearchAdapter;
import com.moashrafff.foodhub.Views.FoodViewModel;
import com.moashrafff.foodhub.databinding.SearchScreenBinding;

import java.util.ArrayList;


public class RestaurantFoodSearchFragment extends Fragment implements View.OnClickListener {


    private SearchScreenBinding binding;
    private RestaurantSearchAdapter resAdapter;
    private FoodSearchAdapter foodAdapter;
    private FoodViewModel viewModel;


    public RestaurantFoodSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = SearchScreenBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        resAdapter = new RestaurantSearchAdapter(requireContext());
        foodAdapter = new FoodSearchAdapter(requireContext());
        binding.searchRv.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(FoodViewModel.class);


        binding.tvSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Constants.setFoodSearchKeyWord(charSequence.toString());
                viewModel.getSearchRestaurant();
                Log.e("TAG", "onTextChanged: "+charSequence );
                Constants.setResSearchKeyWord(charSequence.toString());
                viewModel.getSearchFood();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        binding.resBtn.setOnClickListener(this);
        binding.foodBtn.setOnClickListener(this);



        viewModel.searchRestaurant.observe(requireActivity(), new Observer<ArrayList<Restaurant>>() {
            @Override
            public void onChanged(ArrayList<Restaurant> restaurants) {
                resAdapter.setRestaurants(restaurants);
            }
        });

        viewModel.searchFood.observe(requireActivity(), new Observer<ArrayList<Food>>() {
            @Override
            public void onChanged(ArrayList<Food> foods) {
                foodAdapter.setFoods(foods);
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.res_btn:
                binding.searchRv.setAdapter(null);
                view.setBackground(getResources().getDrawable(R.drawable.login_btn_shape));
                binding.resBtn.setTextColor(requireContext().getColor(R.color.white));
                binding.foodBtn.setBackground(null);
                binding.foodBtn.setTextColor(requireContext().getColor(R.color.btn_color));
                binding.searchRv.setAdapter(resAdapter);
                resAdapter.notifyDataSetChanged();
                binding.tvSearch.setText("");
                break;
            case R.id.food_btn:
                binding.searchRv.setAdapter(null);
                view.setBackground(getResources().getDrawable(R.drawable.login_btn_shape));
                binding.foodBtn.setTextColor(requireContext().getColor(R.color.white));
                binding.resBtn.setBackground(null);
                binding.resBtn.setTextColor(requireContext().getColor(R.color.btn_color));
                binding.searchRv.setAdapter(foodAdapter);
                resAdapter.notifyDataSetChanged();
                binding.tvSearch.setText("");

                break;
        }
    }
}