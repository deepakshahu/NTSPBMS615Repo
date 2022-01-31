package com.nit.test;

import com.nit.comp.Flipkart;
import com.nit.factory.FlipkartFactory;

public class StrategyDPTest {
	public static void main(String[] args) {
		try {
			//Get target class object from factory
			Flipkart fpkt = FlipkartFactory.createFlipkart();
			
			//Invoke the business method
			String result = fpkt.shopping(new String[] {"Shirt","Trouser","Mobile"}, new float[] {3400.0f, 5600.0f, 60000.0f});
			System.out.println(result);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
