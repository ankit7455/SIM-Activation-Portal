package com.simactivation.simMS.service;

import org.springframework.stereotype.Service;

import com.simactivation.simMS.dto.SimDetailsDTO;
import com.simactivation.simMS.entity.SimDetails;
import com.simactivation.simMS.entity.SimOffers;
@Service
public interface SimDetailsServices {	
	
	public SimDetails verificationservice(String simnumber, String servicenumber);
	public SimOffers getSimOfferDetails(int simid);
	public SimDetailsDTO getsimPlans(int simid);
}
