package com.nit.comp;

public class DieselEngine implements Engine {

	public DieselEngine() {
		System.out.println("DieselEngine :: 0-param constructor");
	}

	@Override
	public String start(int eid) {
		return eid+" engine id is started with Diesel Engine";
	}	
}
