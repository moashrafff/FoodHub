package com.moashrafff.foodhub.Views.Pages.c_Home;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.moashrafff.foodhub.Config.Constants;
import com.moashrafff.foodhub.Data.Model.DrawerItemModel;
import com.moashrafff.foodhub.Data.Model.SpaceItem;
import com.moashrafff.foodhub.R;
import com.moashrafff.foodhub.Views.Adapters.NavigationBarAdapters.DrawerAdapter;
import com.moashrafff.foodhub.Views.Adapters.NavigationBarAdapters.SimpleItem;
import com.moashrafff.foodhub.Views.Pages.g_Cart.CartFragment;
import com.moashrafff.foodhub.Views.Pages.d_Details.FoodDetailsFragment;
import com.moashrafff.foodhub.Views.Pages.i_Profile.MyProfileFragment;
import com.moashrafff.foodhub.databinding.ActivityHomeScreenBinding;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {


    private static final String TAG = "MainActivity";

    private String[] screenTitles;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;
    ActivityHomeScreenBinding binding;
    Toolbar toolbar;

    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btmNavBar.setItemSelected(R.id.bottm_nav_dash_board, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
        bottomNav();

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        binding.toolbarPic.setImageURI(Constants.USER_PROFILE_PIC);
        binding.toolbarTitle.setText("Home");


        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.drawer_menu_layout)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(createItemFor(Constants.POS_CLOSE)
                , createItemFor(Constants.POS_MY_PROFILE)
                , createItemFor(Constants.POS_DEL_ADD)
                , createItemFor(Constants.POS_PAY_MET)
                , createItemFor(Constants.POS_CONTACT_US).setChecked(true)
                , createItemFor(Constants.POS_SET)
                , createItemFor(Constants.POS_HELP)
                , new SpaceItem(260)
                , createItemFor(Constants.POS_LOG_OUT)
        ));


        RecyclerView list = findViewById(R.id.drawer_list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(Constants.POS_CONTACT_US);
        adapter.setListener(this);

    }

    private DrawerItemModel createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withTextTint(R.color.auth_color)
                .withSelectedTextTint(R.color.btn_color);
    }

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finishAffinity();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray array = getResources().obtainTypedArray(R.array.activityScreenIcons);
        Drawable[] icons = new Drawable[array.length()];

        for (int i = 0; i < array.length(); i++) {
            int id = array.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
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
                switch (i) {
                    case R.id.bottm_nav_dash_board:
                        fragment = new HomeFragment();
                        binding.toolbarTitle.setText("Home");
                        break;
                    case R.id.shop_nav_dash_board:
                        fragment = new CartFragment();
                        binding.toolbarTitle.setText("Cart");
                        break;
                    case R.id.food_det_dash_board:
                        fragment = new FoodDetailsFragment();
                        binding.toolbarTitle.setText("Food Details");
                        break;

                }
                showFragment(fragment);
            }
        });
    }

    @Override
    public void onItemSelected(int position) {
        Fragment fragment = null;

        switch (position) {
            case Constants.POS_MY_PROFILE:
                fragment = new MyProfileFragment();
                binding.toolbarTitle.setText("My Profile");

                break;
            case Constants.POS_DEL_ADD:
                fragment = new CartFragment();
                binding.toolbarTitle.setText("Cart");
                break;
        }
        showFragment(fragment);
        slidingRootNav.closeMenu();

    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

}