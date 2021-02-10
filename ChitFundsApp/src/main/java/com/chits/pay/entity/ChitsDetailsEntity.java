package com.chits.pay.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chits_details")
public class ChitsDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chit_id")
	private BigInteger chitId;
	
	@Column(name = "admin_id")
	private BigInteger adminId;
	
	@Column(name = "chit_number")
	private Integer chitNumber;

	@Column(name = "chit_nick_name")
	private String chitNickName;
	
	@Column(name = "active_or_not")
	private Boolean activeOrNot;
	
	@Column(name = "chit_started_month")
	private String chitStartedMonth;
	
	@Column(name = "no_of_months")
	private Integer noOfMonths;
	
	@Column(name = "no_of_members")
	private Integer noOfMembers;
	

	public BigInteger getChitId() {
		return chitId;
	}

	public void setChitId(BigInteger chitId) {
		this.chitId = chitId;
	}

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

	public Boolean getActiveOrNot() {
		return activeOrNot;
	}

	public void setActiveOrNot(Boolean activeOrNot) {
		this.activeOrNot = activeOrNot;
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
