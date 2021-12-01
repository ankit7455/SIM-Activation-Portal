package com.simactivation.customerMS.dto;

public class SimDetailsDTO {
	private int simId;
	private Long serviceNumber;
	private Long simNumber;
	private String simStatus;
	
	public int getSimId() {
		return simId;
	}
	public void setSimId(int simId) {
		this.simId = simId;
	}
	public Long getServiceNumber() {
		return serviceNumber;
	}
	public void setServiceNumber(Long serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	public Long getSimNumber() {
		return simNumber;
	}
	public void setSimNumber(Long simNumber) {
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
}
