package com.gigshield.backend_gigshield.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.dto.DisruptionRequest;
import com.gigshield.backend_gigshield.model.Claim;
import com.gigshield.backend_gigshield.model.Worker;
import com.gigshield.backend_gigshield.repository.WorkerRepository;

@Service
public class DisruptionService {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private ClaimService claimService;

    // Manual claim trigger (API)
    public Claim triggerClaim(DisruptionRequest request){

        String weatherData = weatherService.getWeather(request.getCity());

        boolean disruption = weatherService.isDisruption(weatherData);

        if(!disruption){
            throw new RuntimeException("No disruption detected");
        }

        Worker worker = workerRepository.findById(request.getWorkerId())
                .orElseThrow(() -> new RuntimeException("Worker not found"));

        double dailyIncome = worker.getDailyIncome();

        return claimService.autoTriggerClaim(
                request.getWorkerId(),
                request.getPolicyId(),
                1,
                dailyIncome
        );
    }

    // Automatic trigger used by WeatherScheduler
    public void checkWeatherAndTrigger(Long workerId, Long policyId, String city){

        String weatherData = weatherService.getWeather(city);

        boolean disruption = weatherService.isDisruption(weatherData);

        if(!disruption){
            return;
        }

        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new RuntimeException("Worker not found"));

        double dailyIncome = worker.getDailyIncome();

        claimService.autoTriggerClaim(
                workerId,
                policyId,
                1,
                dailyIncome
        );
    }
}