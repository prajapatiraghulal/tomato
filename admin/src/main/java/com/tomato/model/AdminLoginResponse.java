package com.tomato.model;

public class AdminLoginResponse {

    private static boolean status;
    private String message;

    public static boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
