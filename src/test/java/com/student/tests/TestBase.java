package com.student.tests;

import org.junit.BeforeClass;

import com.student.util.PropertyReader;

import io.restassured.RestAssured;

public class TestBase {
	
	
	public static PropertyReader prop;          //Initialize static variable of Property Reader Class
	
	@BeforeClass
	public static void initUrl() {
		
		prop = PropertyReader.getInstance();
		
		RestAssured.baseURI= prop.getProperty("baseUrl");
		RestAssured.port= Integer.valueOf(prop.getProperty("port"));
		
	}

}
