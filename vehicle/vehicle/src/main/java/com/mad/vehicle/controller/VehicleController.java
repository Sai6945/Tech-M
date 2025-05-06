package com.mad.vehicle.controller;

import com.mad.vehicle.entity.Vehicle;
import com.mad.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired private VehicleService service;

    @GetMapping public List<Vehicle> getAll() { return service.getAll(); }
    @PostMapping public Vehicle save(@RequestBody Vehicle v) { return service.save(v); }
    @GetMapping("/{id}") public ResponseEntity<Vehicle> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}