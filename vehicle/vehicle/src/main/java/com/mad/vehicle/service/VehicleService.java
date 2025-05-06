package com.mad.vehicle.service;

import com.mad.vehicle.entity.Vehicle;
import com.mad.vehicle.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired private VehicleRepository repo;
    public List<Vehicle> getAll() { return repo.findAll(); }
    public Vehicle save(Vehicle v) { return repo.save(v); }
    public Optional<Vehicle> getById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}