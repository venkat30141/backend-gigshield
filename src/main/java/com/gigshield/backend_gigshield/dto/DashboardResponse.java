package com.gigshield.backend_gigshield.dto;

import java.util.List;

import com.gigshield.backend_gigshield.model.Worker;
import com.gigshield.backend_gigshield.model.Policy;
import com.gigshield.backend_gigshield.model.Claim;
import com.gigshield.backend_gigshield.model.InsurancePlan;

public class DashboardResponse {

    private Worker worker;
    private List<Policy> policies;
    private List<Claim> claims;
    private List<InsurancePlan> plans;

    public DashboardResponse(
            Worker worker,
            List<Policy> policies,
            List<Claim> claims,
            List<InsurancePlan> plans
    ) {
        this.worker = worker;
        this.policies = policies;
        this.claims = claims;
        this.plans = plans;
    }

    public Worker getWorker() {
        return worker;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public List<InsurancePlan> getPlans() {
        return plans;
    }
}