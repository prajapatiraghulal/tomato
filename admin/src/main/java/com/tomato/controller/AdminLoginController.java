package com.tomato.controller;

import com.tomato.model.AdminLoginRequest;
import com.tomato.model.AdminLoginResponse;
import com.tomato.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminLoginController {

    @Autowired
    AdminLoginService adminLoginService;

    @RequestMapping("/")
    @ResponseBody
    public String AdminhomeResponse(){
        return "Admin home page";
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AdminLoginResponse>login(@RequestBody AdminLoginRequest adminLoginRequest){
        try{
            AdminLoginResponse adminLoginResponse = adminLoginService.authenticate(adminLoginRequest);

            if(AdminLoginResponse.isStatus())
            {
                return new ResponseEntity<AdminLoginResponse>(adminLoginResponse, HttpStatus.OK);

            }
            else{
                return new ResponseEntity<AdminLoginResponse>(adminLoginResponse, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            AdminLoginResponse adminLoginResponse = null;
            return new ResponseEntity<AdminLoginResponse>(adminLoginResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
