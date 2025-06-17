package com.aits.vehicle_service_management.repository;

import com.aits.vehicle_service_management.model.BillItem;
import com.aits.vehicle_service_management.model.ServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillItemRepository extends JpaRepository<BillItem, Long> {
    List<BillItem> findByServiceRecord(ServiceRecord serviceRecord);
}