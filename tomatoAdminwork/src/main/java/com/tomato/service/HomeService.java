package com.tomato.service;

import com.tomato.model.*;
import com.tomato.repository.RestaurantRepository;
import com.tomato.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    UserRepository userRepository;

    public HomePageResponse homePage(long userId) {
        List<Restaurant> allRestaurants = restaurantRepository.findAll();
        User user = userRepository.findByUserId(userId);

        //Populate RestaurantHomeDetail
        List<RestaurantHomeDetail> restaurantHomeDetails = new ArrayList<>();
        for(Restaurant restaurant : allRestaurants) {
            RestaurantHomeDetail restaurantHomeDetail = new RestaurantHomeDetail();
           restaurantHomeDetail.setRestaurantId(restaurant.getRestaurantId());
           restaurantHomeDetail.setName(restaurant.getName());
           restaurantHomeDetail.setAddress(restaurant.getAddress());
           restaurantHomeDetail.setDescription(restaurant.getDescription());
           restaurantHomeDetail.setStatus(restaurant.getStatus());
           restaurantHomeDetail.setImageUrl(restaurant.getImageUrl());

           restaurantHomeDetails.add(restaurantHomeDetail);
        }

        //Populate UserHomeDetail
        UserHomeDetail userHomeDetail = new UserHomeDetail();
        userHomeDetail.setUserId(user.getUserId());
        userHomeDetail.setName(user.getName());

        //Make HomePageResponse by RestaurantHomeDetail and UserHomeDetail
        HomePageResponse homePageResponse = new HomePageResponse();
        homePageResponse.setRestaurantHomeDetails(restaurantHomeDetails);
        homePageResponse.setUserHomeDetail(userHomeDetail);

        return homePageResponse;
    }
}
