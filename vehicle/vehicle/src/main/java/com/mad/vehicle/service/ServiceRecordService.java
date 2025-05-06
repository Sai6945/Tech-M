package com.mad.vehicle.service;

import com.mad.vehicle.entity.ServiceRecord;
import com.mad.vehicle.repo.ServiceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRecordService {
    @Autowired private ServiceRecordRepository repo;
    public List<ServiceRecord> getAll() { return repo.findAll(); }
    public ServiceRecord save(ServiceRecord sr) { return repo.save(sr); }
    public Optional<ServiceRecord> getById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
