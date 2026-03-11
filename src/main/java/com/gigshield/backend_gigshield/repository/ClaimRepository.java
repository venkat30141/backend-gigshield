package com.gigshield.backend_gigshield.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gigshield.backend_gigshield.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

    List<Claim> findByWorkerId(Long workerId);

}