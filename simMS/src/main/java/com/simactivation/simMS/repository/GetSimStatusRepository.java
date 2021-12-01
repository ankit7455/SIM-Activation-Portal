package com.simactivation.simMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simactivation.simMS.entity.SimDetails;
@Repository
public interface GetSimStatusRepository extends JpaRepository<SimDetails, Integer>{
	
	public SimDetails findBySimId(int simid);
}
