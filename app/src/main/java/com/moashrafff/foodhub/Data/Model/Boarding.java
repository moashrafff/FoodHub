package com.moashrafff.foodhub.Data.Model;

public class Boarding {
    public int boarding_img;
    public String boarding_title;


    public Boarding(int boarding_img, String boarding_title) {
        this.boarding_img = boarding_img;
        this.boarding_title = boarding_title;
    }

    public int getBoarding_img() {
        return boarding_img;
    }

    public String getBoarding_title() {
        return boarding_title;
    }
}
