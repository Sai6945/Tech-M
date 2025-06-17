package com.aits.vehicle_service_management.service;

import com.aits.vehicle_service_management.model.ServiceRecord;
import com.aits.vehicle_service_management.model.ServiceStatus;
import com.aits.vehicle_service_management.model.User;
import com.aits.vehicle_service_management.repository.ServiceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceRecordService {

    @Autowired
    private ServiceRecordRepository recordRepo;

    public List<ServiceRecord> getAll() {
        return recordRepo.findAll();
    }

    public ServiceRecord getById(Long id) {
        return recordRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Service record not found"));
    }

    public ServiceRecord save(ServiceRecord record) {
    	ServiceRecord saved = recordRepo.save(record);
    	return recordRepo.findById(saved.getId()).orElse(saved);

    }

    public void delete(Long id) {
        recordRepo.deleteById(id);
    }

    public List<ServiceRecord> getByUser(User user) {
        return recordRepo.findByUser(user);
    }

    public List<ServiceRecord> getByStatus(ServiceStatus status) {
        return recordRepo.findByStatus(status);
    }

    public List<ServiceRecord> getDueThisWeek() {
        LocalDate today = LocalDate.now();
        LocalDate endOfWeek = today.plusDays(7);
        return recordRepo.findByStatusAndServiceDateBetween(ServiceStatus.SCHEDULED, today, endOfWeek);
    }

    public List<ServiceRecord> getByDateRange(LocalDate start, LocalDate end) {
        return recordRepo.findByServiceDateBetween(start, end);
    }

    public ServiceRecord updateStatus(Long id, ServiceStatus newStatus) {
        ServiceRecord record = getById(id);
        record.setStatus(newStatus);
        return recordRepo.save(record);
    }
}