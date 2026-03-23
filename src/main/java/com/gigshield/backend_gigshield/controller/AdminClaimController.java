package com.gigshield.backend_gigshield.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.model.Claim;
import com.gigshield.backend_gigshield.service.AdminClaimService;

@RestController
@RequestMapping("/api/admin/claims")
public class AdminClaimController {

    @Autowired
    private AdminClaimService adminClaimService;

    @GetMapping
    public List<Claim> getAllClaims(){
        return adminClaimService.getAllClaims();
    }

    @PutMapping("/{id}/approve")
    public Claim approveClaim(@PathVariable Long id){
        return adminClaimService.approveClaim(id);
    }

    @PutMapping("/{id}/reject")
    public Claim rejectClaim(@PathVariable Long id){
        return adminClaimService.rejectClaim(id);
    }
}