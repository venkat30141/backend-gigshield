package com.gigshield.backend_gigshield.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.model.InsurancePlan;
import com.gigshield.backend_gigshield.service.AdminPolicyService;

@RestController
@RequestMapping("/api/admin/policies")
public class AdminPolicyController {

    @Autowired
    private AdminPolicyService adminPolicyService;

    @PostMapping
    public InsurancePlan addPolicy(@RequestBody InsurancePlan plan){
        return adminPolicyService.addPolicy(plan);
    }

    @GetMapping
    public List<InsurancePlan> getPolicies(){
        return adminPolicyService.getAllPolicies();
    }

    @DeleteMapping("/{planId}")
    public String deletePolicy(@PathVariable Long planId){

        adminPolicyService.deletePolicy(planId);

        return "Policy deleted successfully";
    }
}