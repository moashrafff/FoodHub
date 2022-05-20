package com.moashrafff.foodhub;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.Category;
import com.moashrafff.foodhub.Data.Model.DrawerItemModel;
import com.moashrafff.foodhub.Data.Model.Root;
import com.moashrafff.foodhub.Data.Model.SpaceItem;
import com.moashrafff.foodhub.Views.Adapters.DrawerAdapter;
import com.moashrafff.foodhub.Views.Adapters.HomeCategoriesAdapter;
import com.moashrafff.foodhub.Views.Adapters.SimpleItem;
import com.moashrafff.foodhub.Views.FoodDetailsFragment;
import com.moashrafff.foodhub.Views.FoodViewModel;
import com.moashrafff.foodhub.Views.HomeFragment;
import com.moashrafff.foodhub.Views.signUp;
import com.moashrafff.foodhub.databinding.ActivityHomeScreenBinding;
import com.moashrafff.foodhub.databinding.ActivityMainBinding;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {


    private static final String TAG = "MainActivity";

    private String[] screenTitles;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;



    ActivityHomeScreenBinding binding;
    FoodViewModel viewModel;
    HomeCategoriesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = ActivityHomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        viewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
//        viewModel.getRoot();
//
//        adapter= new HomeCategoriesAdapter(this);
////        binding.catLst.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
////        binding.catLst.setAdapter(adapter);
//
//        viewModel.roots.observe(this, new Observer<Root>() {
//            @Override
//            public void onChanged(Root root) {
//                Log.e(TAG, "onChanged: "+root.getCategories() );
//            adapter.setCategories(root.getCategories());
//            }
//        });
        binding.btmNavBar.setItemSelected(R.id.bottm_nav_dash_board,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        bottomNav();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        slidingRootNav = new SlidingRootNavBuilder(this)
                .withRootViewScale(0.75f)
                .withDragDistance(180)
                .withRootViewElevation(25)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.drawer_menu_layout)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(createItemFor(Constants.POS_CLOSE)
        ,createItemFor(Constants.POS_MY_PROFILE)
        ,createItemFor(Constants.POS_DEL_ADD)
        ,createItemFor(Constants.POS_PAY_MET)
        ,createItemFor(Constants.POS_CONTACT_US)
        ,createItemFor(Constants.POS_SET)
        ,createItemFor(Constants.POS_HELP)
        ,new SpaceItem(260)
        ,createItemFor(Constants.POS_LOG_OUT)
        ));

        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.drawer_list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(Constants.POS_MY_PROFILE);

    }

    private DrawerItemModel createItemFor(int position){
        return new SimpleItem(screenIcons[position],screenTitles[position])
                .withTextTint(R.color.auth_color)
                .withSelectedTextTint(R.color.btn_color);

    }


    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray array = getResources().obtainTypedArray(R.array.activityScreenIcons);
        Drawable[] icons = new Drawable[array.length()];

        for (int i = 0; i<array.length();i++){
            int id  = array.getResourceId(i,0);
            if (id!=0){
                icons[i] = ContextCompat.getDrawable(this,id);
            }
        }
        array.recycle();
        return icons;
    }



    private void bottomNav() {

        binding.btmNavBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){
                    case R.id.bottm_nav_dash_board:
                        fragment = new CartFragment();
                        break;
                    case R.id.shop_nav_dash_board:
                        fragment = new signUp();
                        break;
                    case R.id.food_det_dash_board:
                        fragment = new FoodDetailsFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });
    }

    @Override
    public void onItemSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (position == Constants.POS_MY_PROFILE){
            CartFragment fragment = new CartFragment();
            transaction.replace(R.id.container,fragment);
        }

        slidingRootNav.closeMenu();
        transaction.addToBackStack(null);
        transaction.commit();
    }
}