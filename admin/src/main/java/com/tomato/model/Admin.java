package com.tomato.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "Admin")
public class Admin {

    private long AdminId;


    private String name;


    private String phoneNumber;


    private String email;


    private String password;

    private String salt;

    public Admin(long adminId, String name, String phoneNumber, String email, String password, String salt) {
        AdminId = adminId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    public long getAdminId() {
        return AdminId;
    }

    public void setAdminId(long adminId) {
        AdminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
