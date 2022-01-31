package com.nit.comp;

public class PetrolEngine implements Engine {
	
	public PetrolEngine() {
		System.out.println("PetrolEngine :: 0-param constructor");
	}

	@Override
	public String start(int eid) {
		return eid+" engine id is started with Petrol Engine";
	}
}
