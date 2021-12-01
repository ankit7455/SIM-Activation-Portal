package com.simactivation.simMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simactivation.simMS.dto.SimDetailsDTO;
import com.simactivation.simMS.entity.SimDetails;
import com.simactivation.simMS.entity.SimOffers;
import com.simactivation.simMS.repository.GetSimStatusRepository;
import com.simactivation.simMS.repository.SimDetailsRepository;
import com.simactivation.simMS.repository.SimOffersRepository;

@Service
public class SimDetailsServicesImpl implements SimDetailsServices{

	@Autowired
	public SimDetailsRepository simDetailsRepository;
	@Autowired
	public SimOffersRepository simOffersRepository;
	@Autowired
	public GetSimStatusRepository getSimStatisRepository;
	@Override
	public SimDetails verificationservice(String simnumber, String servicenumber)
	{
		return simDetailsRepository.findBySimNumerAndServiceNumber(simnumber, servicenumber);	
	}

	@Override
	public SimOffers getSimOfferDetails(int simid) {
		return  simOffersRepository.findBySimid(simid);
	}

	@Override
	public SimDetailsDTO getsimPlans(int simid) {
		return SimDetailsDTO.valueOf(getSimStatisRepository.findBySimId(simid));
	}
	
}
