package com.nit.test;

import com.nit.comp.Car;
import com.nit.factory.CarFactory;

public class YouthCustomer2 {

	public static void main(String[] args) {
		//Get car object using factory
		Car car = CarFactory.createCar("sports", "MH47 UN 6025");
		car.drive();
		System.out.println("-------------------");
	}
}
