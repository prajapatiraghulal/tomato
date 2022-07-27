package com.tomato.service;

import com.tomato.model.PriceDetail;
import com.tomato.repository.OrderHistoryRepository;
import com.tomato.repository.OrderRepository;
import com.tomato.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    public boolean makePayment(PriceDetail priceDetail){
        return true;
    }

}
