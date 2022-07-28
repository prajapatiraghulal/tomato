package com.tomato.service;

import com.tomato.model.*;
import com.tomato.repository.CartRepository;
import com.tomato.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ItemRepository itemRepository;
    public AddToCartResponse addToCart(CartRequest cartRequest){

        AddToCartResponse addToCartResponse = new AddToCartResponse();
        Cart userCart = cartRepository.findById(cartRequest.getUserId());
        if(userCart == null){
            addToCartResponse.setStatus(false);
            addToCartResponse.setMessage("User and their cart not found");
            return addToCartResponse;
        }

        if(userCart.getCartItems().size() == 0){
            List<CartItem> localCartItems = new ArrayList<CartItem>();
            CartItem e = new CartItem();
            e.setItemId(cartRequest.getItemId());
            e.setQuantity(1);
            localCartItems.add(e);
            userCart.setCartItems(localCartItems);

        }
        else{
            boolean isPresent = false;
            List<CartItem> cartItems = userCart.getCartItems();
            for(CartItem cartItem : cartItems){
                if(cartItem.getItemId() == cartRequest.getItemId()) {
                    isPresent = true;
                    cartItem.setQuantity(cartItem.getQuantity()+1);
                    break;
                }
            }
            if(isPresent == false){
                CartItem e = new CartItem();
                e.setItemId(cartRequest.getItemId());
                e.setQuantity(1);
                cartItems.add(e);
            }
        }


        Cart newCart = cartRepository.save(userCart);
        if(userCart.getCartItems().size() == 0 || newCart==null){
            addToCartResponse.setStatus(false);
            addToCartResponse.setMessage("Item not added in cart!!! Something went wrong");
        }
        else{
            addToCartResponse.setMessage("Item successfully added!!!");
            addToCartResponse.setStatus(true);
        }
        return addToCartResponse;

    }


    public RemoveFromCartResponse removeFromCart(CartRequest cartRequest){
        RemoveFromCartResponse removeFromCartResponse = new RemoveFromCartResponse();
        Cart userCart = cartRepository.findById(cartRequest.getUserId());

        if(userCart.getCartItems().size() == 0){
            removeFromCartResponse.setStatus(false);
            removeFromCartResponse.setMessage("No items to remove");
            return removeFromCartResponse;
        }

        boolean isPresent = false;
        List<CartItem> cartItems = userCart.getCartItems();
        for(CartItem cartItem : cartItems){
            if(cartItem.getItemId() == cartRequest.getItemId()) {
                isPresent = true;
                cartItem.setQuantity(cartItem.getQuantity()-1);
                if(cartItem.getQuantity() == 0){
                    cartItems.remove(cartItem);
                }
                break;
            }
        }
        if(isPresent == false){
            removeFromCartResponse.setStatus(false);
            removeFromCartResponse.setMessage("Selected item not present in cart");
            return removeFromCartResponse;
        }

        if(userCart.getCartItems().size() == 0){
            userCart.setCartItems(Collections.emptyList());
        }
        Cart newCart = cartRepository.save(userCart);
        if(newCart == null){
            removeFromCartResponse.setStatus(false);
            removeFromCartResponse.setMessage("Item not deleted from cart!!! Something went wrong");
            return removeFromCartResponse;
        }
        removeFromCartResponse.setStatus(true);
        removeFromCartResponse.setMessage("items updated");
        return removeFromCartResponse;
    }

    public CartDetail displayCart(long userId){
        CartDetail cartDetail = new CartDetail();
        Cart cart = cartRepository.findById(userId);
        List<CartItem> cartItems = cart.getCartItems();
        List<BriefItem> briefItemList = new ArrayList<BriefItem>();
        cartDetail.setTotalAmount((float)0.0);
        for(CartItem cartItem : cartItems){
            Item item = itemRepository.findById(cartItem.getItemId());
            BriefItem e = new BriefItem();
            e.setItemId(item.getId());
            e.setItemName(item.getName());
            e.setPrice(item.getPrice());
            e.setQuantity(cartItem.getQuantity());
            e.setImageUrl(item.getImageUrl());
            briefItemList.add(e);

            cartDetail.setTotalAmount(cartDetail.getTotalAmount()+item.getPrice()*cartItem.getQuantity());
        }
        cartDetail.setUserId(userId);
        cartDetail.setBriefItemList(briefItemList);
        return cartDetail;
    }
}
