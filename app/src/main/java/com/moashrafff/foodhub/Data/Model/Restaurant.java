package com.moashrafff.foodhub.Data.Model;

public class Restaurant {
    public String id;
    public String name;
    public String pic;
    public String delivery;
    public String delivery_time;
    public String tags;
    public String rating;
    public String cover_photo;
    public String verified;
    public String number_of_ratings;
    public String address;
    public String lat;
    public String lng;

    public Restaurant(String id, String name, String pic, String delivery, String delivery_time, String tags, String rating, String cover_photo, String verified, String number_of_ratings, String address, String lat, String lng) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.delivery = delivery;
        this.delivery_time = delivery_time;
        this.tags = tags;
        this.rating = rating;
        this.cover_photo = cover_photo;
        this.verified = verified;
        this.number_of_ratings = number_of_ratings;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPic() {
        return pic;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public String getTags() {
        return tags;
    }

    public String getRating() {
        return rating;
    }

    public String getCover_photo() {
        return cover_photo;
    }

    public String getVerified() {
        return verified;
    }

    public String getNumber_of_ratings() {
        return number_of_ratings;
    }

    public String getAddress() {
        return address;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
