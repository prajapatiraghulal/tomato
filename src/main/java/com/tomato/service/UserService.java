package com.tomato.service;

import com.tomato.model.*;
import com.tomato.repository.LoginRepository;
import com.tomato.repository.CartRepository;
import com.tomato.repository.OrderHistoryRepository;
import com.tomato.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    String pepper = "tomato1234";
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderHistoryRepository orderHistoryRepository;
    @Autowired
    LoginRepository loginRepository;

    public LoginResponse authenticate(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail());
        LoginResponse loginResponse = new LoginResponse();

        LoginActivity loginActivity = loginRepository.findByUserId(user.getUserId());
        if(user == null)

        {
            loginResponse.setStatus(false);
            loginResponse.setMessage("User not found");
        }
        else
        {
            String hashedPassword = BCrypt.hashpw(loginRequest.getPassword()+pepper,user.getSalt());
            if(user.getPassword().equals(hashedPassword))
            {
                loginResponse.setStatus(true);
                loginResponse.setMessage("Login Successful");
                LoginActivity loginActivity1 = loginRepository.findByUserId(user.getUserId());
                loginResponse.setLoginToken(loginActivity1.getLoginToken());

                loginResponse.setUserId(user.getUserId());
                loginResponse.setUserType((int)user.getUserType());

            }
            else
            {
                loginResponse.setStatus(false);
                loginResponse.setMessage("Incorrect password");
            }
        }
        return loginResponse;
    }
  
    public void loginEntry(LoginRequest loginRequest){
        LoginActivity loginActivity = new LoginActivity();
        //String randomString = BCrypt.hashpw(loginRequest.getEmail(),"abcd");
        loginActivity.setLoginToken(loginRequest.getEmail());
        User currentUser = userRepository.findByEmail(loginRequest.getEmail());
        if(currentUser!=null)
        {
            loginActivity.setUserId(currentUser.getUserId());
        }
        loginRepository.save(loginActivity);
    }

    public void deleteEntry(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail());
        loginRepository.deleteByUserId(user.getUserId());
    }
    public void deleteToken(TokenRequest tokenRequest){
        LoginActivity loginActivity = new LoginActivity();
        loginActivity = loginRepository.findByLoginToken(loginActivity.getLoginToken());
        loginRepository.deleteById(loginActivity.getTokenId());
    }
  
    public SignupResponse register(User user){
        SignupResponse signupResponse = new SignupResponse();
        try  {
            if (user.getUserType() == 2) {
                signupResponse.setStatus(false);
                signupResponse.setMessage("Cannot register as Admin");
            }

            User currentUser = userRepository.findByEmail(user.getEmail());
            if (currentUser != null) {
                signupResponse.setStatus(false);
                signupResponse.setMessage("User already exists");
                return signupResponse;
            } else{
                String salt = BCrypt.gensalt();
                String hashedPassword = BCrypt.hashpw(user.getPassword()+pepper,salt);
                user.setPassword(hashedPassword);
                user.setSalt(salt);
                user.setWalletAmount((long)(1000* Math.random()));
                Cart cart = new Cart();

                User newUser = userRepository.save(user);
                if(newUser != null){
                    cart.setId(newUser.getUserId());
                    cart.setCartItems(Collections.emptyList());
                    Cart newCart = cartRepository.save(cart);
                    OrderHistory orderHistory = new OrderHistory();
                    orderHistory.setUserId(newUser.getUserId());
                    orderHistory.setOrderIdList(new ArrayList<>());
                    OrderHistory newOrderHistory = orderHistoryRepository.save(orderHistory);
                    if(newOrderHistory==null){
                        cartRepository.delete(newCart);
                        userRepository.delete(newUser);
                        signupResponse.setMessage("Signup failed");
                        signupResponse.setStatus(false);
                        return signupResponse;
                    }
                    if(newCart!=null){
                        signupResponse.setMessage("Signup successful");
                        signupResponse.setStatus(true);
                        signupResponse.setUserId(user.getUserId());
                        signupResponse.setUserType(user.getUserType());
                        return signupResponse;
                    }
                    else{
                        userRepository.delete(newUser);
                        signupResponse.setMessage("Signup unsuccessful!!! Cart Not Created");
                        signupResponse.setStatus(false);
                        return signupResponse;
                    }
                }
                else{
                    signupResponse.setMessage("Signup unsuccessful!!! User Not Saved in DB");
                    signupResponse.setStatus(false);
                    signupResponse.setUserId(user.getUserId());
                    signupResponse.setUserType(user.getUserType());
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setEmail(user.getEmail());
                    loginRequest.setPassword(user.getPassword());
                    loginEntry(loginRequest);
                    LoginActivity loginActivity = loginRepository.findByUserId(user.getUserId());
                    signupResponse.setLoginToken(loginActivity.getLoginToken());
                    return signupResponse;
                }
            }
        }
        catch(Exception e){
            signupResponse.setMessage("something went wrong or invalid call");
            signupResponse.setStatus(false);
            return signupResponse;
        }

    }
}
