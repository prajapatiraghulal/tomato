package com.tomato.controller;

import com.tomato.model.PriceDetail;
import com.tomato.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PaymentController {

@Autowired
PaymentService paymentService;
    @PostMapping(value = "/payment",consumes ="application/json",produces = "application/json")
    public boolean payment(@RequestBody PriceDetail priceDetail){
        return paymentService.makePayment(priceDetail);
    }
}
