package com.nit.comp;

public class LuxuryCar extends Car {
	
	private String regNo;
	public LuxuryCar(String regNo) {
		System.out.println("LuxuryCar :: 1-param constructor");
		this.regNo=regNo;
	}

	@Override
	public void drive() {
		System.out.println("Driving Luxury Car :: "+regNo);
	}
}
