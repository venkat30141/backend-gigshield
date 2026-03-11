package com.gigshield.backend_gigshield.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.model.Worker;
import com.gigshield.backend_gigshield.service.WorkerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @PostMapping("/register")
    public Worker registerWorker(@Valid @RequestBody Worker worker){
        return workerService.registerWorker(worker);
    }
}