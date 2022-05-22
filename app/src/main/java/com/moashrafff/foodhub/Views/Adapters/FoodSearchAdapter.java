package com.moashrafff.foodhub.Views.Adapters;

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
import com.moashrafff.foodhub.databinding.FoodItemBinding;

import java.util.ArrayList;
import java.util.List;

public class FoodSearchAdapter extends RecyclerView.Adapter<FoodSearchAdapter.SearchHomeHolder> {

    private List<Food> foods = new ArrayList<>();
    Context context;

    public void setFoods(List<Food> foods) {
        this.foods = foods;
        notifyDataSetChanged();
    }

    public FoodSearchAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SearchHomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FoodSearchAdapter.SearchHomeHolder holder = new FoodSearchAdapter.SearchHomeHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHomeHolder holder, int position) {
        Food model = foods.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }


    public class SearchHomeHolder extends RecyclerView.ViewHolder {

        Food model;
        FoodItemBinding binding;

        public SearchHomeHolder(@NonNull View itemView) {
            super(itemView);
            binding = FoodItemBinding.bind(itemView);
        }

        public void bind(Food model) {
            this.model = model;
            Glide.with(context).load(Constants.ImageFolderUrl + model.getPic()).into(binding.foodMainImage);

            binding.foodName.setText(model.getName());
            binding.foodDes.setText(model.getDescription());
            binding.foodRate.setText(model.getRating());
            binding.foodPrice.setText(model.getPrice());
        }
    }

}
