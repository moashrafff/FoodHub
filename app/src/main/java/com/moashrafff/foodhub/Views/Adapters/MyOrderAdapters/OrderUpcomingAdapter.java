package com.moashrafff.foodhub.Views.Adapters.MyOrderAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Food;
import com.moashrafff.foodhub.Data.Model.OrderUpcomingModel;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Adapters.HomeAdapters.HomeFoodAdapter;
import com.moashrafff.foodhub.databinding.UpcomingOrderItemBinding;

import java.util.ArrayList;

public class OrderUpcomingAdapter extends RecyclerView.Adapter<OrderUpcomingAdapter.OrderUpcomingHolder> {

    private Context context;
    private ArrayList<OrderUpcomingModel> upcomingModels = new ArrayList<>();

    public OrderUpcomingAdapter(Context context) {
        this.context = context;
    }

    public void setUpcomingModels(ArrayList<OrderUpcomingModel> upcomingModels) {
        this.upcomingModels = upcomingModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OrderUpcomingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrderUpcomingHolder holder = new OrderUpcomingHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_order_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderUpcomingHolder holder, int position) {
        OrderUpcomingModel model = upcomingModels.get(position) ;
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return upcomingModels.size();
    }

    public class OrderUpcomingHolder extends RecyclerView.ViewHolder
    {
        UpcomingOrderItemBinding binding;
        OrderUpcomingModel model;
        public OrderUpcomingHolder(@NonNull View itemView) {

            super(itemView);
            binding = UpcomingOrderItemBinding.bind(itemView);
        }

        public void bind(OrderUpcomingModel model) {
            this.model = model;
            Glide.with(context).load(Constants.ImageFolderUrl + model.getRestUpcomingImage()).into(binding.rivUpcoming);
            binding.tvNumberOfItems.setText(model.getNumberOfItem());
            binding.tvNumberOfOrder.setText(model.getOrderNumber());
            binding.tvRestaurantUpcoming.setText(model.getRestName());
            binding.tvTimeToArrive.setText(model.getArrivalTime());
            binding.tvOrderStatus.setText(model.getOrderStatus());
            binding.rivUpcoming.setImageResource(model.getRestUpcomingImage());
        }

    }

}
