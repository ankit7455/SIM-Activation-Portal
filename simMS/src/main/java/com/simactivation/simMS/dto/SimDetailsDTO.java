package com.simactivation.simMS.dto;

import com.simactivation.simMS.entity.SimDetails;

public class SimDetailsDTO {
	
	private int simId;
	private String serviceNumber;
	private String simNumber;
	private String simStatus;
	
	public int getSimId() {
		return simId;
	}
	public void setSimId(int simId) {
		this.simId = simId;
	}
	public String getServiceNumber() {
		return serviceNumber;
	}
	public void setServiceNumber(String string) {
		this.serviceNumber = string;
	}
	public String getSimNumber() {
		return simNumber;
	}
	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}
	public String getSimStatus() {
		return simStatus;
	}
	public void setSimStatus(String simStatus) {
		this.simStatus = simStatus;
	}
	
	@Override
	public String toString() {
		return "SimDetails [simId=" + simId + ", serviceNumber=" + serviceNumber + ", simNumber=" + simNumber
				+ ", simStatus=" + simStatus + "]";
	}
	public static SimDetailsDTO valueOf(SimDetails plan) {

		SimDetailsDTO stDTO= new SimDetailsDTO();
		
		stDTO.setSimId(plan.getSimId());
		stDTO.setServiceNumber(plan.getSimNumber());
		stDTO.setSimNumber(plan.getSimNumber());
		stDTO.setSimStatus(plan.getSimStatus());
		return stDTO;
	}
}