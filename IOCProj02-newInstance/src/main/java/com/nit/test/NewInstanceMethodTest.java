package com.nit.test;

public class NewInstanceMethodTest {
	
	public static void main(String[] args) throws Exception {
		//Load Classes
		Class c1 = Class.forName(args[0]);
		Class c2 = Class.forName(args[1]);
		
		//Create the objects of Loaded Classes
		Object obj1 = c1.newInstance();
		Object obj2 = c2.newInstance();
		
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
	}//main
}//class