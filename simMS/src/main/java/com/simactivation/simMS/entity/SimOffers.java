package com.simactivation.simMS.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class SimOffers {
	@Id
	private int offerId;
	private int callQty;
	private int cost;
	private int dataQty;
	private int duration;
	private String  offerName;
	private int simid;
	public int getSimid() {
		return simid;
	}
	public void setSimid(int simid) {
		this.simid = simid;
	}
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public int getCallQty() {
		return callQty;
	}
	public void setCallQty(int callQty) {
		this.callQty = callQty;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getDataQty() {
		return dataQty;
	}
	public void setDataQty(int dataQty) {
		this.dataQty = dataQty;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	@Override
	public String toString() {
		return "SimOffers [offerId=" + offerId + ", callQty=" + callQty + ", cost=" + cost + ", dataQty=" + dataQty
				+ ", duration=" + duration + ", offerName=" + offerName + ", simid=" + simid + "]";
	}
	
}
