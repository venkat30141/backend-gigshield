package com.gigshield.backend_gigshield.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gigshield.backend_gigshield.model.Worker;
import com.gigshield.backend_gigshield.repository.WorkerRepository;

@Component
public class WeatherScheduler {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private DisruptionService disruptionService;

    @Scheduled(fixedRate = 1800000) // every 30 minutes
    public void checkWeatherForWorkers(){

        System.out.println("Checking weather for disruptions...");

        List<Worker> workers = workerRepository.findAll();

        for(Worker worker : workers){

            String city = worker.getLocation();

            try{

                String weather = weatherService.getWeather(city);

                boolean disruption = weatherService.isDisruption(weather);

                if(disruption){

                    System.out.println("Disruption detected for worker: " + worker.getId());

                    disruptionService.checkWeatherAndTrigger(
                            worker.getId(),
                            1L,
                            city
                    );

                }

            }catch(Exception e){
                System.out.println("Weather check failed for " + city);
            }
        }
    }
}