package com.tomato.controller;

import com.tomato.model.AddRestaurantRequest;
import com.tomato.model.EditRestaurantRequest;
import com.tomato.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManagerController {

    @Autowired
    ManagerService managerService;


    @PostMapping(value = "/addRestaurant", consumes = "application/json", produces = "application/json")
    public boolean addRestaurant(@RequestBody AddRestaurantRequest addRestaurantRequest) {

        return managerService.addRestaurant(addRestaurantRequest);
    }

    @PostMapping(value = "/editRestaurant", consumes = "application/json", produces = "application/json")
    public boolean editRestaurant(@RequestBody EditRestaurantRequest editRestaurantRequest) {

        return managerService.editRestaurant(editRestaurantRequest);
    }

    @GetMapping(value = "/deleteRestaurant", produces = "application/json")
    public boolean deleteRestaurant(@RequestParam long restaurantId) {

        return managerService.deleteRestaurant(restaurantId);
    }

}
