package com.moashrafff.foodhub.Views.Pages.Review;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Adapters.ReviewAdapters.ReviewAdapter;
import com.moashrafff.foodhub.databinding.FragmentReviewBinding;


public class ReviewFragment extends Fragment {

    private FragmentReviewBinding binding;
    private ReviewAdapter adapter;

    public ReviewFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentReviewBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        adapter = new ReviewAdapter(requireContext());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerViewReview.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false));
        binding.recyclerViewReview.setAdapter(adapter);
    }
}