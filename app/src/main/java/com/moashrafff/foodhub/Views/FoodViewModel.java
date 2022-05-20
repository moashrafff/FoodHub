package com.moashrafff.foodhub.Views;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moashrafff.foodhub.Data.Model.Root;
import com.moashrafff.foodhub.Networking.FoodClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodViewModel extends ViewModel {

    public MutableLiveData<Root> roots = new MutableLiveData<>();

    public void getRoot(){
        FoodClient.getINSTANCE().getRoot().enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                roots.setValue(response.body());
                Log.e("TAG", "onResponse: "+response.body() );
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });
    }
}
