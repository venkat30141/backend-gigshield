package com.gigshield.backend_gigshield.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.dto.WorkerRiskResponse;
import com.gigshield.backend_gigshield.model.Claim;
import com.gigshield.backend_gigshield.model.Worker;
import com.gigshield.backend_gigshield.repository.ClaimRepository;
import com.gigshield.backend_gigshield.repository.WorkerRepository;

@Service
public class WorkerRiskService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private ClaimRepository claimRepository;

    public WorkerRiskResponse calculateRisk(Long workerId){

        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new RuntimeException("Worker not found"));

        List<Claim> claims = claimRepository.findByWorkerId(workerId);

        int score = 0;

        // Rule 1: Claim history
        score += claims.size() * 10;

        // Rule 2: Daily income exposure
        if(worker.getDailyIncome() > 2000){
            score += 20;
        }

        // Rule 3: High delivery zones
        if(worker.getDeliveryZone1() != null){
            score += 10;
        }

        if(score > 100){
            score = 100;
        }

        String level;

        if(score > 70){
            level = "HIGH";
        }
        else if(score > 40){
            level = "MEDIUM";
        }
        else{
            level = "LOW";
        }

        return new WorkerRiskResponse(workerId, score, level);
    }
}