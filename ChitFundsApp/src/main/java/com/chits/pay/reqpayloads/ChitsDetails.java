package com.chits.pay.reqpayloads;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChitsDetails implements Serializable{
	private static final long serialVersionUID = 5701597765393622926L;
	
	private BigInteger adminId;
	private Integer chitNumber;
	private String chitNickName;
	private String chitStartedMonth;
	private Integer noOfMonths;
	private Integer noOfMembers;
	
	public BigInteger getAdminId() {
		return adminId;
	}
	public void setAdminId(BigInteger adminId) {
		this.adminId = adminId;
	}
	public Integer getChitNumber() {
		return chitNumber;
	}
	public void setChitNumber(Integer chitNumber) {
		this.chitNumber = chitNumber;
	}
	public String getChitNickName() {
		return chitNickName;
	}
	public void setChitNickName(String chitNickName) {
		this.chitNickName = chitNickName;
	}
	public String getChitStartedMonth() {
		return chitStartedMonth;
	}
	public Integer getNoOfMonths() {
		return noOfMonths;
	}
	public Integer getNoOfMembers() {
		return noOfMembers;
	}
	public void setChitStartedMonth(String chitStartedMonth) {
		this.chitStartedMonth = chitStartedMonth;
	}
	public void setNoOfMonths(Integer noOfMonths) {
		this.noOfMonths = noOfMonths;
	}
	public void setNoOfMembers(Integer noOfMembers) {
		this.noOfMembers = noOfMembers;
	}	
	

}
