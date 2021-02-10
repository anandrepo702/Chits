package com.chits.pay.reqpayloads;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payments implements Serializable{
	private static final long serialVersionUID = 2598293281096288269L;
	
	private BigInteger paymentId;
	private BigInteger memberId;
	private Integer monthId;
	private String monthYear;
	private BigInteger amountPaid;
	private Boolean chitWithDrawnOrNot;
	
	public BigInteger getMemberId() {
		return memberId;
	}
	public Integer getMonthId() {
		return monthId;
	}
	public String getMonthYear() {
		return monthYear;
	}
	public BigInteger getAmountPaid() {
		return amountPaid;
	}
	public Boolean getChitWithDrawnOrNot() {
		return chitWithDrawnOrNot;
	}
	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}
	public void setMonthId(Integer monthId) {
		this.monthId = monthId;
	}
	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}
	public void setAmountPaid(BigInteger amountPaid) {
		this.amountPaid = amountPaid;
	}
	public void setChitWithDrawnOrNot(Boolean chitWithDrawnOrNot) {
		this.chitWithDrawnOrNot = chitWithDrawnOrNot;
	}
	public BigInteger getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(BigInteger paymentId) {
		this.paymentId = paymentId;
	}

	
	
}
