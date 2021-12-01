package com.simactivation.customerMS.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simactivation.customerMS.entity.CustomerIdentity;
import com.simactivation.customerMS.service.CustomerIdentityServices;
import com.simactivation.customerMS.validation.ValidatePersonalDetails;

@RestController
@RequestMapping("/customer/personaldetails")
@Valid
public class PersonalCustomerDetailsController {
	@Autowired
	private CustomerIdentityServices customerIdentityServices;
	
	@PostMapping(value = "/validate")
	public ResponseEntity<String> validatePersonalDetail(
			@Valid @RequestBody ValidatePersonalDetails validatePersonalDetails)
	{
		CustomerIdentity customerIdentity = customerIdentityServices.verificationCustomerIdentity(
				validatePersonalDetails.getFirstName(), validatePersonalDetails.getLastName());
		if(customerIdentity == null)	
			return ResponseEntity.ok("No customer found for the provided details");
		else {
			//System.out.println(customerIdentity.getEmailAddress()==validatePersonalDetails.getEmailAddress());
			if(customerIdentity.getEmailAddress().matches(validatePersonalDetails.getEmailAddress()))
			{
				return ResponseEntity.ok("Sucess");
			}
			else {
				return ResponseEntity.ok("Invalid email details!!");
			}
		}	
	}
}
