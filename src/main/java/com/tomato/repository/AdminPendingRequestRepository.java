package com.tomato.repository;

import com.tomato.model.AdminPendingRequest;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface AdminPendingRequestRepository extends MongoRepository<AdminPendingRequest, Long> {
    AdminPendingRequest findById(long id);

    List<AdminPendingRequest> findAll();

}
