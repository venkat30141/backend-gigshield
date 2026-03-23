package com.gigshield.backend_gigshield.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.dto.FraudResponse;
import com.gigshield.backend_gigshield.model.Claim;
import com.gigshield.backend_gigshield.repository.ClaimRepository;

@Service
public class FraudDetectionService {

    @Autowired
    private ClaimRepository claimRepository;

    public FraudResponse analyzeClaim(Long claimId){

        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        List<Claim> workerClaims =
                claimRepository.findByWorkerId(claim.getWorkerId());

        double score = 0.0;

        // Rule 1: Too many claims
        if(workerClaims.size() > 3){
            score += 0.4;
        }

        // Rule 2: Large payout
        if(claim.getPayoutAmount() > 5000){
            score += 0.3;
        }

        // Rule 3: Multiple claims same day
        long sameDayClaims = workerClaims.stream()
                .filter(c -> c.getClaimDate().equals(claim.getClaimDate()))
                .count();

        if(sameDayClaims > 1){
            score += 0.3;
        }

        String status;

        if(score > 0.7){
            status = "SUSPICIOUS";
        }
        else if(score > 0.4){
            status = "REVIEW";
        }
        else{
            status = "SAFE";
        }

        return new FraudResponse(claimId, score, status);
    }
}