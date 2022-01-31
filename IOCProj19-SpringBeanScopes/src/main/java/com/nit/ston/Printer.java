//Printer.java(Singleton java class with mininum standards)
package com.nit.ston;

public class Printer {
	//Static variable to hold reference of the single object	
	private static Printer INSTANCE;
	
	private Printer() {
		System.out.println("Printer :: 0-param constructor(private)");
	}
	
	//static factory method
	public static Printer getInstance() {
		//Singleton logic
		if(INSTANCE==null)
			INSTANCE=new Printer();
		return INSTANCE;
	}
	
	//Business Method
	public void Print(String msg) {
		System.out.println(msg);
	}
}//class
