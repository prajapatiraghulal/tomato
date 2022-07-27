package com.tomato.repository;

import com.tomato.model.OrderHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRepository extends MongoRepository<OrderHistory, Long> {
    public OrderHistory findByUserId(long userId);
}
