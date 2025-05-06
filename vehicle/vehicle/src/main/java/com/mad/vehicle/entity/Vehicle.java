package com.mad.vehicle.entity;

import jakarta.persistence.*;
import java.util.*;


@Entity
public class Vehicle {
    @Id @GeneratedValue
    private Long id;
    
    private String model;
    private String registrationNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<ServiceRecord> serviceRecords;
    public Vehicle() {
    	
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<ServiceRecord> getServiceRecords() {
		return serviceRecords;
	}
	public void setServiceRecords(List<ServiceRecord> serviceRecords) {
		this.serviceRecords = serviceRecords;
	}
}