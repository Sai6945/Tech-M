package com.mad.vehicle.repo;

import com.mad.vehicle.entity.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {}
