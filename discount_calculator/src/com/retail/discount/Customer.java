package com.retail.discount;

public class Customer {
	
	private String type;
	private int noOfYears;
	private Bill bill;
	
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNoOfYears() {
		return noOfYears;
	}
	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}

}
