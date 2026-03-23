package com.gigshield.backend_gigshield.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.dto.RiskResponse;

@Service
public class RiskService {

    @Autowired
    private WeatherService weatherService;

    public RiskResponse calculateRisk(String city){

        String weather = weatherService.getWeather(city);

        RiskResponse response = new RiskResponse();
        response.setCity(city);

        if(weather.contains("Rain") || weather.contains("Thunderstorm")){

            response.setRiskLevel("RED");
            response.setRecommendedPremium(30);

        } else if(weather.contains("Cloud")){

            response.setRiskLevel("YELLOW");
            response.setRecommendedPremium(22);

        } else {

            response.setRiskLevel("GREEN");
            response.setRecommendedPremium(15);
        }

        return response;
    }
}