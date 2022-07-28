package com.tomato.repository;

import com.tomato.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item,Long> {
    Item findById(long id);
    Item findByName(String name);

    List<Item> findAllByRestaurantId(long restaurantId);
}
