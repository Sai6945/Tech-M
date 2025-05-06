package com.mad.vehicle.entity;

import jakarta.persistence.*;

@Entity
public class WorkItem {
    @Id @GeneratedValue
    private Long id;
    private String description;
    private double cost;

    @ManyToOne
    @JoinColumn(name = "service_record_id")
    private ServiceRecord serviceRecord;
    public WorkItem() {
    	
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public ServiceRecord getServiceRecord() {
		return serviceRecord;
	}
	public void setServiceRecord(ServiceRecord serviceRecord) {
		this.serviceRecord = serviceRecord;
	}
}