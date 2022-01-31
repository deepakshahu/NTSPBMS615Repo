package com.nit.beans;

public abstract class Cricketer {
	
	//No HAS-A property of dependent class
	
	public Cricketer() {
		System.out.println("Cricketer :: 0-param constructor :: "+this.getClass());
	}
	
	public void bowling() {
		System.out.println("Cricketer is bowling");
	}
	
	public abstract Bat createBat();  //This method will be implemented in the InMemory proxy class 
	                                  //of this class having Dependency Lookup logic
	
	public void batting() {
		System.out.println("Cricketer is batting");
		
		//Get Dependent class object
		Bat bat = createBat();
		
		//Invoke Methods
		int score = bat.scoreRuns();
		System.out.println("Cricketer batting score is : "+score);
	}
	
	public void fielding() {
		System.out.println("Cricketer is fielding");
	}
	
	public void wicketKeeping() {
		System.out.println("Cricketer is wicketKeeping");
	}
}//class