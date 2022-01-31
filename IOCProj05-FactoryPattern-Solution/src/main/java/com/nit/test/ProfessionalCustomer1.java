package com.nit.test;

import com.nit.comp.Car;
import com.nit.factory.CarFactory;

public class ProfessionalCustomer1 {

	public static void main(String[] args) {
		//Get car object using factory
		Car car = CarFactory.createCar("budget", "MH47 UJ 7854");
		car.drive();
		System.out.println("-------------------");
	}
}
