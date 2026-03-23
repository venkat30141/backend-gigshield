package com.gigshield.backend_gigshield.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.dto.FraudResponse;
import com.gigshield.backend_gigshield.service.FraudDetectionService;

@RestController
@RequestMapping("/api/fraud")
public class FraudController {

    @Autowired
    private FraudDetectionService fraudService;

    @GetMapping("/{claimId}")
    public FraudResponse checkFraud(@PathVariable Long claimId){
        return fraudService.analyzeClaim(claimId);
    }
}