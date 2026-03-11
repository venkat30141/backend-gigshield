package com.gigshield.backend_gigshield.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.dto.DashboardResponse;
import com.gigshield.backend_gigshield.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/{workerId}")
    public DashboardResponse getDashboard(@PathVariable Long workerId){
        return dashboardService.getDashboard(workerId);
    }
}