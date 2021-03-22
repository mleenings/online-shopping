package com.example.api.controller;

import com.example.api.service.OrderService;
import com.example.api.common.TransactionRequest;
import com.example.api.common.TransactionResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService service;
    
    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        try{
            return service.saveOrder(request);
        } catch (Throwable t){
            log.error(t.getMessage(), t);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, t.getMessage(), t);
        }
    }
}
