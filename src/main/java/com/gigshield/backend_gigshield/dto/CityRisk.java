package com.gigshield.backend_gigshield.dto;

public class CityRisk {

    private String city;
    private String risk;

    public CityRisk(String city, String risk) {
        this.city = city;
        this.risk = risk;
    }

    public String getCity() {
        return city;
    }

    public String getRisk() {
        return risk;
    }
}