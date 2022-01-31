package com.nit.bo;

public class CustomerBO {

	//bean properties
	private Integer custNo;  //optional for insert use case
	private String custName;
	private String custAddress;
	private Float pamt;
	private Float rate;
	private Float time;
	private Float interestAmount;
	
	//Getters and Setters (Alt+Shift+S,R)
	public Integer getCustNo() {
		return custNo;
	}
	public void setCustNo(Integer custNo) {
		this.custNo = custNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public Float getPamt() {
		return pamt;
	}
	public void setPamt(Float pamt) {
		this.pamt = pamt;
	}
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	public Float getTime() {
		return time;
	}
	public void setTime(Float time) {
		this.time = time;
	}
	public Float getInterestAmount() {
		return interestAmount;
	}
	public void setInterestAmount(Float interestAmount) {
		this.interestAmount = interestAmount;
	}
}