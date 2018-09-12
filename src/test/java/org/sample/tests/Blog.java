package org.sample.tests;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.sample.testbase.TestBase;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Blog extends TestBase {

	/*
	 * Use post method
	 * 1. /blog/new
	 */ 
	
	@Test
	public void testCreateNewBlog() {
		String URL = BASE_URL + "/blog/new";
		System.out.println("URL is: " + URL);
		Response response = given().
	            contentType("application/x-www-form-urlencoded").
	            queryParam("author", "hasan").
	            queryParam("title", "First post").
	            queryParam("body", "A quick brown fox jumps over the lazy dog.").
							when().post(URL);
		//given().request().log().all();
		response.then().log().all();
		response.
			then().
			assertThat().
				statusCode(201).log().all().
			assertThat().
				contentType(ContentType.JSON);
	}
	
	/*
	 * Create Post Use Post method
	 * 2. /blog
	 */
@Test
	public void testListOfAllBlogPosts() {
		String URL = BASE_URL + "/blog/new";
		System.out.println("URL is: " + URL);
		Response response = given().
	            param("page", "0").
	            param("limit", "44").
							when().get(URL);
		given().request().log().all();
		response.
			then().
			assertThat().
				statusCode(200).log().all().
			assertThat().
				contentType(ContentType.JSON);
	}

	/*
	 * All post Use Get method
	 * 3. /blog/{username}
	 */

	@Test
	public void testBlogByUsername() {
		
		JSONObject jsonObj = new JSONObject()
                .put("username","1")
                .put("page","test")
                .put("limit","3");
		
		String URL = BASE_URL + "/blog";
		Response response = given()
								/*pathParam("username", "hasan").
								queryParam("page", "1").
								queryParam("limit", "3").*/
								.body(jsonObj).
							when().get(URL + "/{username}/");
		System.out.println("");
		response.then().statusCode(200);
		response.then().contentType(ContentType.JSON).extract().response();
	}

	/*
	 * Show Post Use Get Method
	 * 4. /blog/{username}/{postId} Show post
	 */
	@Test
	public void testBlogUsernamePostId() {
		String URL = BASE_URL + "/blog";
		Response response = given().
								pathParam("username", "hasan").
								pathParam("postId", "1").
							when().get(URL + "/{username}/{postId}/");
		System.out.println("");
		response.then().statusCode(200);
		response.then().contentType(ContentType.JSON).extract().response();
	}

	/*
	 * Edit post Use Post Method
	 * 5. /blog/{username}/{postId} Edit Post
	 */
	@Test
	public void testBlogUsernamePostIdEdit() {
		String URL = BASE_URL + "/blog";
		Response response = given().
								pathParam("username", "hasan").
								pathParam("postId", "1").
								queryParam("title", "First post").
								queryParam("body", "A quick brown fox jumps over the lazy dog").
							when().post(URL + "/{username}/{postId}/");
		System.out.println("");
		response.then().statusCode(201);
		response.then().contentType(ContentType.JSON).extract().response();
	}

	/*
	 * Delete Post Use Post Method
	 * 6. /blog/{username}/{postId}/delete Delete Post
	 */
	@Test
	public void testBlogUsernamePostIdDelete() {
		String URL = BASE_URL + "/blog";
		Response response = given().
								pathParam("username", "hasan").
								pathParam("postId", "7").
								when().post(URL + "/{username}/{postId}/delete");
		System.out.println("");
		response.then().statusCode(201);
		response.then().contentType(ContentType.JSON).extract().response();
	}
}
