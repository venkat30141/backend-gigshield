package com.gigshield.backend_gigshield;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackendGigshieldApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendGigshieldApplication.class, args);
    }

}