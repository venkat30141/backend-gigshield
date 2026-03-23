package com.gigshield.backend_gigshield.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.dto.WorkerRiskResponse;
import com.gigshield.backend_gigshield.service.WorkerRiskService;

@RestController
@RequestMapping("/api/worker-risk")
public class WorkerRiskController {

    @Autowired
    private WorkerRiskService workerRiskService;

    @GetMapping("/{workerId}")
    public WorkerRiskResponse getWorkerRisk(@PathVariable Long workerId){
        return workerRiskService.calculateRisk(workerId);
    }
}