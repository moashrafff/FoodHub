package com.moashrafff.foodhub.Views.Adapters.MyOrderAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.OrderHistoryModel;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.OrderHistoryItemBinding;

import java.util.ArrayList;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.OrderHistoryHolder> {

    private Context context;
    private ArrayList<OrderHistoryModel> historyModels = new ArrayList<>();

    public void setHistoryModels(ArrayList<OrderHistoryModel> historyModels) {
        this.historyModels = historyModels;
        notifyDataSetChanged();
    }

    public OrderHistoryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public OrderHistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrderHistoryHolder holder = new OrderHistoryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.order_history_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryHolder holder, int position) {
        OrderHistoryModel model = historyModels.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return historyModels.size();
    }

    public class OrderHistoryHolder extends RecyclerView.ViewHolder {

        OrderHistoryItemBinding binding;
        OrderHistoryModel model;

        public OrderHistoryHolder(@NonNull View itemView) {
            super(itemView);
            binding = OrderHistoryItemBinding.bind(itemView);
        }

        public void bind(OrderHistoryModel model) {
            this.model = model;
            Glide.with(context).load(Constants.ImageFolderUrl + model.getRestHistoryImage()).into(binding.hisItemImage);
            binding.itemHisResName.setText(model.getRestName());
            binding.itemHisPrice.setText(model.getHistoryPrice());
            binding.itemOrderStatus.setText(model.getHistoryStatus());
            binding.itemHistoryDate.setText(model.getOrderDate());
            binding.tvNumberOfItemsHistory.setText(model.getItemsNumber());
        }
    }
}
