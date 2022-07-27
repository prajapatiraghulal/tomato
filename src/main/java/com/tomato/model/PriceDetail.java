package com.tomato.model;

public class PriceDetail {
    private String userId;
    private float totalPrice;
    private float gst;
    private float deliveryCharge;
    private float totalPriceAfterGst;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
