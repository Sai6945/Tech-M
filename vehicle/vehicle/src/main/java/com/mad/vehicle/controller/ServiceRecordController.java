package com.mad.vehicle.controller;

import com.mad.vehicle.entity.ServiceRecord;
import com.mad.vehicle.service.ServiceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicerecords")
public class ServiceRecordController {
    @Autowired private ServiceRecordService service;

    @GetMapping public List<ServiceRecord> getAll() { return service.getAll(); }
    @PostMapping public ServiceRecord save(@RequestBody ServiceRecord sr) { return service.save(sr); }
    @GetMapping("/{id}") public ResponseEntity<ServiceRecord> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}