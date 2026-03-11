package com.gigshield.backend_gigshield.dto;

public class PremiumRequest {

    private Long workerId;

    private int rainRisk;
    private int aqiRisk;
    private int locationRisk;
    private int workExposure;

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public int getRainRisk() {
        return rainRisk;
    }

    public void setRainRisk(int rainRisk) {
        this.rainRisk = rainRisk;
    }

    public int getAqiRisk() {
        return aqiRisk;
    }

    public void setAqiRisk(int aqiRisk) {
        this.aqiRisk = aqiRisk;
    }

    public int getLocationRisk() {
        return locationRisk;
    }

    public void setLocationRisk(int locationRisk) {
        this.locationRisk = locationRisk;
    }

    public int getWorkExposure() {
        return workExposure;
    }

    public void setWorkExposure(int workExposure) {
        this.workExposure = workExposure;
    }
}