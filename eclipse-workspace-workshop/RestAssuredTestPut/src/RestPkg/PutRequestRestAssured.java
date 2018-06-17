package RestPkg;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class PutRequestRestAssured {
	@Test
	public void PostDetails()
	{   
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Kushan"); // Cast
		requestParams.put("job", "QA Manager");
	

		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.put("/100");
	 
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
}
