package com.gigshield.backend_gigshield.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.dto.DashboardResponse;
import com.gigshield.backend_gigshield.model.Worker;
import com.gigshield.backend_gigshield.model.Policy;
import com.gigshield.backend_gigshield.model.Claim;
import com.gigshield.backend_gigshield.model.InsurancePlan;
import com.gigshield.backend_gigshield.repository.WorkerRepository;
import com.gigshield.backend_gigshield.repository.PolicyRepository;
import com.gigshield.backend_gigshield.repository.ClaimRepository;
import com.gigshield.backend_gigshield.repository.InsurancePlanRepository;

@Service
public class DashboardService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private InsurancePlanRepository planRepository;

    public DashboardResponse getDashboard(Long workerId){

    Worker worker = workerRepository.findById(workerId)
            .orElseThrow(() -> new RuntimeException("Worker not found"));

    List<Policy> policies = policyRepository.findByWorkerId(workerId);

    List<Claim> claims = claimRepository.findByWorkerId(workerId);

    List<InsurancePlan> plans = planRepository.findAll();

    // Risk score logic
    int riskScore = claims.size() * 10;

    if(riskScore > 100){
        riskScore = 100;
    }

    // Weekly premium calculation
    double weeklyPremium = worker.getDailyIncome() * 0.02;

    // Weather risk logic
    String weatherRisk;

    if(worker.getLocation().equalsIgnoreCase("Mumbai")){
        weatherRisk = "HIGH";
    }
    else if(worker.getLocation().equalsIgnoreCase("Chennai")){
        weatherRisk = "MEDIUM";
    }
    else{
        weatherRisk = "LOW";
    }

    return new DashboardResponse(
            worker,
            riskScore,
            weeklyPremium,
            weatherRisk,
            policies,
            claims,
            plans
    );
}
}