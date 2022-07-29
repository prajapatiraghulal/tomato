package com.tomato.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
public class AdminPendingRequest {

    @Id
    private long restaurantId;





    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }


}
