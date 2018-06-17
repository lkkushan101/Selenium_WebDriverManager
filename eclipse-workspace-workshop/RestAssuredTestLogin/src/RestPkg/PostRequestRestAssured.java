package RestPkg;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class PostRequestRestAssured {
	@Test
	public void PostDetails()
	{   
		
		RestAssured.baseURI = "https://reqres.in/api/register";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		httpRequest.header("Content-Type", "application/json");
		requestParams.put("email", "sydney@fife"); // Cast
		requestParams.put("password", "pistol");
	
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.post();
	 
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		System.out.println(response.body().asString());
		
	}
}
