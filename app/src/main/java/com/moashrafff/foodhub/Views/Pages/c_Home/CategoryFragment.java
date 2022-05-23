package com.moashrafff.foodhub.Views.Pages.c_Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.foodhub.Data.Model.Category;
import com.moashrafff.foodhub.Data.Model.Food;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Adapters.CategoryItemsAdapter;
import com.moashrafff.foodhub.Views.FoodViewModel;
import com.moashrafff.foodhub.databinding.CategoryScreenBinding;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {


    private CategoryScreenBinding binding;
    private CategoryItemsAdapter adapter;
    private FoodViewModel viewModel;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = CategoryScreenBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        adapter = new CategoryItemsAdapter(requireContext());
        binding.categoryFoodsRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false));
        binding.categoryFoodsRv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        viewModel.getFoodsByCategories();
        viewModel.foodsByCategories.observe(requireActivity(), new Observer<ArrayList<Food>>() {
            @Override
            public void onChanged(ArrayList<Food> foods) {
                adapter.setFoods(foods);

            }
        });
    }
}