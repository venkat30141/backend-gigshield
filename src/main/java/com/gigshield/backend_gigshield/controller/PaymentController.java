package com.gigshield.backend_gigshield.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gigshield.backend_gigshield.model.Payment;
import com.gigshield.backend_gigshield.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/pay")
    public Payment payPremium(@RequestBody Payment payment){
        return paymentService.payPremium(payment);
    }

    @GetMapping("/worker/{workerId}")
    public List<Payment> getWorkerPayments(@PathVariable Long workerId){
        return paymentService.getWorkerPayments(workerId);
    }
}