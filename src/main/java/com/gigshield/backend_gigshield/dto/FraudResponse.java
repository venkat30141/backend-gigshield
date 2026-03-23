package com.gigshield.backend_gigshield.dto;

public class FraudResponse {

    private Long claimId;
    private double fraudScore;
    private String status;

    public FraudResponse(Long claimId, double fraudScore, String status) {
        this.claimId = claimId;
        this.fraudScore = fraudScore;
        this.status = status;
    }

    public Long getClaimId() {
        return claimId;
    }

    public double getFraudScore() {
        return fraudScore;
    }

    public String getStatus() {
        return status;
    }
}