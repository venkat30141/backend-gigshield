package com.gigshield.backend_gigshield.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gigshield.backend_gigshield.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByWorkerId(Long workerId);

}