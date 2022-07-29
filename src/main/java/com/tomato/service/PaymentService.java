package com.tomato.service;

import com.sun.istack.NotNull;
import com.tomato.model.*;
import com.tomato.repository.CartRepository;
import com.tomato.repository.OrderHistoryRepository;
import com.tomato.repository.OrderRepository;
import com.tomato.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    @Autowired
    private CartService cartService;

    public boolean makePayment(@NotNull PriceDetail priceDetail){
        User user = userRepository.findByUserId(priceDetail.getUserId());
        if(user ==null){
            return false;
        }

        float walletAmount= user.getWalletAmount();
        float billAmount= priceDetail.getTotalPriceAfterGst();
        user.setWalletAmount((long)(walletAmount-billAmount));

        Order order= new Order();
        order.setUserAddress(priceDetail.getUserAddress());
        order.setRestaurantName(priceDetail.getRestaurantName());
        //order.setGstNumber(priceDetail.getGstNumber());       //Todo
        order.setTimestamp(System.currentTimeMillis());

        CartDetail cartDetail = cartService.displayCart(priceDetail.getUserId());
        order.setCartDetail(cartDetail);


        OrderHistory orderHistory = orderHistoryRepository.findById(user.getUserId());
        if(orderHistory == null){
            return false;
        }

        List<Long> orderIdList=  orderHistory.getOrderIdList();
        orderIdList.add(order.getOrderId());

        Order newOrder = orderRepository.save(order);
        if(newOrder!= null){
            OrderHistory newOrderHistory = orderHistoryRepository.save(orderHistory);
            if(newOrderHistory!= null){
                User newUser= userRepository.save(user);
                if(newUser != null){
                    Cart cart= cartRepository.findById(newUser.getUserId());
                    cart.setCartItems(new ArrayList<CartItem>());
                    cartRepository.save(cart);
                    return true;
                }else{
                    orderHistoryRepository.findById(user.getUserId()).getOrderIdList().remove(newOrder.getOrderId());
                    orderRepository.deleteById(newOrder.getOrderId());
                }
            }else{
                orderRepository.deleteById(newOrder.getOrderId());
            }
        }

        return false;

    }
}
