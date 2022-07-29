package com.tomato.model;

import java.util.List;

public class HomePageResponse {
    private List<RestaurantHomeDetail> restaurantHomeDetails;
    private UserHomeDetail userHomeDetail;

    public List<RestaurantHomeDetail> getRestaurantHomeDetails() {
        return restaurantHomeDetails;
    }

    public void setRestaurantHomeDetails(List<RestaurantHomeDetail> restaurantHomeDetails) {
        this.restaurantHomeDetails = restaurantHomeDetails;
    }

    public UserHomeDetail getUserHomeDetail() {
        return userHomeDetail;
    }

    public void setUserHomeDetail(UserHomeDetail userHomeDetail) {
        this.userHomeDetail = userHomeDetail;
    }
}
