package com.simactivation.customerMS.service;

import org.springframework.stereotype.Service;

import com.simactivation.customerMS.entity.CustomerIdentity;

@Service
public interface CustomerIdentityServices {
	public CustomerIdentity verificationCustomerIdentity (String firstname,String lastname) ;
}
