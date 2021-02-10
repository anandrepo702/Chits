package com.chits.pay.businesslogics;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chits.pay.entity.AdminDetailsEntity;
import com.chits.pay.entity.ChitsDetailsEntity;
import com.chits.pay.entity.MembersDetailsEntity;
import com.chits.pay.entity.MonthsLookUpEntity;
import com.chits.pay.entity.PaymentDetailsEntity;
import com.chits.pay.repositories.AdminDetailsRepository;
import com.chits.pay.repositories.ChitsDetailsRepository;
import com.chits.pay.repositories.MembersDetailsRepository;
import com.chits.pay.repositories.MonthsLookUpRepository;
import com.chits.pay.repositories.PaymentDetailsRepository;
import com.chits.pay.reqpayloads.AdminDetails;
import com.chits.pay.reqpayloads.ChitsDetails;
import com.chits.pay.reqpayloads.Members;
import com.chits.pay.reqpayloads.MembersDetails;
import com.chits.pay.reqpayloads.PaymentDetails;
import com.chits.pay.reqpayloads.Payments;
import com.chits.pay.resppayloads.ResponseDTO;

@Component
public class AdminLogics {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminLogics.class);
	
	@Autowired
	AdminDetailsRepository adminDetailsRepository;
	
	@Autowired
	ChitsDetailsRepository chitsDetailsRepository;
	
	@Autowired
	MembersDetailsRepository membersDetailsRepository;
	
	@Autowired
	PaymentDetailsRepository paymentDetailsRepository;
	
	@Autowired
	MonthsLookUpRepository monthsLookUpRepository;
	
	public ResponseDTO register(AdminDetails adminDetails) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			List<AdminDetailsEntity> existingAdminDetails = adminDetailsRepository.getExistingAdminDetails(adminDetails.getMobileNumber(), adminDetails.getEmailId());
			Boolean userNotExists = existingAdminDetails.isEmpty();
			if(userNotExists) {
				AdminDetailsEntity adminDetailsEntity = new AdminDetailsEntity();
				adminDetailsEntity.setName(adminDetails.getName());
				adminDetailsEntity.setMobileNumber(adminDetails.getMobileNumber());
				adminDetailsEntity.setEmailId(adminDetails.getEmailId());
				adminDetailsEntity.setPassword(adminDetails.getPassword());
				
				AdminDetailsEntity savedAdminDetails = adminDetailsRepository.save(adminDetailsEntity);
				if(savedAdminDetails == null) {
					responseDTO.setStatusCode("590");
					responseDTO.setStatusMesaage("Admin not registered please try again");
				}else {
					responseDTO.setStatusCode("200");
					responseDTO.setStatusMesaage("Success");
					responseDTO.setAdminName(savedAdminDetails.getName());
				}
			}else {
				responseDTO.setStatusCode("409");
				responseDTO.setStatusMesaage("User already exists");
			}
		}catch (Exception e) {
			logger.error("Got exception while registering the admin ",e);
			responseDTO.setStatusCode("500");
			responseDTO.setStatusMesaage("Internal Server Error");
		}
		return responseDTO;
	}
	
	public ResponseDTO login(AdminDetails adminDetails) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			AdminDetailsEntity validateLogin = adminDetailsRepository.validateLogin(adminDetails.getEmailId(),adminDetails.getPassword());
			if(validateLogin == null) {
				responseDTO.setStatusCode("401");
				responseDTO.setStatusMesaage("Invalid User");
				return responseDTO;
			}
			responseDTO = showChitsDashBoard(validateLogin.getAdminId());
		}catch (Exception e) {
			logger.error("Got exception while login ",e);
			responseDTO.setStatusCode("500");
			responseDTO.setStatusMesaage("Internal Server Error");
		}
		return responseDTO;
	}
	
	public ResponseDTO showChitsDashBoard(BigInteger adminId) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			List<ChitsDetailsEntity> chitDetailsList = chitsDetailsRepository.getChitDetails(adminId);
			responseDTO.setStatusCode("200");
			responseDTO.setStatusMesaage("Success");
			responseDTO.setChitsDetailsList(chitDetailsList);
			responseDTO.setCount(chitDetailsList.size());
		}catch (Exception e) {
			logger.error("Got exception while getting the chits details ",e);
			responseDTO.setStatusCode("500");
			responseDTO.setStatusMesaage("Internal Server Error");
		}
		return responseDTO;
	}
	
	public ResponseDTO showMembersDashBoard(BigInteger chitId) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			List<MembersDetailsEntity> membersDetailsList = membersDetailsRepository.getMembersDetails(chitId);
			Map<String, List<PaymentDetailsEntity>> paymentDetailsMap  = new HashMap<>(); 
			for(MembersDetailsEntity mde : membersDetailsList) {
				List<PaymentDetailsEntity> paymentDetails = paymentDetailsRepository.getPaymentDetails(mde.getMemberId());
				paymentDetailsMap.put(mde.getMemberName(), paymentDetails);
			}
			responseDTO.setStatusCode("200");
			responseDTO.setStatusMesaage("Success");
			responseDTO.setMembersDetailsList(membersDetailsList);
			responseDTO.setPaymentDetailsMap(paymentDetailsMap);
			responseDTO.setCount(membersDetailsList.size());
		}catch (Exception e) {
			logger.error("Got exception while getting the member details ",e);
			responseDTO.setStatusCode("500");
			responseDTO.setStatusMesaage("Internal Server Error");
		}
		return responseDTO;
	}
	
	public ResponseDTO newChit(ChitsDetails chitsDetails) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			ChitsDetailsEntity chitsDetailsEntity = new ChitsDetailsEntity();
			chitsDetailsEntity.setAdminId(chitsDetails.getAdminId());
			chitsDetailsEntity.setChitNumber(chitsDetails.getChitNumber());
			chitsDetailsEntity.setChitNickName(chitsDetails.getChitNickName());
			chitsDetailsEntity.setActiveOrNot(true);
			chitsDetailsEntity.setChitStartedMonth(chitsDetails.getChitStartedMonth());
			chitsDetailsEntity.setNoOfMonths(chitsDetails.getNoOfMonths());
			chitsDetailsEntity.setNoOfMembers(chitsDetails.getNoOfMembers());
			chitsDetailsRepository.save(chitsDetailsEntity);
			responseDTO.setStatusCode("200");
			responseDTO.setStatusMesaage("Success");
		}catch (Exception e) {
			logger.error("Got exception while creating the new chit ",e);
			responseDTO.setStatusCode("500");
			responseDTO.setStatusMesaage("Internal Server Error");
		}
		return responseDTO;
	}

	public ResponseDTO addMembers(MembersDetails membersDetails) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			List<Members> membersList = membersDetails.getMembersList();
			BigInteger chitId = membersDetails.getChitId();
			ChitsDetailsEntity chitsDetailsEntity = chitsDetailsRepository.findById(chitId).get();
			String chitStartedMonth = chitsDetailsEntity.getChitStartedMonth();
			Integer noOfMonths = chitsDetailsEntity.getNoOfMonths();
			MonthsLookUpEntity monthsLookUpEntity = monthsLookUpRepository.getMonthsDetails(chitStartedMonth);
			
			for(Members members : membersList) {
				MembersDetailsEntity membersDetailsEntity = new MembersDetailsEntity();
				membersDetailsEntity.setChitId(chitId);
				membersDetailsEntity.setMemberName(members.getMemberName());
				membersDetailsEntity.setMobileNumber(members.getMobileNumber());
				membersDetailsEntity.setEmailId(members.getEmailId());
				membersDetailsEntity = membersDetailsRepository.save(membersDetailsEntity);
				
				BigInteger memberId = membersDetailsEntity.getMemberId();
				Integer monthId = monthsLookUpEntity.getMonthId();
				String monthYear = monthsLookUpEntity.getMonthYear();
				for(int i = 0; i < noOfMonths; i++) {
					PaymentDetailsEntity paymentDetailsEntity = new PaymentDetailsEntity();
					paymentDetailsEntity.setMemberId(memberId);
					paymentDetailsEntity.setMonthId(monthId);
					paymentDetailsEntity.setMonthYear(monthYear);
					paymentDetailsEntity.setAmountPaid(new BigInteger("0"));
					paymentDetailsEntity.setChitWithDrawnOrNot(false);
					paymentDetailsRepository.save(paymentDetailsEntity);
					monthYear = getNextMonth(monthYear);
					monthId++;
				}
			}	
			responseDTO.setStatusCode("200");
			responseDTO.setStatusMesaage("Success");
		}catch (Exception e) {
			logger.error("Got exception while adding members to the chit ",e);
			responseDTO.setStatusCode("500");
			responseDTO.setStatusMesaage("Internal Server Error");
		}
		return responseDTO;
	}
	
	public ResponseDTO editPayments(PaymentDetails paymentDetails){
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			List<Payments> paymentsList = paymentDetails.getPaymentsList();
			for(Payments payments : paymentsList) {
				paymentDetailsRepository.updatePaymentDetails(payments.getAmountPaid(), payments.getChitWithDrawnOrNot(), payments.getPaymentId());
			}
			responseDTO.setStatusCode("200");
			responseDTO.setStatusMesaage("Success");
		}catch (Exception e) {
			logger.error("Got exception while updating the payment details ",e);
			responseDTO.setStatusCode("500");
			responseDTO.setStatusMesaage("Internal Server Error");
		}
		
		return responseDTO;
	}
	
	
	private String getNextMonth(String monthYear) {
		
		String month = monthYear.substring(0, 2);
		int monthInt = Integer.parseInt(month);
		String year = monthYear.substring(2, 6);
		int yearInt = Integer.parseInt(year);
		if(monthInt == 12) {
			yearInt = yearInt + 1;
			monthInt = 0;
		}
		monthInt = monthInt + 1;
		String str1 = Integer.toString(monthInt);
		if(monthInt < 10) {
			str1 = "0".concat(str1);
		}
	    String str2 = Integer.toString(yearInt);
	    return str1.concat(str2);
	}
}
