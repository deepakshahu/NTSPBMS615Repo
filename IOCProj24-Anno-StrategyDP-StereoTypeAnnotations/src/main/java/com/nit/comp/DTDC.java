package com.nit.comp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("dtdc")
//@Component("courier")
//@Primary
@PropertySource("com/nit/commons/info.properties")
public final class DTDC implements Courier {
	
	@Value("${per.name}")
	private String name;
	@Value("${per.age}")
	private int age;
	@Value("${os.name}")
	private String os;
	@Value("${Path}")
	private String path;
	
	public DTDC() {
		System.out.println("DTDC :: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return oid+" order id order is delivered by DTDC";
	}

	@Override
	public String toString() {
		return "DTDC [name=" + name + ", age=" + age + ", os=" + os + ", path=" + path + "]";
	}
}