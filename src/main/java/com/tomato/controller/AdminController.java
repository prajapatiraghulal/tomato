package com.tomato.controller;

import com.tomato.model.AdminPendingRequest;
import com.tomato.model.Item;
import com.tomato.model.RestaurantApproveResponse;
import com.tomato.repository.AdminPendingRequestRepository;
import com.tomato.repository.RestaurantRepository;
import com.tomato.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    AdminPendingRequestRepository adminPendingRequestRepository;

    @PostMapping(value = "/approveRequest", produces = "application/json")
    public RestaurantApproveResponse approveRequest(){
        RestaurantApproveResponse restaurantApproveResponse = adminService.approveRequest();
        return restaurantApproveResponse;
    }

    @PostMapping(value = "/addPendingRequest", produces = "application/json",consumes = "application/json")
    public void addToAdminRepo(@RequestBody AdminPendingRequest adminPendingRequest){
        adminPendingRequestRepository.save(adminPendingRequest);
    }

}
