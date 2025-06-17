package com.aits.vehicle_service_management.controller;

import com.aits.vehicle_service_management.model.ServiceRecord;
import com.aits.vehicle_service_management.repository.ServiceRecordRepository;
import com.aits.vehicle_service_management.service.InvoiceService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin("*")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ServiceRecordRepository serviceRecordRepo;

    @GetMapping("/{serviceId}")
    public void generateInvoice(@PathVariable Long serviceId, HttpServletResponse response) {
        ServiceRecord record = serviceRecordRepo.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        invoiceService.generateInvoice(record, response);
    }
}