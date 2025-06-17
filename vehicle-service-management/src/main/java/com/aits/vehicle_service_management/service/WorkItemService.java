package com.aits.vehicle_service_management.service;

import com.aits.vehicle_service_management.model.WorkItem;
import com.aits.vehicle_service_management.repository.WorkItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkItemService {

    @Autowired
    private WorkItemRepository workItemRepo;

    public List<WorkItem> getAllItems() {
        return workItemRepo.findAll();
    }

    public WorkItem addItem(WorkItem item) {
        return workItemRepo.save(item);
    }

    public void deleteItem(Long id) {
        workItemRepo.deleteById(id);
    }
}