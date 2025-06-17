package com.aits.vehicle_service_management.controller;

import com.aits.vehicle_service_management.model.WorkItem;
import com.aits.vehicle_service_management.service.WorkItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work-items")
@CrossOrigin("*")
public class WorkItemController {

    @Autowired
    private WorkItemService workItemService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SERVICE_ADVISOR')")
    public List<WorkItem> getAll() {
        return workItemService.getAllItems();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public WorkItem addItem(@RequestBody WorkItem item) {
        return workItemService.addItem(item);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteItem(@PathVariable Long id) {
        workItemService.deleteItem(id);
    }
}