package com.gigshield.backend_gigshield.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.dto.AdminWorkerView;
import com.gigshield.backend_gigshield.model.Worker;
import com.gigshield.backend_gigshield.model.Policy;
import com.gigshield.backend_gigshield.model.Claim;
import com.gigshield.backend_gigshield.repository.WorkerRepository;
import com.gigshield.backend_gigshield.repository.PolicyRepository;
import com.gigshield.backend_gigshield.repository.ClaimRepository;

@Service
public class AdminWorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private ClaimRepository claimRepository;

    public List<AdminWorkerView> getAllWorkers(){

        List<Worker> workers = workerRepository.findAll();

        List<AdminWorkerView> result = new ArrayList<>();

        for(Worker worker : workers){

            List<Policy> policies =
                    policyRepository.findByWorkerId(worker.getId());

            List<Claim> claims =
                    claimRepository.findByWorkerId(worker.getId());

            int riskScore = claims.size() * 10;

            AdminWorkerView view =
                    new AdminWorkerView(worker, policies, claims, riskScore);

            result.add(view);
        }

        return result;
    }
}