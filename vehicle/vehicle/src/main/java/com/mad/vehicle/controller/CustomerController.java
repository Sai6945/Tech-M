package com.mad.vehicle.controller;

import com.mad.vehicle.entity.Customer;
import com.mad.vehicle.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired private CustomerService service;

    @GetMapping public List<Customer> getAll() { return service.getAll(); }
    @PostMapping public Customer save(@RequestBody Customer c) { return service.save(c); }
    @GetMapping("/{id}") public ResponseEntity<Customer> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}