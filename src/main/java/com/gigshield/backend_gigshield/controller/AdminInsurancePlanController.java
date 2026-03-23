package com.gigshield.backend_gigshield.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.model.InsurancePlan;
import com.gigshield.backend_gigshield.service.AdminInsurancePlanService;

@RestController
@RequestMapping("/api/admin/plans")
public class AdminInsurancePlanController {

    @Autowired
    private AdminInsurancePlanService adminService;

    @PostMapping
    public InsurancePlan addPlan(@RequestBody InsurancePlan plan){
        return adminService.addPlan(plan);
    }

    @GetMapping
    public List<InsurancePlan> getPlans(){
        return adminService.getAllPlans();
    }

    @DeleteMapping("/{planId}")
    public String deletePlan(@PathVariable Long planId){

        adminService.deletePlan(planId);

        return "Insurance plan deleted successfully";
    }
}