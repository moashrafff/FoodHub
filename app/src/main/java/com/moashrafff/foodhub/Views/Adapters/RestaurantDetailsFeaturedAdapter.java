package com.moashrafff.foodhub.Views.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Item;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.FeaturedItemBinding;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDetailsFeaturedAdapter extends RecyclerView.Adapter<RestaurantDetailsFeaturedAdapter.RestaurantDetailsHolder> {

    Context context;
    private List<Item> items = new ArrayList<>();

    public void setItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public RestaurantDetailsFeaturedAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RestaurantDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RestaurantDetailsHolder holder = new RestaurantDetailsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantDetailsHolder holder, int position) {
        Item model = items.get(position);
        holder.bind(model);

        holder.binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setBackground(context.getDrawable(R.drawable.restaurant_item_like_shape));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class RestaurantDetailsHolder extends RecyclerView.ViewHolder {

        Item model;
        FeaturedItemBinding binding;

        public RestaurantDetailsHolder(@NonNull View itemView) {
            super(itemView);
            binding = FeaturedItemBinding.bind(itemView);
        }

        public void bind(Item model) {
            this.model = model;
            Glide.with(context).load(Constants.ImageFolderUrl + model.getPic()).into(binding.itemImage);

            binding.lblName.setText(model.getName());
            binding.lblName1.setText(model.getDescription());
            binding.foodRate.setText(model.getRating());
            binding.imgRates.setText(model.getPrice());
        }


    }


}
