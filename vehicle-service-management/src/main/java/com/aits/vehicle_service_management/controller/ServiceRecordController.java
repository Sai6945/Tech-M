package com.aits.vehicle_service_management.controller;

import com.aits.vehicle_service_management.dto.ServiceRecordDTO;
import com.aits.vehicle_service_management.model.ServiceRecord;
import com.aits.vehicle_service_management.model.ServiceStatus;
import com.aits.vehicle_service_management.model.User;
import com.aits.vehicle_service_management.model.Vehicle;
import com.aits.vehicle_service_management.repository.UserRepository;
import com.aits.vehicle_service_management.repository.VehicleRepository;
import com.aits.vehicle_service_management.service.ServiceRecordService;
import com.aits.vehicle_service_management.service.UserService;
import com.aits.vehicle_service_management.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/service-records")
@CrossOrigin("*")
public class ServiceRecordController {

    @Autowired
    private ServiceRecordService recordService;

    @GetMapping
    public List<ServiceRecordDTO> getAllRecords() {
        List<ServiceRecord> serviceRecords = recordService.getAll();
        return serviceRecords.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ServiceRecord getById(@PathVariable Long id) {
        return recordService.getById(id);
    }

    @PostMapping
    public ServiceRecord create(@RequestBody ServiceRecord record) {
        return recordService.save(record);
    }

    @PutMapping("/{id}")
    public ServiceRecord update(@PathVariable Long id, @RequestBody ServiceRecord updatedRecord) {
        updatedRecord.setId(id);
        return recordService.save(updatedRecord);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recordService.delete(id);
    }

    @GetMapping("/user/{userId}")
    public List<ServiceRecord> getByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return recordService.getByUser(user);
    }

    @GetMapping("/status/{status}")
    public List<ServiceRecord> getByStatus(@PathVariable ServiceStatus status) {
        return recordService.getByStatus(status);
    }

    @GetMapping("/due-this-week")
    public List<ServiceRecord> getDueThisWeek() {
        return recordService.getDueThisWeek();
    }

    @PutMapping("/{id}/status")
    public ServiceRecord updateStatus(@PathVariable Long id, @RequestBody ServiceStatus newStatus) {
        return recordService.updateStatus(id, newStatus);
    }

    // Helper method to convert entity to DTO
    private ServiceRecordDTO convertToDTO(ServiceRecord record) {
        ServiceRecordDTO dto = new ServiceRecordDTO();
        dto.setId(record.getId());
        dto.setServiceType(record.getServiceType());
        dto.setDescription(record.getDescription());
        dto.setServiceDate(record.getServiceDate());
        dto.setCost(record.getCost());
        dto.setStatus(record.getStatus().toString());

        if (record.getVehicle() != null) {
            dto.setVehicle(new ServiceRecordDTO.VehicleDTO(
                record.getVehicle().getId(),
                record.getVehicle().getVehicleNumber()
            ));
        }

        if (record.getUser() != null) {
            dto.setUser(new ServiceRecordDTO.UserDTO(
                record.getUser().getId(),
                record.getUser().getName()
            ));
        }

        return dto;
    }
    

    
}