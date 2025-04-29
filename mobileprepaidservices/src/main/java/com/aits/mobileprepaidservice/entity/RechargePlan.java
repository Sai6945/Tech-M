package com.aits.mobileprepaidservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class RechargePlan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String category;
	private String price;
	
	private int validityInDays;
	public RechargePlan() {
		
	}
	public RechargePlan(Integer id, String name, String category, String price, int validityInDays) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.validityInDays = validityInDays;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getValidityInDays() {
		return validityInDays;
	}
	public void setValidityInDays(int validityInDays) {
		this.validityInDays = validityInDays;
	}
	

}
