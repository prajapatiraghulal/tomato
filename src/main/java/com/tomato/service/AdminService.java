package com.tomato.service;

import com.tomato.model.AdminPendingRequest;
import com.tomato.model.Restaurant;
import com.tomato.model.RestaurantApproveResponse;
import com.tomato.repository.AdminPendingRequestRepository;
import com.tomato.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    AdminPendingRequestRepository adminPendingRequestRepository;

    public RestaurantApproveResponse approveRequest(){
        List<AdminPendingRequest> adminPendingRequestList = new ArrayList<AdminPendingRequest>();
        adminPendingRequestList = adminPendingRequestRepository.findAll();
        RestaurantApproveResponse restaurantApproveResponse = new RestaurantApproveResponse();
        for(AdminPendingRequest adminPendingRequest : adminPendingRequestList){
            Restaurant restaurant = restaurantRepository.findById(adminPendingRequest.getId());
            if(restaurant == null){
                restaurantApproveResponse.setStatus(false);
                restaurantApproveResponse.setMessage("Restaurant not found!!!");
                return restaurantApproveResponse;
            }
            restaurant.setStatus(1);
            Restaurant newRestaurant = restaurantRepository.save(restaurant);
            if(newRestaurant == null) {
                restaurantApproveResponse.setStatus(false);
                restaurantApproveResponse.setMessage("Couldn't approve!!! Something went wrong");
                return restaurantApproveResponse;
            }
        }
        restaurantApproveResponse.setStatus(true);
        restaurantApproveResponse.setMessage("All Restaurants approved!!!");
        adminPendingRequestRepository.deleteAll();
        return restaurantApproveResponse;
    }


}
