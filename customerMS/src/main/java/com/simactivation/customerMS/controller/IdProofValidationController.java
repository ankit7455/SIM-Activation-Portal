package com.simactivation.customerMS.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.simactivation.customerMS.dto.SimDetailsDTO;
import com.simactivation.customerMS.entity.Customer;
import com.simactivation.customerMS.service.CustomerServices;
import com.simactivation.customerMS.validation.ValidateIdProof;

@RestController
@RequestMapping(value = "/customer/idproof")
@Validated
public class IdProofValidationController {
	@Autowired
	private CustomerServices customerServices;
	@Autowired
	DiscoveryClient client;
	@HystrixCommand(fallbackMethod = "validateIdproofFallback")
	@PutMapping(value = "/validate")
	public ResponseEntity<String> validateIdproof(@Valid @RequestBody ValidateIdProof val)
	{
		System.out.println("===================================");
		Customer customer = customerServices.VerifyIdProof(val.getIdNumber());
		if(customer == null)
		{
			return ResponseEntity.ok("Invalid details");
		}
		else {
			System.out.println("+============================================");
			if(customer.getFirstName().matches(val.getFirstname()) && 
					customer.getLastName().matches(val.getLastname())&&
					customer.getDateOfBirth().equals(val.getDobDate()))	
			{
				List<ServiceInstance>friendInstances = client.getInstances("simMS");
				ServiceInstance s1 = friendInstances.get(0);
				URI frduri = s1.getUri();
				System.out.println(frduri+" "+customer.getSimId());
				SimDetailsDTO simdetailsdto = new RestTemplate().getForObject(frduri+"/simdetails/simdetailsof/"+customer.getSimId(),SimDetailsDTO.class);
				System.out.println(simdetailsdto);
				
				
				//SimDetailsDTO d1 = customerServices.verifysimstatus(customer.getSimId());
				//System.out.println(d1.getSimStatus());
				if(simdetailsdto.getSimStatus().matches("active"))
					return ResponseEntity.ok("Sim status is active");
				else if(simdetailsdto.getSimStatus().matches("inactive"))
				{
					customerServices.updatesimstatus("active", customer.getSimId());
					return ResponseEntity.ok("sim status is activated");
				}
				else
				{
					return ResponseEntity.ok("Enter Valid Details");
				}
			}
			else {
				return ResponseEntity.ok("Invalid Details");
			}
		}
	}
	public ResponseEntity<String> validateIdproofFallback(@Valid @RequestBody ValidateIdProof val)
	{
		return ResponseEntity.ok("Fall Back, Getting microservices error");
	}
}
