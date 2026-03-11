package com.gigshield.backend_gigshield.dto;

public class PremiumResponse {

    private double weeklyPremium;

    public PremiumResponse(double weeklyPremium){
        this.weeklyPremium = weeklyPremium;
    }

    public double getWeeklyPremium() {
        return weeklyPremium;
    }

    public void setWeeklyPremium(double weeklyPremium) {
        this.weeklyPremium = weeklyPremium;
    }
}