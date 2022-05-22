package com.moashrafff.foodhub.Config;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;


public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void navigateTo( Class screen){
        Intent i = new Intent(this,screen);
        startActivity(i);
        Animatoo.animateZoom(this);
    }
}
