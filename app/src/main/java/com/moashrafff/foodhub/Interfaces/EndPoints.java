package com.moashrafff.foodhub.Interfaces;

import com.moashrafff.foodhub.Data.Model.Root;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EndPoints {
    @FormUrlEncoded
    @POST("food/serv.php")
    public Call<Root> getRoot(@Field("method") String method);




}
