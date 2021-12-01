package com.simactivation.customerMS.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simactivation.customerMS.entity.CustomerAddress;
import com.simactivation.customerMS.repository.AddCustomerAddressRepository;
import com.simactivation.customerMS.repository.CustomerAddressRepository;
import com.simactivation.customerMS.repository.UpdateCustomerAddressRepository;

@Service
public class CustomerAddressServicesImpl implements CustomerAddressServices 
{

	@Autowired
	private CustomerAddressRepository customerAddressRepository;
	
	@Autowired
	private AddCustomerAddressRepository addCustomerAddressRepository;
	
	@Autowired
	private UpdateCustomerAddressRepository updateCustomerAddressRepository;
	@Override
	public String updationCustomerAddress(long pincode, String add, String city, String State) {
		if(customerAddressRepository.findByCityAndState(city, State)==null)
		{
			addCustomerAddressRepository.InsertCustomerAddress(pincode, add, city, State);
			return "New Address added Sucessfully";
		}
		else {
			updateCustomerAddressRepository.updateCustomerAddress(pincode, add, city, State);
			return "Address Updated Sucessfully";
		}
		
	}

}
