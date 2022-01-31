package com.nit.test;

import java.lang.reflect.Constructor;

public class NewInstanceMethodTest1 {
	
	public static void main(String[] args) throws Exception {
		//Load Classes
		Class c1 = Class.forName(args[0]);
		
		//Get all constructors of loaded class
		Constructor cons[] = c1.getDeclaredConstructors();
		
		//Dynamic object creation using 0-param constructor
		cons[0].setAccessible(true);  //give access to private constructor
		Object obj1 = cons[0].newInstance();
		System.out.println(obj1);
		System.out.println("-------------------");
		
		//Dynamic object creation using 0-param constructor
		cons[1].setAccessible(true);  //give access to private constructor
		Object obj2 = cons[1].newInstance(100,"India");
		System.out.println(obj2);
		System.out.println("-------------------");
	}//main
}//class