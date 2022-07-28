package com.tomato.model;

import javax.persistence.Entity;
import java.util.List;


public class CartDetail {
    private long userId;
    private float totalAmount;
    private List<BriefItem> briefItemList;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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
