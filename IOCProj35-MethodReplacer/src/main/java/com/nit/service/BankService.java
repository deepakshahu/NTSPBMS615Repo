package com.nit.service;

public class BankService {
	
	public double calcInterestAmount(double pamt, double rate, double time) {
		//Calculate compound interest amount
		return (pamt*Math.pow(1+rate/100, time))-pamt;
	}
}