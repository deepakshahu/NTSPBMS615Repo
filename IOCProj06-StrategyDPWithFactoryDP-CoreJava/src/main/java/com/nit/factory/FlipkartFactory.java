package com.nit.factory;

import com.nit.comp.BlueDart;
import com.nit.comp.Courier;
import com.nit.comp.DTDC;
import com.nit.comp.Flipkart;

public class FlipkartFactory {
	
	public static Flipkart createFlipkart(String courierType) {
		//Create target class object
		Flipkart fpkt = new Flipkart();
		Courier courier = null;
		
		//Create Dependent class object based on given courier type
		if(courierType.equalsIgnoreCase("dtdc"))
			courier = new DTDC();
		else if(courierType.equalsIgnoreCase("bdart"))
			courier = new BlueDart();
		else
			throw new IllegalArgumentException("Invalid courier type");
		
		//Set dependent class object to target class object
		fpkt.setCourier(courier);
		
		return fpkt;
	}
}
