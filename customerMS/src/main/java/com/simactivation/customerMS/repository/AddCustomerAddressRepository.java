package com.simactivation.customerMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simactivation.customerMS.entity.CustomerAddress;
@Repository
public interface AddCustomerAddressRepository extends JpaRepository<CustomerAddress, Integer>{
	@Transactional
	   @Modifying
		@Query(value = "INSERT into Customer_Address(pincode,address,city,state) values (?1,?2,?3,?4)", nativeQuery = true)
		public void InsertCustomerAddress(long pincode,String add,String city,String state);

}