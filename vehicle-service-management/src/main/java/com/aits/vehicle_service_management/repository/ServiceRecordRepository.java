package com.aits.vehicle_service_management.repository;

import com.aits.vehicle_service_management.model.ServiceRecord;
import com.aits.vehicle_service_management.model.ServiceStatus;
import com.aits.vehicle_service_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ServiceRecordRepository extends JpaRepository<ServiceRecord, Long> {
    List<ServiceRecord> findByUser(User user);
    List<ServiceRecord> findByStatus(ServiceStatus status);
    List<ServiceRecord> findByServiceDateBetween(LocalDate startDate, LocalDate endDate);
    List<ServiceRecord> findByStatusAndServiceDateBetween(ServiceStatus status, LocalDate start, LocalDate end);
}