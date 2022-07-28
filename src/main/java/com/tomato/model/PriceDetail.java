package com.tomato.model;

public class PriceDetail {
    private long userId;
    private float totalPrice;
    private float gst;
    private float deliveryCharge;
    private float totalPriceAfterGst;
    private  long offer;
    private String restaurantName;
    private String userAddress;

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public long getOffer() {
        return offer;
    }

    public void setOffer(long offer) {
        this.offer = offer;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getGst() {
        return gst;
    }

    public void setGst(float gst) {
        this.gst = gst;
    }

    public float getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(float deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public float getTotalPriceAfterGst() {
        return totalPriceAfterGst;
    }

    public void setTotalPriceAfterGst(float totalPriceAfterGst) {
        this.totalPriceAfterGst = totalPriceAfterGst;
    }


}
