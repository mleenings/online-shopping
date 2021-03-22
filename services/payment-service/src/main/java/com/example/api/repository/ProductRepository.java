package com.example.api.repository;

import com.example.api.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Payment,Integer> {
    Payment findByOrderId(int orderId);
}

