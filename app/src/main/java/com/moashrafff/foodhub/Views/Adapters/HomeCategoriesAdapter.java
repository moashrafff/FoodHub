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
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.CategoriesItemBinding;

import java.util.ArrayList;

public class HomeCategoriesAdapter extends RecyclerView.Adapter<HomeCategoriesAdapter.CategoryViewHolder> {

    Context context;
    ArrayList<Category> categories = new ArrayList<>();

    public HomeCategoriesAdapter(Context context) {
        this.context = context;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryViewHolder holder = new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category model = categories.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        CategoriesItemBinding binding;
        Category model;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CategoriesItemBinding.bind(itemView);
        }

        public void bind(Category model) {
            this.model = model;
            binding.catTitle.setText(model.getCat_name());
            Glide.with(context).load(Constants.ImageFolderUrl + model.getCat_pic()).into(binding.catImg);

        }
    }
}
