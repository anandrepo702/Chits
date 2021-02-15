package com.chits.pay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chits.pay.businesslogics.AdminLogics;
import com.chits.pay.reqpayloads.AdminDetails;
import com.chits.pay.reqpayloads.ChitsDetails;
import com.chits.pay.reqpayloads.MembersDetails;
import com.chits.pay.reqpayloads.PaymentDetails;
import com.chits.pay.resppayloads.ResponseDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	AdminLogics adminLogics;

	@PostMapping("register")
	@ApiOperation(value = "Registers the admin",notes="aaaaaaaaa",response=ResponseDTO.class)
	public ResponseEntity<?> register(@RequestBody AdminDetails adminDetails){
		ResponseDTO responseDTO = adminLogics.register(adminDetails);
		return new ResponseEntity<>(responseDTO,HttpStatus.OK);
	}
	
	@GetMapping("test")	 
	public ResponseEntity<?> test( @ApiParam(value = "Id of the test",required = true) @RequestParam String id){
		System.out.println(id);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody AdminDetails adminDetails){
		ResponseDTO responseDTO = adminLogics.login(adminDetails);
		return new ResponseEntity<>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("show-chits-dashboard")
	public ResponseEntity<?> showChitsDashBoard(@RequestBody ChitsDetails chitsDetails){
		ResponseDTO responseDTO = adminLogics.showChitsDashBoard(chitsDetails.getAdminId());
		return new ResponseEntity<>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("show-members-dashboard")
	public ResponseEntity<?> showMembersDashBoard(@RequestBody ChitsDetails chitsDetails){
		ResponseDTO responseDTO = adminLogics.showMembersDashBoard(chitsDetails.getChitId());
		return new ResponseEntity<>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("new-chit")
	public ResponseEntity<?> newChit(@RequestBody ChitsDetails chitsDetails){
		ResponseDTO responseDTO = adminLogics.newChit(chitsDetails);
		return new ResponseEntity<>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("add-members")
	public ResponseEntity<?> addMembers(@RequestBody MembersDetails membersDetails){
		ResponseDTO responseDTO = adminLogics.addMembers(membersDetails);
		return new ResponseEntity<>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("edit-payments")
	public ResponseEntity<?> editPayments(@RequestBody PaymentDetails paymentDetails){
		ResponseDTO responseDTO = adminLogics.editPayments(paymentDetails);
		return new ResponseEntity<>(responseDTO,HttpStatus.OK);
	}
}
