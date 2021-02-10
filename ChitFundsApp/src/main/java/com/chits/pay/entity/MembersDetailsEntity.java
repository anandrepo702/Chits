package com.chits.pay.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "members_details")
public class MembersDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private BigInteger memberId;
	
	@Column(name = "chit_id")
	private BigInteger chitId;
	
	@Column(name = "member_name")
	private String memberName;

	@Column(name = "mobile_no")
	private String mobileNumber;
	
	@Column(name = "email_id")
	private String emailId;
	

	public BigInteger getMemberId() {
		return memberId;
	}

	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}

	public BigInteger getChitId() {
		return chitId;
	}

	public void setChitId(BigInteger chitId) {
		this.chitId = chitId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

}
