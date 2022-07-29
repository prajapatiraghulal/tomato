package com.tomato.controller;

import com.tomato.model.Restaurant;
import com.tomato.model.RestaurantDetail;
import com.tomato.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RestaurantController {

    @Autowired
    SearchService searchService;


    @GetMapping(value = "/browseRestaurant", produces = "application/json")
    public RestaurantDetail searchRestaurant(@RequestParam String name) {
        RestaurantDetail restaurantDetail = searchService.searchRestaurant(name);

        return restaurantDetail;
    }

}
