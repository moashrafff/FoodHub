package com.moashrafff.foodhub.Data.Model;

public class OrderHistoryModel {
    private int id;
    private String orderDate;
    private String ItemsNumber;
    private String restName;
    private String historyStatus;
    private String historyPrice;
    private int restHistoryImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getItemsNumber() {
        return ItemsNumber;
    }

    public void setItemsNumber(String itemsNumber) {
        ItemsNumber = itemsNumber;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getHistoryStatus() {
        return historyStatus;
    }

    public void setHistoryStatus(String historyStatus) {
        this.historyStatus = historyStatus;
    }

    public String getHistoryPrice() {
        return historyPrice;
    }

    public void setHistoryPrice(String historyPrice) {
        this.historyPrice = historyPrice;
    }

    public int getRestHistoryImage() {
        return restHistoryImage;
    }

    public void setRestHistoryImage(int restHistoryImage) {
        this.restHistoryImage = restHistoryImage;
    }
}
