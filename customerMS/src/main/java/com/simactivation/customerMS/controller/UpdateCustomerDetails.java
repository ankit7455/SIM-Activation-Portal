package com.simactivation.customerMS.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simactivation.customerMS.entity.CustomerAddress;
import com.simactivation.customerMS.service.CustomerAddressServices;
import com.simactivation.customerMS.validation.ValidatePersonalDetails;
import com.simactivation.customerMS.validation.ValidateUpdateDetail;

@RestController
@RequestMapping("/customer/update")
@Valid
public class UpdateCustomerDetails {
	@Autowired
	private CustomerAddressServices customerAddressServices;
	
	@PutMapping(value = "/validate")
	public ResponseEntity<String> validateAddreessDetails
	(@Valid @RequestBody ValidateUpdateDetail vpd)
	{
		String message  = customerAddressServices.updationCustomerAddress(
				(long) vpd.getPincode(), vpd.getAddress(), vpd.getCity(), vpd.getState());
		return ResponseEntity.ok(message);
	}
}
