package com.gigshield.backend_gigshield.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.dto.AdminDashboardResponse;
import com.gigshield.backend_gigshield.service.AdminDashboardService;

@RestController
@RequestMapping("/api/admin")
public class AdminDashboardController {

    @Autowired
    private AdminDashboardService adminService;

    @GetMapping("/dashboard")
    public AdminDashboardResponse getAdminDashboard(){
        return adminService.getAdminStats();
    }
}