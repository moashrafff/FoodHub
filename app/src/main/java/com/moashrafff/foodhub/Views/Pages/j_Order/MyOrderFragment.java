package com.moashrafff.foodhub.Views.Pages.j_Order;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.foodhub.Data.Model.OrderUpcomingModel;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Adapters.MyOrderAdapters.OrderHistoryAdapter;
import com.moashrafff.foodhub.Views.Adapters.MyOrderAdapters.OrderUpcomingAdapter;
import com.moashrafff.foodhub.databinding.FragmentMyOrderBinding;


public class MyOrderFragment extends Fragment {

    FragmentMyOrderBinding binding;
    OrderHistoryAdapter historyAdapter;
    OrderUpcomingAdapter upcomingAdapter;

    public MyOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMyOrderBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        historyAdapter = new OrderHistoryAdapter(requireContext());
        upcomingAdapter = new OrderUpcomingAdapter(requireContext());

    }
}