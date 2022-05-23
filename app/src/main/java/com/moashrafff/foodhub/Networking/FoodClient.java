package com.moashrafff.foodhub.Networking;

import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Food;
import com.moashrafff.foodhub.Data.Model.Restaurant;
import com.moashrafff.foodhub.Data.Model.RestaurantDetailsRoot;
import com.moashrafff.foodhub.Data.Model.Root;
import com.moashrafff.foodhub.Data.Model.User;
import com.moashrafff.foodhub.Interfaces.EndPoints;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodClient {

    private EndPoints Interface;
    private static FoodClient INSTANCE;

    public FoodClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Interface = retrofit.create(EndPoints.class);
    }

    public static FoodClient getINSTANCE () {
        if (null == INSTANCE){
            INSTANCE = new FoodClient();
        }
        return INSTANCE;
    }

    public Call<Root> getRoot(){
        return Interface.getRoot(Constants.HomeFeatures);
    }

    public Call<Food> getFood(){
        return Interface.getFood(Constants.FoodDetailsFeatures, Constants.FoodDetailsId);
    }

    public Call<RestaurantDetailsRoot> getRest(){
        return Interface.getRest(Constants.ResDetailsFeatures, Constants.ResDetailsId);
    }

    public Call<ArrayList<Restaurant>> getSearchRestaurant(){
        return Interface.getSearchRestaurant(Constants.FoodSearchMethod,Constants.FoodSearchKeyWord);
    }
    public Call<ArrayList<Food>> getSearchFood(){
        return Interface.getSearchFood(Constants.ResSearchMethod,Constants.ResSearchKeyWord);
    }
    public Call<ArrayList<Food>> getFoodsById(){
        return Interface.getFoodsById(Constants.CatDetailsFeatures,Constants.CatId);
    }

    public Call<String> register(){
        return Interface.register(Constants.REG_METHOD,Constants.REG_TYPE,Constants.REG_EMAIL,Constants.REG_PASS,Constants.REG_NAME,Constants.REG_MOBILE);
    }

    public Call<User> login(){
        return Interface.login(Constants.LOG_EMAIL,Constants.LOG_PASS,Constants.LOG_TYPE,Constants.LOG_METHOD);
    }
}
