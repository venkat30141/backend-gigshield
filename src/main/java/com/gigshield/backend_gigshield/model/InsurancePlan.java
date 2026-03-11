package com.gigshield.backend_gigshield.model;

import jakarta.persistence.*;

@Entity
@Table(name = "insurance_plans")
public class InsurancePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String planName;

    private String coverage;

    private double weeklyPremium;

    public InsurancePlan() {
    }

    public Long getId() {
        return id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public double getWeeklyPremium() {
        return weeklyPremium;
    }

    public void setWeeklyPremium(double weeklyPremium) {
        this.weeklyPremium = weeklyPremium;
    }
}