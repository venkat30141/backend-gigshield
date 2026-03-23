package com.gigshield.backend_gigshield.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gigshield.backend_gigshield.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    // Duplicate validations
    boolean existsByPhone(String phone);

    boolean existsByEmail(String email);

    boolean existsByAadhaar(String aadhaar);

    boolean existsByPan(String pan);

    // Login support
    Optional<Worker> findByPhone(String phone);

    Optional<Worker> findByPhoneAndAadhaar(String phone, String aadhaar);

}