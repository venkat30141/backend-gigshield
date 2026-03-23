package com.gigshield.backend_gigshield.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.model.Worker;
import com.gigshield.backend_gigshield.service.WorkerService;
import com.gigshield.backend_gigshield.dto.LoginRequest;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    // Worker Registration
    @PostMapping("/register")
    public Worker registerWorker(@Valid @RequestBody Worker worker){
        return workerService.registerWorker(worker);
    }

    // Worker Login
    @PostMapping("/login")
    public Worker login(@RequestBody LoginRequest request){

        return workerService.login(
                request.getPhone(),
                request.getAadhaar()
        );
    }
}