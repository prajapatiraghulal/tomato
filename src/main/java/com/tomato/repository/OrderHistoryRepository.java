package com.tomato.repository;

import com.tomato.model.OrderHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRepository extends MongoRepository<OrderHistory, String> {
    public OrderHistory findByUserId(String userId);
}
