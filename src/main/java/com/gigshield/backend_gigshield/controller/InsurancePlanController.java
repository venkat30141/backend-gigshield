package com.gigshield.backend_gigshield.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.model.InsurancePlan;
import com.gigshield.backend_gigshield.service.InsurancePlanService;

@RestController
@RequestMapping("/api/plans")
public class InsurancePlanController {

    @Autowired
    private InsurancePlanService planService;

    @GetMapping
    public List<InsurancePlan> getAllPlans(){
        return planService.getAllPlans();
    }

    @PostMapping
    public InsurancePlan createPlan(@RequestBody InsurancePlan plan){
        return planService.createPlan(plan);
    }
}