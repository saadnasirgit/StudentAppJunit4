package com.student.requests;

import com.student.specs.SpecificationFactory;
import com.student.tests.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestClient extends TestBase{       //RestClient Class to remove duplication &  easy to maintain

/**
 *   This method encapsulates Get requests & acts as a Wrapper
 */

	public Response doGetRequest(String requestPath) {
		
		
		return given()
				.when()
				.get(requestPath);
		
		 
	}
	
	
	public Response doPostRequest(String uri, Object body) {
		
		return given()
			   .contentType(ContentType.JSON)
			   .spec(SpecificationFactory.logPayloadResponseInfo())
			   .when()
			   .body(body)
			   .post(uri);
			   
		 
	}
	
	public Response doDeleteRequest(String res) {
		
		return given()
			   .when()
			   .delete(res);
	}
	
	public Response doPutRequest(String res, Object body) {
		
		return given()
				.when()
				.body(body)
				.put(res);
		
	}
	
}
