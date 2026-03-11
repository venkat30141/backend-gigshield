package com.gigshield.backend_gigshield.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gigshield.backend_gigshield.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    boolean existsByPhone(String phone);

    boolean existsByEmail(String email);

    boolean existsByAadhaar(String aadhaar);

    boolean existsByPan(String pan);
}