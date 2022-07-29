package com.tomato.repository;

import com.tomato.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item,Long> {
    Item findByItemId(long itemId);
    Item findByName(String name);

    List<Item> findAllByrestaurantId(long restaurantId);
}
