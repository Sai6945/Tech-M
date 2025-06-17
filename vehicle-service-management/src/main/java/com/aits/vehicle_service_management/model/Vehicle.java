package com.aits.vehicle_service_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle_number") // Use @Column to map the field to the database column
    private String vehicleNumber;

    private String model;
    private String brand;
    private int year;
    private String status; // e.g., "DUE", "IN_PROGRESS", "COMPLETED"

    @ManyToOne
    @JoinColumn(name = "customer_id") // Foreign key column in vehicles table
    private Customer customer;

    public Vehicle() {}

    public Vehicle(String vehicleNumber, String model, String brand, int year, String status, Customer customer) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.status = status;
        this.customer = customer;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}