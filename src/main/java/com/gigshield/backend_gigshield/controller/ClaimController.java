package com.gigshield.backend_gigshield.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.model.Claim;
import com.gigshield.backend_gigshield.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping
    public Claim createClaim(@RequestBody Claim claim){
        return claimService.createClaim(claim);
    }

    @GetMapping("/worker/{workerId}")
    public List<Claim> getWorkerClaims(@PathVariable Long workerId){
        return claimService.getWorkerClaims(workerId);
    }

}