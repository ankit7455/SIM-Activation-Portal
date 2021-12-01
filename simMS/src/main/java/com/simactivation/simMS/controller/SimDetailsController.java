package com.simactivation.simMS.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simactivation.simMS.dto.SimDetailsDTO;
import com.simactivation.simMS.entity.SimDetails;
import com.simactivation.simMS.entity.SimOffers;
import com.simactivation.simMS.service.SimDetailsServices;
import com.simactivation.simMS.validation.ValidateSimDetail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/sim")
@Validated
public class SimDetailsController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SimDetailsServices simDetailsServices;
	
	@PostMapping(value = "/validate")
	public ResponseEntity<String> validateCustomer(@Valid @RequestBody ValidateSimDetail validateCustomer) 
	{
		 
		 SimDetails simdetails1 = simDetailsServices.verificationservice
				(validateCustomer.getSimnumber(), validateCustomer.getServicenumber());
		if(simdetails1 == null)
			return ResponseEntity.ok("not available");
		else {
			SimOffers simOffers= simDetailsServices.getSimOfferDetails(simdetails1.getSimId());
			return ResponseEntity.ok(simOffers.getOfferName());
		}
		
	}
	@GetMapping(value = "/simdetailsof/{simId}")
	public SimDetailsDTO getsimdetails(@PathVariable Integer simId)
	{
		logger.info("Fetching details of plan {}",simId);
			return simDetailsServices.getsimPlans(simId);
			
	}
	
}
