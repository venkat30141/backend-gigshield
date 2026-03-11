package com.gigshield.backend_gigshield.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "workers",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "phone"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "aadhaar"),
        @UniqueConstraint(columnNames = "pan"),
        @UniqueConstraint(columnNames = "bankAccount")
})
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid phone number")
    private String phone;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Worker ID is required")
    private String workerId;

    @NotBlank(message = "Aadhaar is required")
    @Pattern(regexp = "\\d{12}", message = "Aadhaar must be 12 digits")
    private String aadhaar;

    @NotBlank(message = "PAN is required")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN format")
    private String pan;

    @NotBlank(message = "Bank account is required")
    private String bankAccount;

    @NotBlank(message = "IFSC is required")
    private String ifsc;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Delivery zone 1 is required")
    private String deliveryZone1;

    @NotBlank(message = "Delivery zone 2 is required")
    private String deliveryZone2;

    @NotNull(message = "Daily income is required")
    private Double dailyIncome;

    public Worker() {
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeliveryZone1() {
        return deliveryZone1;
    }

    public void setDeliveryZone1(String deliveryZone1) {
        this.deliveryZone1 = deliveryZone1;
    }

    public String getDeliveryZone2() {
        return deliveryZone2;
    }

    public void setDeliveryZone2(String deliveryZone2) {
        this.deliveryZone2 = deliveryZone2;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }
}