package com.example.api.controller;

import com.example.api.entity.Payment;
import com.example.api.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) {
        try {
        return service.doPayment(payment);
        } catch (Throwable t){
            log.error(t.getMessage(), t);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, t.getMessage(), t);
        }
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId){
              return service.findPaymentHistoryByOrderId(orderId);
    }


}
