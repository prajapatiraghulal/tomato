package com.tomato.service;

import com.tomato.model.*;
import com.tomato.repository.AdminPendingRequestRepository;
import com.tomato.repository.ItemRepository;
import com.tomato.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    AdminPendingRequestRepository adminPendingRequestRepository;

    @Autowired
    ItemRepository itemRepository;

    public boolean addRestaurant(AddRestaurantRequest addRestaurantRequest) {

        Restaurant restaurant = new Restaurant();

        restaurant.setId(addRestaurantRequest.getUserId());
        restaurant.setDescription(addRestaurantRequest.getDescription());
        restaurant.setName(addRestaurantRequest.getName());
        restaurant.setAddress(addRestaurantRequest.getAddress());
        restaurant.setImageUrl(addRestaurantRequest.getImageUrl());


        // Add the status as pending
        restaurant.setStatus(3);

        //Add this restaurant to admin pending request.
        AdminPendingRequest adminPendingRequest = new AdminPendingRequest();
        adminPendingRequest.setId(restaurant.getId());
        adminPendingRequestRepository.save(adminPendingRequest);

        Restaurant restaurant1 = restaurantRepository.save(restaurant);

        if(restaurant1 != null) return true;

        return false;
    }

    public boolean editRestaurant(EditRestaurantRequest editRestaurantRequest) {

        Restaurant restaurant = restaurantRepository.findById(editRestaurantRequest.getUserId());

        if(restaurant == null) return false;

        if(editRestaurantRequest.getResName() != null)
            restaurant.setName(editRestaurantRequest.getResName());
        if(editRestaurantRequest.getResDescription() != null)
            restaurant.setDescription(editRestaurantRequest.getResDescription());
        if(editRestaurantRequest.getResOffer() != null)
            restaurant.setOffer(editRestaurantRequest.getResOffer());
        if(editRestaurantRequest.getResAddress() != null)
            restaurant.setAddress(editRestaurantRequest.getResAddress());
        if(editRestaurantRequest.getResImageUrl() != null)
            restaurant.setImageUrl(editRestaurantRequest.getResImageUrl());


        Item item = itemRepository.findById(editRestaurantRequest.getMenuItem().getId());

        if(item == null) {
            Item item1 = itemRepository.save(editRestaurantRequest.getMenuItem());
            List<Long> items;
            if(restaurant.getItemIds() != null)
                items = restaurant.getItemIds();
            else {
                items = new ArrayList<>();
            }
            items.add(item1.getId());

            restaurant.setItemIds(items);
        }

        Restaurant restaurant1 = restaurantRepository.save(restaurant);

        return restaurant1 != null;
    }

    public boolean deleteRestaurant(long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId);

        for(long itemid : restaurant.getItemIds()) {
            itemRepository.deleteById(itemid);
        }

        Restaurant restaurant2 = restaurantRepository.deleteById(restaurantId);

        return (restaurant2 != null);
    }

}
