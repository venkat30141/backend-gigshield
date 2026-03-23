package com.gigshield.backend_gigshield.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.dto.RiskResponse;
import com.gigshield.backend_gigshield.service.RiskService;

@RestController
@RequestMapping("/api/risk")
public class RiskController {

    @Autowired
    private RiskService riskService;

    @GetMapping("/{city}")
    public RiskResponse getRisk(@PathVariable String city){
        return riskService.calculateRisk(city);
    }
}