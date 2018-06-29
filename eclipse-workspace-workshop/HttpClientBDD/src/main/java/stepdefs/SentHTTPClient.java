package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;


public class SentHTTPClient {

	HttpClient client = new DefaultHttpClient();
	HttpGet request;
	HttpResponse response;
@Given("^I have a URL for Get request$")
public void i_have_a_URL_for_Get_request() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	request = new HttpGet("http://restapi.demoqa.com/utilities/weather/city/Pune");
	
	
    
}

@When("^I send a GET request$")
public void i_send_a_GET_request() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	response = client.execute(request);

}

@Then("^I should get a success response with a body$")
public void i_should_get_a_success_response_with_a_body() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	BufferedReader rd = new BufferedReader
		    (new InputStreamReader(
		    response.getEntity().getContent()));

		 String line = "";
	     while ((line = rd.readLine()) != null) {
	         System.out.println(line);

}

}
}
