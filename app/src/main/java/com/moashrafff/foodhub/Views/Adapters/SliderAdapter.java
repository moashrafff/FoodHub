package com.moashrafff.foodhub.Views.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.moashrafff.foodhub.Data.Model.Boarding;
import com.moashrafff.foodhub.Data.Model.Restaurant;
import com.moashrafff.foodhub.Data.Source.Local.SliderData;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.databinding.BoardItemBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.MyHolder> {
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.board_item,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder viewHolder, int position) {
        Boarding slide = SliderData.slides[position];
        viewHolder.bind(slide);
    }




    @Override
    public int getCount() {
        return SliderData.slides.length;
    }


    public class MyHolder extends SliderAdapter.ViewHolder {

        BoardItemBinding binding;
        Boarding slide;

        public MyHolder(View itemView) {
            super(itemView);
            binding = BoardItemBinding.bind(itemView);
        }
        public void bind(Boarding slide) {
            this.slide = slide;
            binding.boardImg.setImageResource(slide.getBoarding_img());
            binding.boardTxt.setText(slide.getBoarding_title());

        }
    }


}
