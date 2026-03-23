package com.gigshield.backend_gigshield.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.dto.CityRisk;

@Service
public class RiskMapService {

    @Autowired
    private WeatherService weatherService;

    public List<CityRisk> getCityRisks(){

        List<String> cities = List.of(
                "Guntur",
                "Vijayawada",
                "Chennai",
                "Hyderabad",
                "Mumbai"
        );

        List<CityRisk> risks = new ArrayList<>();

        for(String city : cities){

            String weather = weatherService.getWeather(city);

            String risk;

            if(weather.contains("Rain") || weather.contains("Thunderstorm")){
                risk = "RED";
            }
            else if(weather.contains("Cloud")){
                risk = "YELLOW";
            }
            else{
                risk = "GREEN";
            }

            risks.add(new CityRisk(city, risk));
        }

        return risks;
    }
}