package com.tomato.controller;

import com.tomato.model.*;
import com.tomato.repository.ItemRepository;
import com.tomato.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    ItemRepository itemRepository;
    @PostMapping(value = "/addtocart", produces = "application/json", consumes = "application/json")
    public AddToCartResponse addToCart(@RequestBody CartRequest cartRequest){
        AddToCartResponse addToCartResponse = cartService.addToCart(cartRequest);
        return addToCartResponse;
    }

    @PostMapping(value = "/removefromcart", produces = "application/json", consumes = "application/json")
    public RemoveFromCartResponse removeFromCart(@RequestBody CartRequest cartRequest){
        RemoveFromCartResponse removeFromCartResponse = cartService.removeFromCart(cartRequest);
        return removeFromCartResponse;
    }
    @GetMapping(value = "/showcart",produces = "application/json")
    public CartDetail showCart(@RequestParam long userId){
        CartDetail cartDetail = cartService.displayCart(userId);
        return cartDetail;
    }

    @PostMapping(value = "/additem", produces = "application/json", consumes = "application/json")
    public boolean removeFromCart(@RequestBody Item item){
        if(itemRepository.save(item)!=null){
            return true;
        }
        return false;
    }
}
