package com.aits.vehicle_service_management.repository;

import com.aits.vehicle_service_management.model.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {
}