/**
 * 
 */
package org.sample.testbase;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
/**
 * @author hasan
 *
 */


public class TestBase {

	protected static String BASE_URL;//= "http://localhost:9000";

	protected static void setUrl(String str) {
		BASE_URL = str;
	}
	
	public RequestSpecification REQUEST;
	@BeforeClass
	@Parameters({ "url" ,"port"})
	public void setUp(String url, String port) {
		setUrl(url + ":"+ port);
	}
	@BeforeMethod
	public void drawLine() {
		System.out.println("**************************************************");
	};
	
	
	@AfterMethod()
	public void drawLineAfterTest(){
		System.out.println("\n\n\n**************************************************");
	}

}
