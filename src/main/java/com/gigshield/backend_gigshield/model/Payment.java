package com.gigshield.backend_gigshield.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long workerId;

    private Long policyId;

    private double amount;

    private String method;

    private String status;

    private LocalDate paymentDate;

    public Payment() {}

    public Payment(Long workerId, Long policyId, double amount, String method, String status, LocalDate paymentDate) {
        this.workerId = workerId;
        this.policyId = policyId;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}