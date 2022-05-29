package com.moashrafff.foodhub.Data.Model;

public class ReviewModel {


    private String UserName;
    private String reviewDate;
    private String review_Text;
    private String userImage;
    private int restId;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReview_Text() {
        return review_Text;
    }

    public void setReview_Text(String review_Text) {
        this.review_Text = review_Text;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
}
