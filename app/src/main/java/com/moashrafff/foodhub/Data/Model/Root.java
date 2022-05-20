package com.moashrafff.foodhub.Data.Model;

import java.util.ArrayList;

public class Root {
    private ArrayList<Category> categories;
    private ArrayList<Restaurant> restaurants;
    private ArrayList<Food> foods;

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }
}
