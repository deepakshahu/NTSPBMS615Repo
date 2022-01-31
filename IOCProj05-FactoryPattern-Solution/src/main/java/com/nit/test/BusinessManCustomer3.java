package com.nit.test;

import com.nit.comp.Car;
import com.nit.factory.CarFactory;

public class BusinessManCustomer3 {

	public static void main(String[] args) {
		//Get car object using factory
		Car car = CarFactory.createCar("luxury", "MH47 DK 7741");
		car.drive();
		System.out.println("-------------------");
	}
}