package com.aits.vehicle_service_management.service;

import com.aits.vehicle_service_management.model.Vehicle;
import com.aits.vehicle_service_management.model.Customer;
import com.aits.vehicle_service_management.repository.VehicleRepository;
import com.aits.vehicle_service_management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepo;

    @Autowired
    private CustomerRepository customerRepo; // <-- ADD this line

    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        if (vehicle.getCustomer() != null && vehicle.getCustomer().getId() != null) {
            Customer customer = customerRepo.findById(vehicle.getCustomer().getId())
                    .orElseThrow(() -> new RuntimeException("Customer not found with id " + vehicle.getCustomer().getId()));
            vehicle.setCustomer(customer);
        }
        return vehicleRepo.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Vehicle vehicle = getVehicleById(id);
        vehicle.setVehicleNumber(updatedVehicle.getVehicleNumber());
        vehicle.setModel(updatedVehicle.getModel());
        vehicle.setBrand(updatedVehicle.getBrand());
        vehicle.setYear(updatedVehicle.getYear());
        vehicle.setStatus(updatedVehicle.getStatus());
        return vehicleRepo.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepo.deleteById(id);
    }
}