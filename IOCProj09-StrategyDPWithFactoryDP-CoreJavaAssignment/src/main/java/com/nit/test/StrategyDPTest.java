package com.nit.test;

import com.nit.comp.Vehicle;
import com.nit.factory.VehicleFactory;

public class StrategyDPTest {
	public static void main(String[] args) {
		try {
			//Get target class object from factory
			Vehicle v1 = VehicleFactory.createVehicle();
			
			//Invoke the business method
			String result = v1.journey(new String[] {"Sandwich","Coke","Chicken"});
			System.out.println(result);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
