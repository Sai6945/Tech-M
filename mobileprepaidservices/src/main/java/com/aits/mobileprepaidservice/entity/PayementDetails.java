package com.aits.mobileprepaidservice.entity;

import lombok.Data;

@Data
public class PayementDetails {
	private String method;
	private String upiId;
	private String cardNumber;
	private String bankAccount;

}
