package com.simactivation.customerMS.service;


import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.simactivation.customerMS.entity.Customer;
import com.simactivation.customerMS.dto.*;
@Service
public interface CustomerServices {
	public Customer verifycustomerbasicdetail(LocalDate dob,String emailid);
	public Customer VerifyIdProof(String idNumber);
	public SimDetailsDTO verifysimstatus(int simid);
	public void updatesimstatus(String status,int simid) ;
}
