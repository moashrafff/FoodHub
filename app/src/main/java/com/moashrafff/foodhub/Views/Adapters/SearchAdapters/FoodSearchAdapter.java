package com.moashrafff.foodhub.Views.Adapters.SearchAdapters;

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
import com.moashrafff.foodhub.databinding.FirstPostionItemBinding;
import com.moashrafff.foodhub.databinding.FoodItemBinding;

import java.util.ArrayList;
import java.util.List;

public class FoodSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Food> foods = new ArrayList<>();
    Context context;
    private int FIRST_POSITION = 0;
    private int NORMAL_POSITION = 2;

    public void setFoods(List<Food> foods) {
        this.foods = foods;
        notifyDataSetChanged();
    }

    public FoodSearchAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return FIRST_POSITION;
        }
        return NORMAL_POSITION;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View FirstView = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_postion_item,parent,false);
        View NormalView= LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item,parent,false);
        if (viewType == FIRST_POSITION){
            return new FirstSearchHolder(FirstView);
        }else {
            return new SearchHomeHolder(NormalView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType()==FIRST_POSITION){
            foods.add(0,new Food());
            FirstSearchHolder holder1 = (FirstSearchHolder) holder;
            holder1.binding1.number.setText(foods.size()-1+"");
        }else {
            SearchHomeHolder holder2 = (SearchHomeHolder) holder;
            Food food = foods.get(position);
            holder2.bind(food);
        }
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

    public class FirstSearchHolder extends RecyclerView.ViewHolder {

        FirstPostionItemBinding binding1;

        public FirstSearchHolder(@NonNull View itemView) {
            super(itemView);
            binding1 = FirstPostionItemBinding.bind(itemView);

        }
    }

}
