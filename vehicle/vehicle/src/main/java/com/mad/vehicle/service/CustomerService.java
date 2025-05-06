package com.mad.vehicle.service;

import com.mad.vehicle.entity.Customer;
import com.mad.vehicle.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired private CustomerRepository repo;
    public List<Customer> getAll() { return repo.findAll(); }
    public Customer save(Customer c) { return repo.save(c); }
    public Optional<Customer> getById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
    
}