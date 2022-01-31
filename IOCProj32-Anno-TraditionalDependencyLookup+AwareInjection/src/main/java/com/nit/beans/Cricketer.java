package com.nit.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("cktr")
//@Lazy(true)
public class Cricketer implements ApplicationContextAware{
	
	//No HAS-A property of dependent class
	
	private ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("Cricketer.setApplicationContext()");
		this.ctx=ctx;		
	}
	
	public Cricketer() {
		System.out.println("Cricketer :: 0-param constructor");
	}
	
	public void bowling() {
		System.out.println("Cricketer is bowling");
	}
	
	public void batting() {
		System.out.println("Cricketer is batting");
		
		//Perform dependency lookup method to get dependent class object
		Bat bat = ctx.getBean("bat",Bat.class);  //DL code
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