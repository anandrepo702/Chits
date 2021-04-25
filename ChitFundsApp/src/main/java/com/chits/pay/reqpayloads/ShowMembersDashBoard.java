package com.chits.pay.reqpayloads;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShowMembersDashBoard implements Serializable{
	private static final long serialVersionUID = 5701597765393622926L;
	
	private BigInteger chitId;

	public BigInteger getChitId() {
		return chitId;
	}

	public void setChitId(BigInteger chitId) {
		this.chitId = chitId;
	}
	

}
