package com.tomato.service;

import com.tomato.repository.RestaurentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminApproveService {

    @Autowired
    RestaurentRepository restaurentRepository;


}
