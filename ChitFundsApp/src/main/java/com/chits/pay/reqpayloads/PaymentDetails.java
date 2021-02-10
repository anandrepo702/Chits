package com.chits.pay.reqpayloads;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDetails implements Serializable{
	private static final long serialVersionUID = -5232433995470044638L;
	
	private List<Payments> paymentsList;
	
	public List<Payments> getPaymentsList() {
		return paymentsList;
	}
	public void setPaymentsList(List<Payments> paymentsList) {
		this.paymentsList = paymentsList;
	}
	
	
	
}
