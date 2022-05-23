package com.moashrafff.foodhub.Views.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Category;
import com.moashrafff.foodhub.Data.Model.Food;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.CatItemBinding;

import java.util.ArrayList;

public class CategoryItemsAdapter extends RecyclerView.Adapter<CategoryItemsAdapter.CategoryHolder> {

    Context context;
    ArrayList<Food> foods = new ArrayList<>();

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
        notifyDataSetChanged();
    }

    public CategoryItemsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryHolder holder = new CategoryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Food model = foods.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {

        CatItemBinding binding;
        Food model;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            binding = CatItemBinding.bind(itemView);
        }
        public void bind(Food model) {
            this.model = model;
            binding.lblName.setText(model.getName());
            Glide.with(context).load(Constants.ImageFolderUrl + model.getPic()).into(binding.itemImage);
            binding.lblName1.setText(model.getDescription());
            binding.imgRates.setText(model.getPrice());
            binding.foodRate.setText(model.getRating());
        }
    }
}
