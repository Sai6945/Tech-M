package com.mad.vehicle.controller;

import com.mad.vehicle.entity.WorkItem;
import com.mad.vehicle.service.WorkItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workitems")
public class WorkItemController {
    @Autowired private WorkItemService service;

    @GetMapping public List<WorkItem> getAll() { return service.getAll(); }
    @PostMapping public WorkItem save(@RequestBody WorkItem w) { return service.save(w); }
    @GetMapping("/{id}") public ResponseEntity<WorkItem> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}