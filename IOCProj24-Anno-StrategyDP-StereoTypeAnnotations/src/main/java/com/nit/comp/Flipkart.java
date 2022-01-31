package com.nit.comp;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("fpkt")
public final class Flipkart {
	//HAS-A property of type interface
	@Autowired
	//@Qualifier("dtdc")  //hardcoding of dependent bean id is bad practise
	//@Qualifier(@Value("${choose.courier}"))  //will not work bcoz @Qualifier does not allow @Value
	//@Value("${choose.courier}")
	//private String cid;
	//@Qualifier(cid)  //we cannot pass bean id as the variable name
	@Qualifier("logistic")
	private Courier courier;
	
	public Flipkart() {
		System.out.println("Flipkart :: 0-param constructor");
	}
	
	public String shopping(String items[], float prices[]) {
		
		System.out.println(courier);
		
		//Calculate bill amount
		float billAmt=0.0f;
		for(int i=0;i<items.length;i++)
			billAmt=billAmt+prices[i];
		
		//Generate order id
		int oid=new Random().nextInt(10000);
		
		//Use courier for shipping
		String status = courier.deliver(oid);
		String finalMsg = Arrays.toString(items)+"are purchased with prices"+Arrays.toString(prices)+". The generated bill amount is ::"+billAmt;
		return finalMsg+" :: "+status;
	}
}//class
