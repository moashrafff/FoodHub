package com.moashrafff.foodhub.Data.Model;

import java.util.ArrayList;

public class RestaurantDetailsRoot {
    public Restaurant restaurant;
    public ArrayList<Item> items;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
