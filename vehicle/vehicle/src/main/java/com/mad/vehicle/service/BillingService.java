package com.mad.vehicle.service;

import com.mad.vehicle.entity.Billing;
import com.mad.vehicle.repo.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService {
    @Autowired private BillingRepository repo;
    public List<Billing> getAll() { return repo.findAll(); }
    public Billing save(Billing b) { return repo.save(b); }
    public Optional<Billing> getById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
