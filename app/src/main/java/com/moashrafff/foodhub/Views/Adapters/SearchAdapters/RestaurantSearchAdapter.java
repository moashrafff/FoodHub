package com.moashrafff.foodhub.Views.Adapters.SearchAdapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Restaurant;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.FirstPostionItemBinding;
import com.moashrafff.foodhub.databinding.RestaurantItemBinding;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Restaurant> restaurants = new ArrayList<>();
    Context context;
    private int FIRST_POSITION = 0;
    private int NORMAL_POSITION = 2;

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
        notifyDataSetChanged();
    }

    public RestaurantSearchAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View FirstView = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_postion_item,parent,false);
        View NormalView= LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item,parent,false);
        if (viewType == FIRST_POSITION){
            return new FirstSearchHolder(FirstView);
        }else {
            return new RestaurantSearchHolder(NormalView);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder.getItemViewType()==FIRST_POSITION){
            restaurants.add(0,new Restaurant());
            FirstSearchHolder holder1 = (FirstSearchHolder) holder;
            holder1.binding1.number.setText(restaurants.size()-1+"");
        }else {
            RestaurantSearchHolder holder2 = (RestaurantSearchHolder) holder;
            Restaurant res = restaurants.get(position);
            holder2.bind(res);
        }

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }



    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return FIRST_POSITION;
        }
        return NORMAL_POSITION;
    }



    public class RestaurantSearchHolder extends RecyclerView.ViewHolder {


        RestaurantItemBinding binding;
        Restaurant model;

        public RestaurantSearchHolder(@NonNull View itemView) {
            super(itemView);
            binding = RestaurantItemBinding.bind(itemView);
        }

        public void bind(Restaurant model) {
            this.model = model;
            Glide.with(context).load(Constants.ImageFolderUrl + model.getPic()).into(binding.im);
            if (!model.getVerified().equals("1")) {
                binding.veri.setImageResource(0);
            }
            binding.searchResName.setText(model.getName());
            binding.searchResDel.setText(model.getDelivery());
            binding.searchResDelTime.setText(model.getDelivery_time());
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
