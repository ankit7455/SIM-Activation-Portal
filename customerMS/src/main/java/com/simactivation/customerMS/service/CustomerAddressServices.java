package com.simactivation.customerMS.service;

import org.springframework.stereotype.Service;

import com.simactivation.customerMS.entity.CustomerAddress;
@Service
public interface CustomerAddressServices {
	public String updationCustomerAddress(long pincode,String add,String city,String State);
}
