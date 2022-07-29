package com.tomato.model;

import com.tomato.repository.AdminRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
public class AdminDemo {
    public static void main(String[] args) {
        SpringApplication.run(AdminDemo.class);
    }

    private void insertFourEmployees(AdminRepository adminRepository) {
        adminRepository.save(new Admin(101,"chandu","9959989637","rc.1104.3742@gmail.com","rc@1104","salt"));

    }
}