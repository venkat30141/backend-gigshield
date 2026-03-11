package com.gigshield.backend_gigshield.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.dto.DisruptionRequest;
import com.gigshield.backend_gigshield.model.Claim;
import com.gigshield.backend_gigshield.service.DisruptionService;

@RestController
@RequestMapping("/api/disruption")
public class DisruptionController {

    @Autowired
    private DisruptionService disruptionService;

    @PostMapping("/trigger")
    public Claim triggerClaim(@RequestBody DisruptionRequest request){

        return disruptionService.triggerClaim(request);
    }
}