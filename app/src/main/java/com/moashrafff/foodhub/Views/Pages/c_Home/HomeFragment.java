package com.moashrafff.foodhub.Views.Pages.c_Home;

import android.os.Bundle;
import android.util.Log;
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

import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Category;
import com.moashrafff.foodhub.Data.Model.Food;
import com.moashrafff.foodhub.Data.Model.Restaurant;
import com.moashrafff.foodhub.Data.Model.RestaurantDetailsRoot;
import com.moashrafff.foodhub.Data.Model.Root;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Adapters.HomeCategoriesAdapter;
import com.moashrafff.foodhub.Views.Adapters.HomeFoodAdapter;
import com.moashrafff.foodhub.Views.Adapters.HomeRestaurantAdapter;
import com.moashrafff.foodhub.Views.FoodViewModel;
import com.moashrafff.foodhub.Views.Pages.c_Home.FoodDetailsFragment;
import com.moashrafff.foodhub.Views.Pages.c_Home.RestaurantFoodSearchFragment;
import com.moashrafff.foodhub.Views.Pages.c_Home.RestaurantProfileFragment;
import com.moashrafff.foodhub.databinding.FragmentHomeScreenBinding;

public class HomeFragment extends Fragment implements HomeRestaurantAdapter.onItemClickListener,HomeFoodAdapter.onFoodClickListener,HomeCategoriesAdapter.onItemClickListener {

    private static final String TAG = "HomeFragment";

    private FragmentHomeScreenBinding binding;
    private FoodViewModel viewModel;
    private HomeCategoriesAdapter catAdapter;
    private HomeRestaurantAdapter resAdapter;
    private HomeFoodAdapter foodAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeScreenBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        catAdapter = new HomeCategoriesAdapter(requireContext(),this);
        resAdapter = new HomeRestaurantAdapter(requireContext(),this);
        foodAdapter= new HomeFoodAdapter(requireContext(),this);

        binding.catLst.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.catLst.setAdapter(catAdapter);
        binding.restLst.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL,false));
        binding.restLst.setAdapter(resAdapter);
        binding.popularLst.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL,false));
        binding.popularLst.setAdapter(foodAdapter);

        binding.tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestaurantFoodSearchFragment fragment = new RestaurantFoodSearchFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        viewModel.getRoot();

        viewModel.roots.observe(requireActivity(), new Observer<Root>() {
            @Override
            public void onChanged(Root root) {
                Log.e(TAG, "onChanged: "+root.getCategories() );
                catAdapter.setCategories(root.getCategories());
                resAdapter.setRestaurants(root.getRestaurants());
                foodAdapter.setFoods(root.getFoods());
            }
        });
    }


    @Override
    public void onItemClick(Restaurant restaurant) {

        Constants.setResDetailsId(restaurant.getId());
        RestaurantProfileFragment fragment = new RestaurantProfileFragment();
        getParentFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

    }

    @Override
    public void onItemClick(Food food) {

        Constants.setFoodDetailsId(food.getId());
        FoodDetailsFragment fragment = new FoodDetailsFragment();
        getParentFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

    }

    @Override
    public void onItemClick(Category category) {

        Constants.setCatId(category.getId());
        CategoryFragment fragment = new CategoryFragment();
        getParentFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }
}