package com.tomato.controller;


import com.tomato.model.OrderInput;
import com.tomato.model.PriceDetail;
import com.tomato.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;


    @PostMapping(value = "/order", consumes = "application/json", produces="application/json")
    public PriceDetail placeOrder(@RequestBody OrderInput orderInput){
        PriceDetail priceDetail= orderService.getPriceDetail(orderInput);
        return priceDetail;
    }
}
