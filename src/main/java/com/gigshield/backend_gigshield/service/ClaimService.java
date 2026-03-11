package com.gigshield.backend_gigshield.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.model.Claim;
import com.gigshield.backend_gigshield.repository.ClaimRepository;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    // Manual claim creation
    public Claim createClaim(Claim claim){

        claim.setStatus("PENDING");
        claim.setClaimDate(LocalDate.now());

        return claimRepository.save(claim);
    }

    // Get all claims of a worker
    public List<Claim> getWorkerClaims(Long workerId){
        return claimRepository.findByWorkerId(workerId);
    }

    // Automatic claim trigger (parametric insurance)
    public Claim autoTriggerClaim(Long workerId, Long policyId, int disruptionDays, double dailyIncome){

        Claim claim = new Claim();

        claim.setWorkerId(workerId);
        claim.setPolicyId(policyId);
        claim.setReason("Weather Disruption");

        double payoutAmount = dailyIncome * disruptionDays;

        claim.setPayoutAmount(payoutAmount);
        claim.setStatus("AUTO_APPROVED");
        claim.setClaimDate(LocalDate.now());

        return claimRepository.save(claim);
    }
}