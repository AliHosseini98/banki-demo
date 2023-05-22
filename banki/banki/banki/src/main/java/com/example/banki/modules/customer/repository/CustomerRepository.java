package com.example.banki.modules.customer.repository;

import com.example.banki.modules.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
