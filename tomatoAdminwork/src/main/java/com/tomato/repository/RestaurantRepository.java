package com.tomato.repository;

import com.tomato.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RestaurantRepository extends MongoRepository<Restaurant, Long> {


    Restaurant findByName(String name);
    List<Restaurant> findAll();
}
