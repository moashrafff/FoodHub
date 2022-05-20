package com.moashrafff.foodhub.Networking;

import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Root;
import com.moashrafff.foodhub.Interfaces.EndPoints;

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
}
