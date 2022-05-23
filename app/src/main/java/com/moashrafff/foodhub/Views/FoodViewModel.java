package com.moashrafff.foodhub.Views;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moashrafff.foodhub.Data.Model.Food;
import com.moashrafff.foodhub.Data.Model.Restaurant;
import com.moashrafff.foodhub.Data.Model.RestaurantDetailsRoot;
import com.moashrafff.foodhub.Data.Model.Root;
import com.moashrafff.foodhub.Networking.FoodClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodViewModel extends ViewModel {

    public MutableLiveData<Root> roots = new MutableLiveData<>();

    public MutableLiveData<Food> foods = new MutableLiveData<>();
    public MutableLiveData<RestaurantDetailsRoot> resRoot = new MutableLiveData<>();

    public MutableLiveData<ArrayList<Restaurant>> searchRestaurant = new MutableLiveData<>();
    public MutableLiveData<ArrayList<Food>> searchFood = new MutableLiveData<>();

    public MutableLiveData<ArrayList<Food>> foodsByCategories = new MutableLiveData<>();

    public MutableLiveData<String> registerTest = new MutableLiveData<>();

    public void getRoot() {
        FoodClient.getINSTANCE().getRoot().enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                roots.setValue(response.body());
                Log.e("TAG", "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });
    }

    public void getFood() {
        FoodClient.getINSTANCE().getFood().enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                foods.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {

            }
        });
    }

    public void getRestaurant() {
        FoodClient.getINSTANCE().getRest().enqueue(new Callback<RestaurantDetailsRoot>() {
            @Override
            public void onResponse(Call<RestaurantDetailsRoot> call, Response<RestaurantDetailsRoot> response) {
                resRoot.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RestaurantDetailsRoot> call, Throwable t) {

            }
        });
    }


    public void getSearchRestaurant() {
        FoodClient.getINSTANCE().getSearchRestaurant().enqueue(new Callback<ArrayList<Restaurant>>() {
            @Override
            public void onResponse(Call<ArrayList<Restaurant>> call, Response<ArrayList<Restaurant>> response) {
                searchRestaurant.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Restaurant>> call, Throwable t) {

            }
        });
    }

    public void getSearchFood() {
        FoodClient.getINSTANCE().getSearchFood().enqueue(new Callback<ArrayList<Food>>() {
            @Override
            public void onResponse(Call<ArrayList<Food>> call, Response<ArrayList<Food>> response) {
                searchFood.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Food>> call, Throwable t) {

            }
        });
    }

    public void getFoodsByCategories(){
        FoodClient.getINSTANCE().getFoodsById().enqueue(new Callback<ArrayList<Food>>() {
            @Override
            public void onResponse(Call<ArrayList<Food>> call, Response<ArrayList<Food>> response) {
                foodsByCategories.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Food>> call, Throwable t) {

            }
        });
    }

    public void register(){
        FoodClient.getINSTANCE().register().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                    registerTest.setValue(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }




}
