package com.moashrafff.foodhub.Views.Pages.c_Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.RestaurantDetailsRoot;
import com.moashrafff.foodhub.Views.Adapters.RestaurantDetailsFeaturedAdapter;
import com.moashrafff.foodhub.Views.FoodViewModel;
import com.moashrafff.foodhub.databinding.FragmentRestaurantProfileBinding;


public class RestaurantProfileFragment extends Fragment {


    FragmentRestaurantProfileBinding binding;
    private FoodViewModel viewModel;
    private RestaurantDetailsFeaturedAdapter adapter;


    public RestaurantProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRestaurantProfileBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        adapter = new RestaurantDetailsFeaturedAdapter(requireContext());
        binding.featuredRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL,false));
        binding.featuredRecyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        viewModel.getRestaurant();



        viewModel.resRoot.observe(requireActivity(), new Observer<RestaurantDetailsRoot>() {
            @Override
            public void onChanged(RestaurantDetailsRoot restaurantDetailsRoot) {

                binding.name.setText(restaurantDetailsRoot.getRestaurant().getName());
                binding.lblName1.setText(restaurantDetailsRoot.getRestaurant().getDelivery());
                binding.lblName2.setText(restaurantDetailsRoot.getRestaurant().getDelivery_time());
                binding.rateOfRestaurant.setText(restaurantDetailsRoot.getRestaurant().getRating());
                Glide.with(requireContext()).load(Constants.ImageFolderUrl + restaurantDetailsRoot.getRestaurant().getPic()).into(binding.resImage);
                Glide.with(requireContext()).load(Constants.ImageFolderUrl + restaurantDetailsRoot.getRestaurant().getCover_photo()).into(binding.img);

                adapter.setItems(restaurantDetailsRoot.getItems());

            }
        });
    }
}