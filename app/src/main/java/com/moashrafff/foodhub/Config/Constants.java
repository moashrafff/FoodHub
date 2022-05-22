package com.moashrafff.foodhub.Config;

public class Constants {
    public static String BaseUrl = "https://direct-app.net/";
    public static String ImageFolderUrl = "https://direct-app.net/food/";
    public static String HomeFeatures = "home";

    public static String FoodDetailsFeatures = "food";
    public static String ResDetailsFeatures = "restaurant";

    public static String FoodDetailsId;
    public static String ResDetailsId;


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

}
