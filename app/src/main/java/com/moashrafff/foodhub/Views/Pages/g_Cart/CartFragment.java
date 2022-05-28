package com.moashrafff.foodhub.Views.Pages.g_Cart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.foodhub.databinding.ActivityCartBinding;


public class CartFragment extends Fragment {

    ActivityCartBinding binding;


    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = ActivityCartBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }
}