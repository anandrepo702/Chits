package com.chits.pay.reqpayloads;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payments implements Serializable{
	private static final long serialVersionUID = 2598293281096288269L;
	
	private BigInteger paymentId;
	private BigInteger amountPaid;
	private Boolean chitWithDrawnOrNot;
	
	public BigInteger getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(BigInteger paymentId) {
		this.paymentId = paymentId;
	}
	public BigInteger getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(BigInteger amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Boolean getChitWithDrawnOrNot() {
		return chitWithDrawnOrNot;
	}
	public void setChitWithDrawnOrNot(Boolean chitWithDrawnOrNot) {
		this.chitWithDrawnOrNot = chitWithDrawnOrNot;
	}
		
}
