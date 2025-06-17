package com.aits.vehicle_service_management.service;

import com.aits.vehicle_service_management.model.BillItem;
import com.aits.vehicle_service_management.model.ServiceRecord;
import com.aits.vehicle_service_management.repository.BillItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillItemService {

    @Autowired
    private BillItemRepository billItemRepo;

    public List<BillItem> getItemsByService(ServiceRecord service) {
        return billItemRepo.findByServiceRecord(service);
    }

    public BillItem addBillItem(BillItem item) {
        return billItemRepo.save(item);
    }

    public void deleteBillItem(Long id) {
        billItemRepo.deleteById(id);
    }
}