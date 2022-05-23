package com.moashrafff.foodhub.Config;

import android.net.Uri;

public class Constants {
    public static String BaseUrl = "https://direct-app.net/";
    public static String ImageFolderUrl = "https://direct-app.net/food/";
    public static String HomeFeatures = "home";

    public static String FoodDetailsFeatures = "food";
    public static String ResDetailsFeatures = "restaurant";
    public static String CatDetailsFeatures = "foods";

    public static String FoodDetailsId;
    public static String ResDetailsId;
    public static String CatId;


    public static String FoodSearchMethod = "search_restaurant";
    public static String ResSearchMethod = "search_food";
    public static String FoodSearchKeyWord;
    public static String ResSearchKeyWord;


    public static final int POS_CLOSE = 0;
    public static final int POS_MY_PROFILE = 1;
    public static final int POS_DEL_ADD = 2;
    public static final int POS_PAY_MET = 3;
    public static final int POS_CONTACT_US = 4;
    public static final int POS_SET = 5;
    public static final int POS_HELP = 6;
    public static final int POS_LOG_OUT = 7;

    public static Uri USER_PROFILE_PIC;

    public static void setUserProfilePic(Uri userProfilePic) {
        USER_PROFILE_PIC = userProfilePic;
    }

    //Registration_Constants
    public static final String REG_METHOD = "signup";
    public static final String REG_TYPE = "user";
    public static  String REG_EMAIL ;
    public static  String REG_PASS ;
    public static  String REG_NAME ;
    public static  String REG_MOBILE ;


    //Login_Constants
    public static final String LOG_METHOD = "login";
    public static final String LOG_TYPE = "user";
    public static  String LOG_EMAIL ;
    public static  String LOG_PASS ;

    public static void setLogEmail(String logEmail) {
        LOG_EMAIL = logEmail;
    }

    public static void setLogPass(String logPass) {
        LOG_PASS = logPass;
    }

    public static void setRegEmail(String regEmail) {
        REG_EMAIL = regEmail;
    }

    public static void setRegPass(String regPass) {
        REG_PASS = regPass;
    }

    public static void setRegName(String regName) {
        REG_NAME = regName;
    }

    public static void setRegMobile(String regMobile) {
        REG_MOBILE = regMobile;
    }

    public static void setFoodDetailsId(String foodDetailsId) {
        FoodDetailsId = foodDetailsId;
    }

    public static void setFoodSearchKeyWord(String foodSearchKeyWord) {
        FoodSearchKeyWord = foodSearchKeyWord;
    }

    public static void setResSearchKeyWord(String resSearchKeyWord) {
        ResSearchKeyWord = resSearchKeyWord;
    }

    public static void setResDetailsId(String resDetailsId) {
        ResDetailsId = resDetailsId;
    }

    public static void setCatId(String catId) {
        CatId = catId;
    }
}
