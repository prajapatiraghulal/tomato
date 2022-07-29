package com.tomato.repository;

import com.tomato.model.AdminPendingRequest;
import com.tomato.model.OrderHistory;
import com.tomato.model.Restaurant;
import com.tomato.model.RestaurantDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UpdateStatusRepository extends MongoRepository<Restaurant, Long> {
    public AdminPendingRequest deleteByRestaurantId(long restaurantId);


}
