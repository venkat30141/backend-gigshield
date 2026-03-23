package com.gigshield.backend_gigshield.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.dto.AdminWorkerView;
import com.gigshield.backend_gigshield.service.AdminWorkerService;

@RestController
@RequestMapping("/api/admin/workers")
public class AdminWorkerController {

    @Autowired
    private AdminWorkerService adminWorkerService;

    @GetMapping
    public List<AdminWorkerView> getWorkers(){
        return adminWorkerService.getAllWorkers();
    }
}