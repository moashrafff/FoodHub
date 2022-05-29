package com.moashrafff.foodhub.Views.Adapters.ReviewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.ReviewModel;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.ReviewItemBinding;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewHolder>  {

    private Context context;
    private ArrayList<ReviewModel> reviews = new ArrayList<>();

    public void setReviews(ArrayList<ReviewModel> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    public ReviewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item,parent,false);
        return new ReviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewHolder holder, int position) {
        ReviewModel model = reviews.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class ReviewHolder extends RecyclerView.ViewHolder {

         ReviewModel model;
         ReviewItemBinding binding;
        public ReviewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ReviewItemBinding.bind(itemView);
        }
        public void bind(ReviewModel model){
            this.model = model;
            binding.tvName.setText(model.getUserName());
            binding.tvDescription.setText(model.getReview_Text());
            binding.tvDate.setText(model.getReviewDate());
            Glide.with(context).load(Constants.ImageFolderUrl + model.getUserImage()).into(binding.civUser);
        }
    }

}
