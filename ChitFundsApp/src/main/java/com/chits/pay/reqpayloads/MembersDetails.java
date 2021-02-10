package com.chits.pay.reqpayloads;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MembersDetails implements Serializable{
	private static final long serialVersionUID = -8579617402776016257L;
	
	private BigInteger chitId;
	private List<Members> membersList;
	
	public BigInteger getChitId() {
		return chitId;
	}
	public List<Members> getMembersList() {
		return membersList;
	}
	public void setChitId(BigInteger chitId) {
		this.chitId = chitId;
	}
	public void setMembersList(List<Members> membersList) {
		this.membersList = membersList;
	}
	
	
}
