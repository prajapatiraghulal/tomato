package com.tomato.model;

import java.util.List;

public class EditRestaurantRequest {
    private long userId;
    private String resName;
    private String resDescription;
    private String resAddress;
    private String resImageUrl;

    private String resOffer;

    Item menuItem;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResDescription() {
        return resDescription;
    }

    public void setResDescription(String resDescription) {
        this.resDescription = resDescription;
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }

    public String getResImageUrl() {
        return resImageUrl;
    }

    public void setResImageUrl(String resImageUrl) {
        this.resImageUrl = resImageUrl;
    }

    public String getResOffer() {
        return resOffer;
    }

    public void setResOffer(String resOffer) {
        this.resOffer = resOffer;
    }

    public Item getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(Item menuItem) {
        this.menuItem = menuItem;
    }
}
