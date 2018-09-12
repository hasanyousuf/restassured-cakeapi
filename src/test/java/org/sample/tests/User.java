/**
 * 
 */
package org.sample.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.describedAs;
import static org.hamcrest.Matchers.is;

import org.sample.testbase.TestBase;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @author hasan
 *
 */
public class User extends TestBase {

	private static String UU = "test9";

	/*
	 * User Signup
	 * Use Post Method
	 */
	@Test(priority = 0)
	public void newUsersSignUp() {
		String URL = BASE_URL + "/users/signup";
		System.out.println("URL is: " + URL);
		Response response = given().
								queryParam("username", "test11").
								queryParam("name", "test").
								queryParam("password", "password").
							when().post(URL);
		given().request().log().all();
		response.
			then().
			assertThat().
				statusCode(201).log().all().
			assertThat().
				contentType(ContentType.JSON);
		
	}
	/*
	 * User Signup
	 * Use Post Method
	 */
	@Test(priority = 2)
	public void existingUsersSignUp() {
		String URL = BASE_URL + "/users/signup";
		System.out.println("URL is: " + URL);
		String UU = "test9";
		Response response = given().
				queryParam("username", UU).
				queryParam("name", UU).
				queryParam("password", UU).
		        contentType("application/x-www-form-urlencoded").
        when().
        	post(URL);
		response.then().log().ifStatusCodeIsEqualTo(400);
		response.then().assertThat().statusCode(describedAs("Expecting 400",is(400)));
		
	}
	
	/*
	 * User Login
	 * Use Post Method
	 */
	@Test(priority = 2)
	public void validUsersLogin() {
		String URL = BASE_URL + "/users/login";
		Response response = given().
				queryParam("username", UU).
				queryParam("name", UU).
				queryParam("password", UU).
							when().post(URL);
		response.
			then().log().ifError().
				assertThat().
					statusCode(200).
				assertThat().
					contentType(ContentType.JSON);
				
		response.then().
				log().all();
	}
	
	/*
	 * User Login
	 * Use Post Method
	 */
	@Test(priority = 3)
	public void invalidUsersLogin() {
		String URL = BASE_URL + "/users/login";
		Response response = given().
				queryParam("username", "test31").
				queryParam("password", "password").
							when().post(URL);
		response.
			then().log().ifError().
				assertThat().
					statusCode(200).
				assertThat().header("content-length", "4");
		response.then().
				extract().response().body().toString().contains("null");
	}
	
}
