package com.tomato.repository;

import com.tomato.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,Long> {
    public Order findByOrderId(long orderId);
}
