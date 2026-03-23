package com.gigshield.backend_gigshield.dto;

public class AdminDashboardResponse {

    private long totalWorkers;
    private long activePolicies;
    private long totalClaims;
    private long fraudAlerts;
    private long highRiskCities;

    public AdminDashboardResponse(
            long totalWorkers,
            long activePolicies,
            long totalClaims,
            long fraudAlerts,
            long highRiskCities
    ) {
        this.totalWorkers = totalWorkers;
        this.activePolicies = activePolicies;
        this.totalClaims = totalClaims;
        this.fraudAlerts = fraudAlerts;
        this.highRiskCities = highRiskCities;
    }

    public long getTotalWorkers() {
        return totalWorkers;
    }

    public long getActivePolicies() {
        return activePolicies;
    }

    public long getTotalClaims() {
        return totalClaims;
    }

    public long getFraudAlerts() {
        return fraudAlerts;
    }

    public long getHighRiskCities() {
        return highRiskCities;
    }
}