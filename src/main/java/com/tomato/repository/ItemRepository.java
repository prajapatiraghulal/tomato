package com.tomato.repository;

import com.tomato.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item,String> {
    Item findByItemId(String itemId);
    Item findByName(String name);
}
