package com.nit.beans;

import java.util.Random;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("bat")
@Lazy(value = true)
public class Bat {
	
	public Bat() {
		System.out.println("Bat :: 0-param constructor");
	}

	public int scoreRuns() {
		System.out.println("Bat :: scoreRuns()");
		return new Random().nextInt(130);
	}
}