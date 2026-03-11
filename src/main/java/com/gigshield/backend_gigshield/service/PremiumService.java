package com.gigshield.backend_gigshield.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.dto.PremiumRequest;
import com.gigshield.backend_gigshield.model.Worker;
import com.gigshield.backend_gigshield.repository.WorkerRepository;

@Service
public class PremiumService {

    @Autowired
    private WorkerRepository workerRepository;

    public double calculatePremium(PremiumRequest request){

        Worker worker = workerRepository
                .findById(request.getWorkerId())
                .orElseThrow(() -> new RuntimeException("Worker not found"));

        double dailyIncome = worker.getDailyIncome();

        double basePrice = dailyIncome * 0.01;  // 1% of daily income

        double weatherRisk = request.getRainRisk() * 2;
        double pollutionRisk = request.getAqiRisk() * 1.5;
        double locationRisk = request.getLocationRisk() * 2;
        double exposureRisk = request.getWorkExposure() * 1.5;

        return basePrice + weatherRisk + pollutionRisk + locationRisk + exposureRisk;
    }
}