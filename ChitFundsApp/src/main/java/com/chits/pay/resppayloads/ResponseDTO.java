package com.chits.pay.resppayloads;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import com.chits.pay.entity.ChitsDetailsEntity;
import com.chits.pay.entity.MembersDetailsEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class ResponseDTO implements Serializable{
	private static final long serialVersionUID = 4186532256857211912L;
	
	private String statusCode;
	private String statusMessage;
	private BigInteger adminId;
	private String adminName;
	private List<ChitsDetailsEntity> chitsDetailsList;
	private List<MembersDetailsEntity> membersDetailsList;
	private Integer count;
	private BigInteger chitId;

	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public BigInteger getAdminId() {
		return adminId;
	}
	public void setAdminId(BigInteger adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public List<ChitsDetailsEntity> getChitsDetailsList() {
		return chitsDetailsList;
	}
	public void setChitsDetailsList(List<ChitsDetailsEntity> chitsDetailsList) {
		this.chitsDetailsList = chitsDetailsList;
	}
	public List<MembersDetailsEntity> getMembersDetailsList() {
		return membersDetailsList;
	}
	public void setMembersDetailsList(List<MembersDetailsEntity> membersDetailsList) {
		this.membersDetailsList = membersDetailsList;
	}
	public BigInteger getChitId() {
		return chitId;
	}
	public void setChitId(BigInteger chitId) {
		this.chitId = chitId;
	}

	
}
