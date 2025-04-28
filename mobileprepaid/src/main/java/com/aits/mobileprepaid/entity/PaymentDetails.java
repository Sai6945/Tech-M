package com.aits.mobileprepaid.entity;

import lombok.Data;

@Data
public class PaymentDetails {
    private String method;
    private String upiId;
    private String cardNumber;
    private String bankAccount;
}