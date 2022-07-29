package com.tomato.model;

import java.util.List;

public class RestaurantDetail {

    private Restaurant restaurant;
    List<Item> items;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
