package com.tomato.controller;

import com.tomato.model.LoginRequest;
import com.tomato.model.LoginResponse;
import com.tomato.model.SignupResponse;
import com.tomato.model.User;
import com.tomato.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public String homeResponse(){
        return "home page";
    }
    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        try{
            LoginResponse loginResponse = userService.authenticate(loginRequest);

            if(loginResponse.isStatus())
            {
                return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            LoginResponse loginResponse = null;
            return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "/signup",consumes ="application/json",produces = "application/json")
    public SignupResponse signup(@RequestBody User user){
        SignupResponse signupResponse = userService.register(user);
        return signupResponse;
    }

}
