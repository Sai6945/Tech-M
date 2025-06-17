package com.aits.vehicle_service_management.repository;

import com.aits.vehicle_service_management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}