package com.tomato.repository;

import com.tomato.model.AdminPendingRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminPendingRequestRepository extends MongoRepository<AdminPendingRequest, Long> {


}
