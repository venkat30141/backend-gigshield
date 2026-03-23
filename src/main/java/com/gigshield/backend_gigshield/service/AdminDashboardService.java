package com.gigshield.backend_gigshield.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.dto.AdminDashboardResponse;
import com.gigshield.backend_gigshield.repository.WorkerRepository;
import com.gigshield.backend_gigshield.repository.PolicyRepository;
import com.gigshield.backend_gigshield.repository.ClaimRepository;

@Service
public class AdminDashboardService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private ClaimRepository claimRepository;

    public AdminDashboardResponse getAdminStats(){

        long totalWorkers = workerRepository.count();

        long activePolicies = policyRepository.count();

        long totalClaims = claimRepository.count();

        long fraudAlerts = 0; // placeholder for fraud detection logic

        long highRiskCities = 2; // example value

        return new AdminDashboardResponse(
                totalWorkers,
                activePolicies,
                totalClaims,
                fraudAlerts,
                highRiskCities
        );
    }
}