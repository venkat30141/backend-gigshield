package com.gigshield.backend_gigshield.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.dto.PremiumRequest;
import com.gigshield.backend_gigshield.dto.PremiumResponse;
import com.gigshield.backend_gigshield.service.PremiumService;

@RestController
@RequestMapping("/api/premium")
public class PremiumController {

    @Autowired
    private PremiumService premiumService;

    @PostMapping("/calculate")
    public PremiumResponse calculatePremium(@RequestBody PremiumRequest request){

        double premium = premiumService.calculatePremium(request);

        return new PremiumResponse(premium);
    }
}