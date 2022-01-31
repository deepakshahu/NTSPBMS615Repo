package com.nit.comp;

public class CNGEngine implements Engine {

	public CNGEngine() {
		System.out.println("CNGEngine :: 0-param constructor");
	}

	@Override
	public String start(int eid) {
		return eid+" engine id is started with CNG Engine";
	}
}
