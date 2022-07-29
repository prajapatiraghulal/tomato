package com.tomato.controller;

import com.tomato.model.AdminPendingRequest;
import com.tomato.model.AdminPendingResponse;
import com.tomato.model.RestaurantDetail;
import com.tomato.repository.UpdateStatusRepository;
import com.tomato.service.UpdateStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    UpdateStatusService updateStatusService;


    @GetMapping(value = "/updatePendingStatus", produces = "application/json")
    public AdminPendingResponse updatestatus(@RequestParam  AdminPendingRequest adminPendingRequest) {
        AdminPendingResponse adminPendingResponse = updateStatusService.updatestatus(adminPendingRequest.getRestaurantId());

        return adminPendingResponse;
    }



}
