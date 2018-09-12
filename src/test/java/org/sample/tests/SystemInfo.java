/**
 * 
 */
package org.sample.tests;

import static io.restassured.RestAssured.given;

import org.sample.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
 import org.sample.ExtentReportListener.*;

/**
 * @author hasan
 *
 */
public class SystemInfo extends TestBase{
//	protected static final String URL = "http://localhost:9000/version";
//	protected static final String URL = url;

	@Test
	public void testAppVersion() {
		String URL = BASE_URL + "/health";
		System.out.println("URL is: " + URL);
		Response response = given().
		when().get(URL).then().
		extract().response();
		System.out.println("Content Type: " + response.contentType());
		response.then().assertThat().contentType("application/json");//ContentType.JSON);
		response.then().log().all();
		//ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " +URL);
		//ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: " );//+response.asString());

		//ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the Status Code Successfully !!");

	}

	@Test
	public void testAppHealth() {

		String VURL= BASE_URL + "/health";
		Response response = given().
							when().
								get(VURL).
							then().
								extract().response();
		Assert.assertEquals(response.getStatusCode(), 200,"");
		
	}
}
