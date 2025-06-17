package com.aits.vehicle_service_management.controller;

import com.aits.vehicle_service_management.model.BillItem;
import com.aits.vehicle_service_management.model.ServiceRecord;
import com.aits.vehicle_service_management.repository.ServiceRecordRepository;
import com.aits.vehicle_service_management.service.BillItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill-items")
@CrossOrigin("*")
public class BillItemController {

    @Autowired
    private BillItemService billItemService;

    @Autowired
    private ServiceRecordRepository serviceRecordRepo;

    @GetMapping("/service/{serviceId}")
    public List<BillItem> getByService(@PathVariable Long serviceId) {
        ServiceRecord sr = serviceRecordRepo.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        return billItemService.getItemsByService(sr);
    }

    @PostMapping
    public BillItem addItem(@RequestBody BillItem item) {
        return billItemService.addBillItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        billItemService.deleteBillItem(id);
    }
}