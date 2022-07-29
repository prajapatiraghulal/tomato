package com.tomato.controller;

import com.tomato.model.DeleteRestaurent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminDeleteController {

    @Autowired
    DeleteRestaurent deleteRestaurent;

    @RequestMapping("/admin/delete")
    @ResponseBody
    public String AdminHomePage(){
        return "Admin Home Page";
    }

    //@PostMapping(value = "/delete", consumes="application/json", produces = "application/json")
    //public ResponseEntity<>

}
