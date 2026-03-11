package com.gigshield.backend_gigshield.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.model.Worker;
import com.gigshield.backend_gigshield.repository.WorkerRepository;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public Worker registerWorker(Worker worker) {

        if(workerRepository.existsByPhone(worker.getPhone())){
            throw new RuntimeException("Phone already registered");
        }

        if(workerRepository.existsByEmail(worker.getEmail())){
            throw new RuntimeException("Email already registered");
        }

        if(workerRepository.existsByAadhaar(worker.getAadhaar())){
            throw new RuntimeException("Aadhaar already registered");
        }

        if(workerRepository.existsByPan(worker.getPan())){
            throw new RuntimeException("PAN already registered");
        }

        return workerRepository.save(worker);
    }
}