package com.nit.factory;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

import com.nit.comp.Engine;
import com.nit.comp.Vehicle;

public class VehicleFactory {

	private static Properties props;
	static {
		System.out.println("VehicleFactory :: Static BLock");
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

	public static Vehicle createVehicle() throws Exception {

		//Create target class object
		Vehicle v1 = new Vehicle();;

		//Load dependent class
		Class c = Class.forName(props.getProperty("dependent.comp"));
		
		//Create object using reflection API
		Constructor cons[]=c.getDeclaredConstructors();
		
		//Create object
		Engine engine = (Engine) cons[0].newInstance();

		//Set dependent class object to target class object
		v1.setEngine(engine);
		return v1;
	}
}
