package com.moashrafff.foodhub.Views.Adapters.FavouriteAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Food;
import com.moashrafff.foodhub.Data.Model.Restaurant;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Adapters.HomeAdapters.HomeFoodAdapter;
import com.moashrafff.foodhub.databinding.FavouriteFoodItemBinding;

import java.util.ArrayList;

public class FoodFavouriteAdapter extends RecyclerView.Adapter<FoodFavouriteAdapter.FoodFavouriteHolder> {

    Context context;
    private ArrayList<Food> foods = new ArrayList<>();

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
        notifyDataSetChanged();
    }

    public FoodFavouriteAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FoodFavouriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FoodFavouriteHolder holder = new FoodFavouriteHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_food_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodFavouriteHolder holder, int position) {
        Food food  = foods.get(position);
        holder.bind(food);
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class FoodFavouriteHolder extends RecyclerView.ViewHolder
    {
        FavouriteFoodItemBinding binding;
        Food model;

        public FoodFavouriteHolder(@NonNull View itemView) {
            super(itemView);
            binding = FavouriteFoodItemBinding.bind(itemView);
        }

        public void bind(Food model) {
            this.model = model;
            Glide.with(context).load(Constants.ImageFolderUrl + model.getPic()).into(binding.itemImage);
            binding.popularRating.setText(model.getRating());
            binding.lblName.setText(model.getName());
            binding.popularNumber.setText(model.getNumber_of_ratings());
            binding.lblName1.setText(model.getDescription());
            binding.imgRates.setText(model.getPrice());
        }
    }

}
