package com.moashrafff.foodhub.Interfaces;

import com.moashrafff.foodhub.Data.Model.Food;
import com.moashrafff.foodhub.Data.Model.Restaurant;
import com.moashrafff.foodhub.Data.Model.RestaurantDetailsRoot;
import com.moashrafff.foodhub.Data.Model.Root;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EndPoints {
    @FormUrlEncoded
    @POST("food/serv.php")
    public Call<Root> getRoot(@Field("method") String method);

    @FormUrlEncoded
    @POST("food/serv.php")
    public Call<Food> getFood(@Field("method")String method, @Field("food_id")String foodId);

    @FormUrlEncoded
    @POST("food/serv.php")
    public Call<RestaurantDetailsRoot> getRest(@Field("method")String method, @Field("restaurant_id")String foodId);

    @FormUrlEncoded
    @POST("food/serv.php")
    public Call<ArrayList<Food>> getFoodsById(@Field("method")String method, @Field("cat_id")String catId);

    @FormUrlEncoded
    @POST("food/serv.php")
    public Call<ArrayList<Restaurant>> getSearchRestaurant(@Field("method")String method, @Field("keyword")String keyword);

    @FormUrlEncoded
    @POST("food/serv.php")
    public Call<ArrayList<Food>> getSearchFood(@Field("method")String method, @Field("keyword")String keyword);

    @FormUrlEncoded
    @POST("food/serv.php")
    public Call<ArrayList<Food>> register(@Field("method")String method, @Field("keyword")String keyword);




}
