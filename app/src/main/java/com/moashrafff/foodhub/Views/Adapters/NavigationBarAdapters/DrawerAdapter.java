package com.moashrafff.foodhub.Views.Adapters.NavigationBarAdapters;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moashrafff.foodhub.Data.Model.DrawerItemModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerViewHolder> {

    private List<DrawerItemModel> items;
    private Map<Class<? extends DrawerItemModel>, Integer> viewTypes;
    private SparseArray<DrawerItemModel> holderFactories;

    private OnItemSelectedListener listener;

    public DrawerAdapter(List<DrawerItemModel> items) {
        this.items = items;
        this.viewTypes = new HashMap<>();
        this.holderFactories = new SparseArray<>();
        processViewTypes();
    }

    private void processViewTypes() {
        int type = 0;
        for (DrawerItemModel item : items) {
            if (!viewTypes.containsKey(items.getClass())) {
                viewTypes.put(item.getClass(), type);
                holderFactories.put(type, item);
                type++;
            }
        }
    }

    @NonNull
    @Override
    public DrawerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        DrawerViewHolder holder = holderFactories.get(viewType).createViewHolder(parent);
        holder.adapter = this;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DrawerViewHolder holder, int position) {
        items.get(position).bindViewHolder(holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return viewTypes.get(items.get(position).getClass());
    }

    public void setSelected(int position) {
        DrawerItemModel newChecked = items.get(position);
        if (!newChecked.isSelectable()) {
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            DrawerItemModel drawer = items.get(i);
            if (drawer.isChecked()) {
                drawer.setChecked(false);
                notifyItemChanged(i);
                break;
            }
        }
        newChecked.setChecked(true);
        notifyItemChanged(position);

        if (listener != null) {
            listener.onItemSelected(position);
        }

    }

    public void setListener(OnItemSelectedListener listener) {
        this.listener = listener;
    }

    public interface OnItemSelectedListener {
        void onItemSelected(int position);
    }

    public static class DrawerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private DrawerAdapter adapter;

        public DrawerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            adapter.setSelected(getAdapterPosition());
        }
    }

}
