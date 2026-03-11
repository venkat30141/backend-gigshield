package com.gigshield.backend_gigshield.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.model.Policy;
import com.gigshield.backend_gigshield.service.PolicyService;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping("/buy")
    public Policy buyPolicy(
            @RequestParam Long workerId,
            @RequestParam Long planId
    ){
        return policyService.buyPolicy(workerId, planId);
    }

    @GetMapping("/worker/{workerId}")
    public List<Policy> getWorkerPolicies(@PathVariable Long workerId){
        return policyService.getWorkerPolicies(workerId);
    }

}