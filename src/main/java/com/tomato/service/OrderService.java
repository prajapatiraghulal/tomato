package com.tomato.service;


import com.tomato.model.*;
import com.tomato.repository.CartRepository;
import com.tomato.repository.ItemRepository;
import com.tomato.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public PriceDetail getPriceDetail(OrderInput orderInput){
        PriceDetail priceDetail=new PriceDetail();
        Cart myCart=cartRepository.findById(orderInput.getUserId());
        List<CartItem> cartItems=myCart.getCartItems();
        float totalPrice = (float)0.0;
        for(int i = 0; i < cartItems.size(); i++){
            Item item=itemRepository.findById(cartItems.get(i).getItemId());
            totalPrice+=item.getPrice();
        }
        Item item=itemRepository.findById(cartItems.get(0).getItemId());
        long restaurantId=item.getRestaurantId();
        Restaurant restaurant=restaurantRepository.findById(restaurantId);

        float gst=(float)6.0;
        float deliveryCharge=(float)40.0;
        float totalPriceAfterGst=totalPrice*(1+gst/100)+deliveryCharge;
        priceDetail.setUserId(orderInput.getUserId());
        priceDetail.setTotalPrice(totalPrice);
        priceDetail.setGst(gst);
        priceDetail.setDeliveryCharge(deliveryCharge);
        priceDetail.setOffer(Long.parseLong(restaurant.getOffer()));
        priceDetail.setRestaurantName(restaurant.getName());
        priceDetail.setTotalPriceAfterGst(totalPriceAfterGst);
        priceDetail.setUserAddress(orderInput.getAddress());
        return priceDetail;
    }

}
