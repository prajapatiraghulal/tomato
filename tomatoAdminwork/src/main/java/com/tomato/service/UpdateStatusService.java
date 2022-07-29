package com.tomato.service;

import com.tomato.model.AdminPendingRequest;
import com.tomato.model.AdminPendingResponse;
import com.tomato.repository.UpdateStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStatusService {

    @Autowired
    UpdateStatusRepository updateStatusRepository;

    public AdminPendingResponse updatestatus(long restaurantId)
    {
        updateStatusRepository.deleteByRestaurantId(restaurantId);

        AdminPendingResponse adminPendingResponse = new AdminPendingResponse();
        adminPendingResponse.setStatus(true);
        adminPendingResponse.setMessage("Restaurant Approved");
        return adminPendingResponse;
    }

}
