package com.gigshield.backend_gigshield.dto;

public class DisruptionRequest {

    private Long workerId;
    private Long policyId;
    private String disruptionType;
    private int disruptionDays;

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getDisruptionType() {
        return disruptionType;
    }

    public void setDisruptionType(String disruptionType) {
        this.disruptionType = disruptionType;
    }

    public int getDisruptionDays() {
        return disruptionDays;
    }

    public void setDisruptionDays(int disruptionDays) {
        this.disruptionDays = disruptionDays;
    }
}