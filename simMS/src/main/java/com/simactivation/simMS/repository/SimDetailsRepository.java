package com.simactivation.simMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simactivation.simMS.entity.SimDetails;

@Repository
public interface SimDetailsRepository extends JpaRepository<SimDetails, Integer>{
	
	@Query("select s from SimDetails s where s.simNumber=?1 and s.serviceNumber=?2")
	public SimDetails findBySimNumerAndServiceNumber(String simnumber,String servicenumber);
	@Transactional
	   @Modifying
	@Query(value = "update SimDetails set simStatus=?1 where simId=?2")
	public void updateSimStatus(String status,int simid);
	
}
