package com.tomato.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(collection = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    private String userAddress;
    private String restaurantName;
    private long gstNumber;
    private long timestamp;
    private CartDetail cartDetail;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public long getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(long gstNumber) {
        this.gstNumber = gstNumber;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public CartDetail getCartDetail() {
        return cartDetail;
    }

    public void setCartDetail(CartDetail cartDetail) {
        this.cartDetail = cartDetail;
    }
}
