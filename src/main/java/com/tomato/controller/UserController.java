package com.tomato.controller;

import com.tomato.model.*;
import com.tomato.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public String homeResponse(Model model, HttpSession session){
        return "home page";
    }
    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        try{
            LoginResponse loginResponse = userService.authenticate(loginRequest);
            if(loginResponse.isStatus())
            {
                userService.loginEntry(loginRequest);
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
    @PostMapping("/logout")
    public String logout(@RequestBody TokenRequest tokenRequest) {
        userService.deleteToken(tokenRequest);
        return "home page";
    }
}
