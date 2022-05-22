package com.moashrafff.foodhub.Views.Pages.a_Intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Adapters.SliderAdapter;
import com.moashrafff.foodhub.Views.Pages.c_Home.ActivityAuth;
import com.moashrafff.foodhub.databinding.ActivityOnBoardingScreenBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;

public class OnBoardingScreen extends AppCompatActivity implements View.OnClickListener {


    private ActivityOnBoardingScreenBinding binding;
    private SliderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardingScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new SliderAdapter();

        binding.imageSlider.setSliderAdapter(adapter);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.DROP);
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.FANTRANSFORMATION);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.board_btn:
                startActivity(new Intent(this, ActivityAuth.class));
                finish();
        }
    }
}