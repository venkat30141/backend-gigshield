package com.gigshield.backend_gigshield.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.model.Policy;
import com.gigshield.backend_gigshield.repository.PolicyRepository;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public Policy buyPolicy(Long workerId, Long planId) {

        Policy policy = new Policy();

        policy.setWorkerId(workerId);
        policy.setPlanId(planId);
        policy.setStartDate(LocalDate.now());
        policy.setStatus("ACTIVE");

        return policyRepository.save(policy);
    }

    public List<Policy> getWorkerPolicies(Long workerId){
        return policyRepository.findByWorkerId(workerId);
    }

}