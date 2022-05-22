package com.moashrafff.foodhub.Views.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Category;
import com.moashrafff.foodhub.Data.Model.Restaurant;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.CategoriesItemBinding;
import com.moashrafff.foodhub.databinding.ItemFoodItemBinding;

import java.util.ArrayList;

public class HomeRestaurantAdapter extends RecyclerView.Adapter<HomeRestaurantAdapter.RestaurantViewHolder> {

    Context context;
    ArrayList<Restaurant> restaurants = new ArrayList<>();
    private onItemClickListener listener;


    public HomeRestaurantAdapter(Context context,onItemClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HomeRestaurantAdapter.RestaurantViewHolder holder = new HomeRestaurantAdapter.RestaurantViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_item, parent, false),listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Restaurant model = restaurants.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }



    class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemFoodItemBinding binding;
        Restaurant model;
        onItemClickListener listener;


        public RestaurantViewHolder(@NonNull View itemView,onItemClickListener listener) {
            super(itemView);
            binding = ItemFoodItemBinding.bind(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bind(Restaurant model) {
            this.model = model;
            Glide.with(context).load(Constants.ImageFolderUrl + model.getCover_photo()).into(binding.itemImage);
            if (!model.getVerified().equals("1")){
                binding.lblName.setCompoundDrawables(null,null,null,null);
            }
            binding.imgRates.setText(model.getRating());
            binding.lblName.setText(model.getName());
            binding.lblName1.setText(model.getDelivery());
            binding.lblName2.setText(model.getDelivery_time());
        }


        @Override
        public void onClick(View view) {
            listener.onItemClick(restaurants.get(getAdapterPosition()));
            Log.e("TAG", "onClick: +dakhal hena");
        }
    }
    public interface onItemClickListener{
        void onItemClick(Restaurant restaurant);
    }
}
