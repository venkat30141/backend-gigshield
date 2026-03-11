package com.gigshield.backend_gigshield.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gigshield.backend_gigshield.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    List<Policy> findByWorkerId(Long workerId);

}