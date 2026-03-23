package com.gigshield.backend_gigshield.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.model.Claim;
import com.gigshield.backend_gigshield.repository.ClaimRepository;

@Service
public class AdminClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    public List<Claim> getAllClaims(){
        return claimRepository.findAll();
    }

    public Claim approveClaim(Long claimId){

        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        claim.setStatus("APPROVED");

        return claimRepository.save(claim);
    }

    public Claim rejectClaim(Long claimId){

        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        claim.setStatus("REJECTED");

        return claimRepository.save(claim);
    }
}