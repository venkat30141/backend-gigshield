package com.gigshield.backend_gigshield.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.model.InsurancePlan;
import com.gigshield.backend_gigshield.repository.InsurancePlanRepository;

@Service
public class InsurancePlanService {

    @Autowired
    private InsurancePlanRepository planRepository;

    public List<InsurancePlan> getAllPlans(){
        return planRepository.findAll();
    }

    public InsurancePlan createPlan(InsurancePlan plan){
        return planRepository.save(plan);
    }
}