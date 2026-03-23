package com.gigshield.backend_gigshield.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.model.InsurancePlan;
import com.gigshield.backend_gigshield.repository.InsurancePlanRepository;
import com.gigshield.backend_gigshield.repository.PolicyRepository;

@Service
public class AdminPolicyService {

    @Autowired
    private InsurancePlanRepository planRepository;

    @Autowired
    private PolicyRepository policyRepository;

    public InsurancePlan addPolicy(InsurancePlan plan){
        return planRepository.save(plan);
    }

    public List<InsurancePlan> getAllPolicies(){
        return planRepository.findAll();
    }

    public void deletePolicy(Long planId){

        boolean used = policyRepository.existsByPlanId(planId);

        if(used){
            throw new RuntimeException("Policy already purchased by workers");
        }

        planRepository.deleteById(planId);
    }
}