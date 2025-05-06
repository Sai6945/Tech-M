package com.mad.vehicle.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;
@Entity
public class ServiceRecord {
    @Id @GeneratedValue
    private Long id;
    private LocalDate serviceDate;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "serviceRecord", cascade = CascadeType.ALL)
    private List<WorkItem> workItems;

    @OneToOne(mappedBy = "serviceRecord", cascade = CascadeType.ALL)
    private Billing billing;
    public ServiceRecord() {
    	
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(LocalDate serviceDate) {
		this.serviceDate = serviceDate;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public List<WorkItem> getWorkItems() {
		return workItems;
	}
	public void setWorkItems(List<WorkItem> workItems) {
		this.workItems = workItems;
	}
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
    
}