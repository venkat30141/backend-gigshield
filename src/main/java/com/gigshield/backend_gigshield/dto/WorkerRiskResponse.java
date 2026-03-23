package com.gigshield.backend_gigshield.dto;

public class WorkerRiskResponse {

    private Long workerId;
    private int riskScore;
    private String riskLevel;

    public WorkerRiskResponse(Long workerId, int riskScore, String riskLevel) {
        this.workerId = workerId;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }
}