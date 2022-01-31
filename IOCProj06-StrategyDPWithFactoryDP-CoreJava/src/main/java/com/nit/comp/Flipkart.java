package com.nit.comp;

import java.util.Arrays;
import java.util.Random;

public final class Flipkart {
	//HAS-A property of type interface
	private Courier courier;
	
	public Flipkart() {
		System.out.println("Flipkart :: 0-param constructor");
	}

	//Setter Method for setter injection
	public void setCourier(Courier courier) {
		System.out.println("Flipkart.setCourier()");
		this.courier = courier;
	}
	
	public String shopping(String items[], float prices[]) {
		
		//Calculate bill amount
		float billAmt=0.0f;
		for(int i=0;i<items.length;i++){
			billAmt=billAmt+prices[i];
		}
		
		//Generate order id
		int oid=new Random().nextInt(10000);
		
		//Use courier for shipping
		String status = courier.deliver(oid);
		String finalMsg = Arrays.toString(items)+"are purchased with prices"+Arrays.toString(prices)+". The generated bill amount is ::"+billAmt;
		return finalMsg+" :: "+status;
	}
}//class
