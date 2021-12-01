package com.simactivation.customerMS.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.simactivation.customerMS.entity.Customer;
import com.simactivation.customerMS.service.CustomerServices;
import com.simactivation.customerMS.validation.ValidateCustomerBasicDetail;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerBasicDetailscontroller {
	
	@Autowired
	private CustomerServices customerServices;
	
	@PostMapping(value="/validatecustomerdetail")
	public ResponseEntity<String> validatecustomerbasicdetail (@Valid @RequestBody ValidateCustomerBasicDetail validateCustomerBasicDetail)
	{
		Customer c1 = customerServices.verifycustomerbasicdetail(validateCustomerBasicDetail.getBirthdate(), validateCustomerBasicDetail.getEmailid());
		System.out.println(c1);
		if(c1==null)
			return ResponseEntity.ok("No request placed for you");
		else {
			return ResponseEntity.ok("Success");
		}
	}
	
}
