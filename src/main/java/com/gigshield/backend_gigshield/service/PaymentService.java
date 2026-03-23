package com.gigshield.backend_gigshield.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigshield.backend_gigshield.model.Payment;
import com.gigshield.backend_gigshield.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment payPremium(Payment payment){

        payment.setStatus("SUCCESS");
        payment.setPaymentDate(LocalDate.now());

        return paymentRepository.save(payment);
    }

    public List<Payment> getWorkerPayments(Long workerId){
        return paymentRepository.findByWorkerId(workerId);
    }
}