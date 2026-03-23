package com.gigshield.backend_gigshield.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.dto.CityRisk;
import com.gigshield.backend_gigshield.service.RiskMapService;

@RestController
@RequestMapping("/api/risk-map")
public class RiskMapController {

    @Autowired
    private RiskMapService riskMapService;

    @GetMapping
    public List<CityRisk> getRiskMap(){
        return riskMapService.getCityRisks();
    }
}