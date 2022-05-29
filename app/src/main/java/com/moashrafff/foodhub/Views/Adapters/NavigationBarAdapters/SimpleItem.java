package com.moashrafff.foodhub.Views.Adapters.NavigationBarAdapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;

import com.moashrafff.foodhub.Data.Model.DrawerItemModel;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.ItemOptionLayoutBinding;

public class SimpleItem extends DrawerItemModel<SimpleItem.SimpleItemViewHolder> {

    private int selectedItemTextTint;
    private int normalItemTextTint;

    private Drawable icon;
    private String title;

    public SimpleItem(Drawable icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    @Override
    public SimpleItemViewHolder createViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_option_layout,parent,false);
        return new SimpleItemViewHolder(v);
    }

    @Override
    public void bindViewHolder(SimpleItemViewHolder holder) {

        holder.bind(icon,title);
        holder.binding.optionText.setTextColor(isChecked ? selectedItemTextTint : normalItemTextTint);

    }

    public SimpleItem withSelectedTextTint(int selectedItemTextTint){
        this.selectedItemTextTint = selectedItemTextTint;
        return this;
    }
    public SimpleItem withTextTint(int normalItemTextTint){
        this.normalItemTextTint = normalItemTextTint;
        return this;
    }

    static class SimpleItemViewHolder extends DrawerAdapter.DrawerViewHolder {

        ItemOptionLayoutBinding binding;

        public SimpleItemViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemOptionLayoutBinding.bind(itemView);
        }

        public void bind(Drawable icon,String title) {

            binding.optionText.setText(title);
            binding.optionImage.setImageDrawable(icon);

        }
    }
}
