package com.gigshield.backend_gigshield.dto;

public class LoginRequest {

    private String phone;
    private String aadhaar;

    public String getPhone() {
        return phone;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }
}