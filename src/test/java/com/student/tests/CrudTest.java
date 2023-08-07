package com.student.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;


@Story("This is our CRUD Testing story")
public class CrudTest extends TestBase{
	
	
	RequestFactory requests = new RequestFactory();
	
	@Story("This is our CRUD Testing story")
	@DisplayName("This is a test to Get All Students from DB")
	//@Feature("This is a test to Get All Students from DB")
	@Test
	public void GetAllStudents() {
		
		requests.GetAllStudents()
				.then()
				.spec(SpecificationFactory.getGenericResponseSpec())
				.statusCode(200);
		
		
}
	
	@Test
	@Story("This is our CRUD Testing story")
	@DisplayName("This is a test to Create & verify a new student")
	public void createNewStudent() {
		
		Faker fakeData = new Faker();		
		String firstName     = fakeData.name().firstName();
		String lastName      = fakeData.name().lastName();
		String email         = fakeData.internet().emailAddress();
		String programme     = "Physics";
		List<String> courses = new ArrayList<String>();
		courses.add("Astro Physics");
		courses.add("Quantum Physics");
		
		requests.createNewStudent("", firstName, lastName, email, programme, courses)
				.then()
				.spec(SpecificationFactory.getGenericResponseSpec())
				.statusCode(201);
		
	
	}
	
	
	
}