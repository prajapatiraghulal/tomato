package com.tomato.controller;

import com.tomato.model.RestaurantDetail;
import com.tomato.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    SearchService searchService;


    @GetMapping(value = "/search", produces = "application/json")
    public RestaurantDetail searchRestaurant(@RequestParam String name) {
        RestaurantDetail restaurantDetail = searchService.searchRestaurant(name);

        return restaurantDetail;
    }
}
