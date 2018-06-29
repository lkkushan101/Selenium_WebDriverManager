package stepdefs;

import org.json.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssureBDD {
	JSONObject requestParams;
	RequestSpecification httpRequest;
	@Given("^I have a URL for post request$")
	public void i_have_a_URL_for_post_request() throws Exception {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		 httpRequest = RestAssured.given();
	  	
	}

	@When("^I send a request with the parameters$")
	public void i_send_a_request_with_the_parameters() throws Exception {
		requestParams = new JSONObject();
		requestParams.put("FirstName", "Kushan"); // Cast
		requestParams.put("LastName", "Amarasiri");
		requestParams.put("UserName", "test123");
		requestParams.put("Password", "password1");
	 
		requestParams.put("Email",  "tester101@gmail.com");
		httpRequest.body(requestParams.toString());
		Response response = httpRequest.post("/register");

	}

	@Then("^I should get a success response with a body$")
	public void i_should_get_a_success_response_with_a_body() throws Exception {
	    
	 
	}

}
