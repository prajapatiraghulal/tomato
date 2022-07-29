package com.tomato.controller;

import com.tomato.model.HomePageResponse;
import com.tomato.model.Item;
import com.tomato.model.Restaurant;
import com.tomato.model.User;
import com.tomato.repository.ItemRepository;
import com.tomato.repository.RestaurantRepository;
import com.tomato.repository.UserRepository;
import com.tomato.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class HomeController {

    @Autowired
    HomeService homeService;

    @PostMapping(value = "/home",  consumes = "application/json", produces = "application/json")
    public HomePageResponse homePage(@RequestBody User user) {

        HomePageResponse homePageResponse = homeService.homePage(user.getUserId());

        return homePageResponse;
    }
}
