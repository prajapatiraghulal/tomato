package com.tomato.service;

import com.tomato.model.Admin;
import com.tomato.model.AdminLoginRequest;
import com.tomato.model.AdminLoginResponse;
import com.tomato.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginService {


        String pepper = "tomato1234";

        @Autowired
        AdminRepository adminRepository;
    private Object Admin;

    public AdminLoginResponse authenticate(AdminLoginRequest adminloginRequest) {
             Admin admin = adminRepository.findByEmail(adminloginRequest.getEmail());
            AdminLoginResponse adminLoginResponse= new AdminLoginResponse();
            if (Admin == null) {
                adminLoginResponse.setStatus(false);
                adminLoginResponse.setMessage("User not found");
            } else {
                String hashedPassword = BCrypt.hashpw(adminloginRequest.getPassword() + pepper, admin.getSalt());
                if (admin.getPassword().equals(hashedPassword)) {
                    adminLoginResponse.setStatus(true);
                    adminLoginResponse.setMessage("Login Successful");
                } else {
                    adminLoginResponse.setStatus(false);
                    adminLoginResponse.setMessage("User not found");
                }
            }
            return adminLoginResponse;
        }
}
