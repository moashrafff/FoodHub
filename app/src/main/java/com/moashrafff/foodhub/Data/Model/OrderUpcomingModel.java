package com.moashrafff.foodhub.Data.Model;

public class OrderUpcomingModel {

    private int id;
    private String orderNumber;
    private String numberOfItem;
    private String restName;
    private String arrivalTime;
    private String orderStatus;
    private int restUpcomingImage;
    private OrderDetailsModel orderDetailsModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(String numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getRestUpcomingImage() {
        return restUpcomingImage;
    }

    public void setRestUpcomingImage(int restUpcomingImage) {
        this.restUpcomingImage = restUpcomingImage;
    }

    public OrderDetailsModel getOrderDetailsModel() {
        return orderDetailsModel;
    }

    public void setOrderDetailsModel(OrderDetailsModel orderDetailsModel) {
        this.orderDetailsModel = orderDetailsModel;
    }
}
