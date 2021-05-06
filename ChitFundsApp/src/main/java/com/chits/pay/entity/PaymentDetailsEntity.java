package com.chits.pay.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "payment_details")
public class PaymentDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private BigInteger paymentId;
	
	@JsonIgnore
	@Column(name = "member_id")
	private BigInteger memberId;
	
	@Column(name = "month_id")
	private Integer monthId;
	
	@Column(name = "month_year")
	private String monthYear;

	@Column(name = "amount_paid")
	private BigInteger amountPaid;
	
	@Column(name = "chit_drawn_or_not")
	private Boolean chitWithDrawnOrNot;
	

	public BigInteger getPaymentId() {
		return paymentId;
	}

	public BigInteger getMemberId() {
		return memberId;
	}

	public Integer getMonthId() {
		return monthId;
	}

	public BigInteger getAmountPaid() {
		return amountPaid;
	}

	public void setPaymentId(BigInteger paymentId) {
		this.paymentId = paymentId;
	}

	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}

	public void setMonthId(Integer monthId) {
		this.monthId = monthId;
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

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}
	
	
	
}
