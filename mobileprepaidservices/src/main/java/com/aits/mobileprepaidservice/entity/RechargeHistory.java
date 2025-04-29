package com.aits.mobileprepaidservice.entity;



import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class RechargeHistory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JsonIgnore
	private User user;
	@ManyToOne
	private RechargePlan plan;
	private String paymentMethod;
	private LocalDateTime rechargeDate;
	public RechargeHistory() {
		
	}
	public RechargeHistory(long id, User user, RechargePlan plan, String paymentMethod, LocalDateTime rechargeDate) {
		super();
		this.id = id;
		this.user = user;
		this.plan = plan;
		this.paymentMethod = paymentMethod;
		this.rechargeDate = rechargeDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public RechargePlan getPlan() {
		return plan;
	}
	public void setPlan(RechargePlan plan) {
		this.plan = plan;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public LocalDateTime getRechargeDate() {
		return rechargeDate;
	}
	public void setRechargeDate(LocalDateTime rechargeDate) {
		this.rechargeDate = rechargeDate;
	}
	

}
