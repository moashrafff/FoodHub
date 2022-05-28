package com.moashrafff.foodhub.Views.Adapters.FavouriteAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Food;
import com.moashrafff.foodhub.Data.Model.Restaurant;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.FavouriteRestaurantItemBinding;
import com.moashrafff.foodhub.databinding.PopularItemBinding;

import java.util.ArrayList;

public class RestaurantFavouriteAdapter extends RecyclerView.Adapter<RestaurantFavouriteAdapter.RestaurantFavouriteHolder> {

    Context context;

    private ArrayList<Restaurant> restaurants = new ArrayList<>();

    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
        notifyDataSetChanged();
    }

    public RestaurantFavouriteAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RestaurantFavouriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RestaurantFavouriteHolder holder = new RestaurantFavouriteHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantFavouriteHolder holder, int position) {
        Restaurant restaurant = restaurants.get(position);
        holder.bind(restaurant);
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class RestaurantFavouriteHolder extends RecyclerView.ViewHolder
    {
        FavouriteRestaurantItemBinding binding;
        Restaurant model;

        public RestaurantFavouriteHolder(@NonNull View itemView) {
            super(itemView);
            binding = FavouriteRestaurantItemBinding.bind(itemView);
        }

        public void bind(Restaurant model) {
            this.model = model;
            Glide.with(context).load(Constants.ImageFolderUrl + model.getPic()).into(binding.itemImage);
            binding.tvRate.setText(model.getRating());
            binding.lblName.setText(model.getName());
            binding.tvNumberRate.setText(model.getNumber_of_ratings());
            binding.lblName1.setText(model.getDelivery());
            binding.lblName2.setText(model.getDelivery_time());
        }
    }
}
