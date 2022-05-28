package com.moashrafff.foodhub.Views.Adapters.HomeAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Food;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.PopularItemBinding;

import java.util.ArrayList;

public class HomeFoodAdapter extends RecyclerView.Adapter<HomeFoodAdapter.FoodViewHolder> {

    Context context;
    ArrayList<Food> foods = new ArrayList<>();
    private onFoodClickListener listener;

    public HomeFoodAdapter(Context context, onFoodClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HomeFoodAdapter.FoodViewHolder holder = new HomeFoodAdapter.FoodViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item, parent, false),listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food model = foods.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }


    public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        PopularItemBinding binding;
        Food model;
        onFoodClickListener listener;


        public FoodViewHolder(@NonNull View itemView, onFoodClickListener listener) {
            super(itemView);
            binding = PopularItemBinding.bind(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bind(Food model) {
            this.model = model;
            Glide.with(context).load(Constants.ImageFolderUrl + model.getPic()).into(binding.popularImg);
            binding.popularPrice.setText(model.getPrice());
            binding.popularTitle.setText(model.getName());
            binding.poplarDis.setText(model.getDescription());
            binding.popularRating.setText(model.getRating());
            binding.popularNumber.setText("("+model.getNumber_of_ratings()+")");
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(foods.get(getAdapterPosition()));
        }
    }

    public interface onFoodClickListener{
        void onItemClick(Food food);
    }
}
