package com.gigshield.backend_gigshield.dto;

import java.util.List;

import com.gigshield.backend_gigshield.model.Worker;
import com.gigshield.backend_gigshield.model.Policy;
import com.gigshield.backend_gigshield.model.Claim;

public class AdminWorkerView {

    private Worker worker;
    private List<Policy> policies;
    private List<Claim> claims;
    private int riskScore;

    public AdminWorkerView(
            Worker worker,
            List<Policy> policies,
            List<Claim> claims,
            int riskScore
    ){
        this.worker = worker;
        this.policies = policies;
        this.claims = claims;
        this.riskScore = riskScore;
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

    public int getRiskScore() {
        return riskScore;
    }
}