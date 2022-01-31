package com.nit.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class CalcInterestAmountReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("CalcInterestAmountReplacer.reimplement() (Simple Interest)");
		
		//Get target method argument values
		double pamt=(double)args[0];
		double rate=(double)args[1];
		double time=(double)args[2];
		
		//Write new logic to execute(Simple Interest Amount)
		return pamt*rate*time/100;
	}
}