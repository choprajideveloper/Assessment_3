
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Rest_Call {
	
	static Logger log= Logger.getLogger(Rest_Call.class);
	
	@Test
	public void Rest_Get()
	{
		RequestSpecification httpRequest = RestAssured.given(); 
		Response response = httpRequest.request(Method.GET, "https://reqres.in/api/users?page=2");
		int statuscode = response.getStatusCode();
		log.info("Status Code is"+statuscode);
		Assert.assertEquals(200, statuscode);	 
	}


	@Test
	public void Rest_Post()
	{
		String data = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\",\r\n"
				+ "    \"email\": \"deepakchopraji@gmail.com\"\r\n"
				+ "}";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content_Type", "application/JSON");
		Response res = httpRequest.body(data).post("https://reqres.in/api/users");
		int responseCode = res.getStatusCode();
		log.info("Status Code is"+responseCode);
		Assert.assertEquals(201,responseCode);
		}
}
