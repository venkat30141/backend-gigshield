package com.gigshield.backend_gigshield.dto;

public class RiskResponse {

    private String city;
    private String riskLevel;
    private int recommendedPremium;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public int getRecommendedPremium() {
        return recommendedPremium;
    }

    public void setRecommendedPremium(int recommendedPremium) {
        this.recommendedPremium = recommendedPremium;
    }
}