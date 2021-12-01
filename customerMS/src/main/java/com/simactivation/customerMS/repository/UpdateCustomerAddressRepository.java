package com.simactivation.customerMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simactivation.customerMS.entity.CustomerAddress;
@Repository
public interface UpdateCustomerAddressRepository extends JpaRepository<CustomerAddress, Integer>{
	@Transactional
	  @Modifying
		@Query(value = "update CustomerAddress set pincode= ?1 ,address=?2 where city=?3 and state=?4")
		public void updateCustomerAddress(long pincode,String add,String city,String state);

}