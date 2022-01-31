package com.nit.factory;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

import com.nit.comp.Courier;
import com.nit.comp.Flipkart;

public class FlipkartFactory {

	private static Properties props;
	static {
		System.out.println("FlipkartFactory :: Static BLock");
		try(
				//Load Properties file
				FileInputStream fis = new FileInputStream("src/main/java/com/nit/commons/info.properties")){
			//Load Properties file content to java.util.Properties class object
			props = new Properties();
			props.load(fis);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Flipkart createFlipkart() throws Exception {

		//Create target class object
		Flipkart fpkt = new Flipkart();;

		//Load dependent class
		Class c = Class.forName(props.getProperty("dependent.comp"));
		
		//Create object using reflection API
		Constructor cons[]=c.getDeclaredConstructors();
		
		//Create object
		Courier courier = (Courier) cons[0].newInstance();

		//Set dependent class object to target class object
		fpkt.setCourier(courier);
		return fpkt;
	}
}
