package com.tomato.controller;

import com.tomato.model.PriceDetail;
import com.tomato.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

@Autowired
PaymentService paymentService;
    @PostMapping(value = "/payment",consumes ="application/json",produces = "application/json")
    boolean payment(@RequestBody PriceDetail priceDetail){
        return paymentService.makePayment(priceDetail);
    }
}
