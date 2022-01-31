package com.nit.factory;

import com.nit.comp.BudgetCar;
import com.nit.comp.Car;
import com.nit.comp.LuxuryCar;
import com.nit.comp.SportsCar;

public class CarFactory {
	
	//Factory having factory pattern logic
	//(logic to create and return one of the several related classes object)
	public static Car createCar(String type, String regNo) {
		if(type.equalsIgnoreCase("sports"))
			return new SportsCar(regNo);
		else if(type.equalsIgnoreCase("budget"))
			return new BudgetCar(regNo);
		else if(type.equalsIgnoreCase("luxury"))
			return new LuxuryCar(regNo);
		else
			throw new IllegalArgumentException("Invalid Car Type");
	}
}
