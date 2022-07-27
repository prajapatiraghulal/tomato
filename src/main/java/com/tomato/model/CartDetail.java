package com.tomato.model;

import javax.persistence.Entity;
import java.util.List;


public class CartDetail {
    private String userId;
    private float totalAmount;
    private List<BriefItem> briefItemList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<BriefItem> getBriefItemList() {
        return briefItemList;
    }

    public void setBriefItemList(List<BriefItem> briefItemList) {
        this.briefItemList = briefItemList;
    }
}
