package com.chits.pay.reqpayloads;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShowChitsDashBoard implements Serializable{
	private static final long serialVersionUID = 5701597765393622926L;
	
	private BigInteger adminId;
	
	public BigInteger getAdminId() {
		return adminId;
	}
	public void setAdminId(BigInteger adminId) {
		this.adminId = adminId;
	}
}
