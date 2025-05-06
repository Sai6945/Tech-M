package com.mad.vehicle.entity;

import jakarta.persistence.*;


@Entity
public class Billing {
    @Id @GeneratedValue
    private Long id;
    private double totalAmount;

    @OneToOne
    @JoinColumn(name = "service_record_id")
    private ServiceRecord serviceRecord;
    public Billing() {
    	
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public ServiceRecord getServiceRecord() {
		return serviceRecord;
	}
	public void setServiceRecord(ServiceRecord serviceRecord) {
		this.serviceRecord = serviceRecord;
	}
    
}