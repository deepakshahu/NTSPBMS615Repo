package com.nit.comp;

import java.util.Arrays;
import java.util.Random;

public final class Vehicle {

	//HAS-A property of type interface
	private Engine engine;

	public Vehicle() {
		System.out.println("Vehicle :: 0-param constructor");
	}

	//Setter method for setter injection
	public void setEngine(Engine engine) {
		System.out.println("Vehicle.setEngine()");
		this.engine = engine;
	}

	public String journey(String food[]) {

		//Generate engine id
		int eid=new Random().nextInt(10000);

		//Use engine for displaying engine id
		String status = engine.start(eid);
		String finalMsg = Arrays.toString(food)+"are food taken during journey";
		return finalMsg+" :: "+status;
	}//journey
}//class
