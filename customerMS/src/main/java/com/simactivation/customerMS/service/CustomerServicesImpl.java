package com.simactivation.customerMS.service;

import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.simactivation.customerMS.dto.SimDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.simactivation.customerMS.entity.Customer;
import com.simactivation.customerMS.repository.CustomerRepository;
@Service
public class CustomerServicesImpl implements CustomerServices{

	@Autowired
	private CustomerRepository customerRepository;
	
//	@Autowired
//	private SimDetailsRepository simDetailsRepository;
	@Override
	public Customer verifycustomerbasicdetail(LocalDate dob, String emailid) {
		return customerRepository.findByDateOfBirthAndEmailAddress(dob, emailid);
	}
	@Override
	public Customer VerifyIdProof(String idNumber) {
		return customerRepository.findByUniqueIdNumber(idNumber);
	}
	@Override
	public SimDetailsDTO verifysimstatus(int simid) {
		return null;
//		System.out.println("================================");
//		List<ServiceInstance>friendInstances = client.getInstances("simMS");
//		ServiceInstance s1 = friendInstances.get(0);
//		URI frduri = s1.getUri();
//		System.out.println(frduri+" "+simid);
//		SimDetailsDTO simdetailsdto = new RestTemplate().getForObject(frduri+"/simdetailsof/"+simid,SimDetailsDTO.class);
//		System.out.println(simdetailsdto);
//		SimDetailsDTO s1 =
//		return simdetailsdto;
		
		
	}
	@Override
	public void updatesimstatus(String status, int simid) {
//		simDetailsRepository.updateSimStatus(status, simid);		
	}
	
}
