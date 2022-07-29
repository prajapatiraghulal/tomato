package com.tomato.service;

import com.tomato.model.Item;
import com.tomato.model.Restaurant;
import com.tomato.model.RestaurantDetail;
import com.tomato.repository.ItemRepository;
import com.tomato.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ItemRepository itemRepository;

    public RestaurantDetail searchRestaurant(String name) {
        Restaurant restaurant = restaurantRepository.findByName(name);

        List<Item> menuItems = itemRepository.findAllByrestaurantId(restaurant.getRestaurantId());

        RestaurantDetail restaurantDetail = new RestaurantDetail();

        restaurantDetail.setRestaurant(restaurant);
        restaurantDetail.setItems(menuItems);

        return restaurantDetail;
    }
}
