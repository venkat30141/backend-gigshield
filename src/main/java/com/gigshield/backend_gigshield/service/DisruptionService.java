package com.gigshield.backend_gigshield.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.dto.DisruptionRequest;
import com.gigshield.backend_gigshield.model.Worker;
import com.gigshield.backend_gigshield.model.Claim;
import com.gigshield.backend_gigshield.repository.WorkerRepository;

@Service
public class DisruptionService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private ClaimService claimService;

    public Claim triggerClaim(DisruptionRequest request){

        Worker worker = workerRepository.findById(request.getWorkerId())
                .orElseThrow(() -> new RuntimeException("Worker not found"));

        double dailyIncome = worker.getDailyIncome();

        return claimService.autoTriggerClaim(
                request.getWorkerId(),
                request.getPolicyId(),
                request.getDisruptionDays(),
                dailyIncome
        );
    }
}