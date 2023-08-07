package com.student.requests;

import java.util.List;

import com.student.pojo.StudentPojo;
import com.student.tests.TestBase;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * RequestFactory Class to create methods that are reusable in code
 */


public class RequestFactory extends TestBase{                     
	
	RestClient restClient = new RestClient();
	
	@Step("Getting all the students information from the DB")
	public Response GetAllStudents() {
		
		Response response = restClient.doGetRequest("/list");
		   
		return response;
	
	}
	
	
	@Step("Creating A New Student : (0) , {1} , {2} , {3} , {4}")
	public Response createNewStudent(String url, String firstName, String lastName, String email, String programme, List<String> courses) {
		
		StudentPojo body = new StudentPojo();
		body.setFirstName(firstName);
		body.setLastName(lastName);
		body.setEmail(email);
		body.setCourses(courses);
		body.setProgramme(programme);
		
				
		return restClient.doPostRequest(url, body);
		
	}
	
	@Step("Deleting studnet information")
	public Response deleteStudent(int studentId) {
		
		return restClient.doDeleteRequest("/" + studentId);
		
		 		
	}

	@Step("Updating Student information with studentId: {0}, firstName: {1},lastName: {2},email: {3},courses: {4},programme:")
	public Response updateStudent(int studentId, String firstName, String lastName, String email, String programme, List<String> courses) {
		
		StudentPojo student = new StudentPojo();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setCourses(courses);
		student.setProgramme(programme);
		
				
		return restClient.doPostRequest("/" +studentId, student);
		
	}
	
	
}
