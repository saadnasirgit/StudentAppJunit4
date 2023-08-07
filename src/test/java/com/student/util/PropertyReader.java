package com.student.util;

import java.io.InputStream;
import java.util.Properties;



public class PropertyReader {
	
	private static volatile PropertyReader propinstance;    //member variable   //to avoid multi-threading issues added volatile keyword
	
	private PropertyReader() {      //private constructor
		
		
	}
	
	public static synchronized PropertyReader getInstance() {       //static method to get/retrieve instance of this class
		
		if(propinstance==null) {
			
		propinstance = new PropertyReader();
		
		return propinstance;
		
		}
		
		return propinstance;               //Singleton design pattern up-till here is completed
	}

	/**		
	 * @param propertyName
	 * @return
	 */
	
	
	public String getProperty(String propertyName){             //method to read property file & get us value
			
		Properties prop = new Properties();	
		
		try {
			
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
			
			prop.load(inputStream);			
			
			if(prop.getProperty(propertyName) != null) {  		//load property Object
				
				return prop.getProperty(propertyName);
				
			}
		}
		catch(Exception e){
			
			System.out.println("Property not found");
		}
		return null;
			}
	
}
