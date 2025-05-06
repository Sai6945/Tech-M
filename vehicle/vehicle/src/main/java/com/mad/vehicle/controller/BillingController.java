package com.mad.vehicle.controller;

import com.mad.vehicle.entity.Billing;
import com.mad.vehicle.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billings")
public class BillingController {
    @Autowired private BillingService service;

    @GetMapping public List<Billing> getAll() { return service.getAll(); }
    @PostMapping public Billing save(@RequestBody Billing b) { return service.save(b); }
    @GetMapping("/{id}") public ResponseEntity<Billing> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}
