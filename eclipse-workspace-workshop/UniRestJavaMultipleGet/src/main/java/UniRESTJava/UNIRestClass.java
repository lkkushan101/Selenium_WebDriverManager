package UniRESTJava;
import static org.testng.Assert.*;
import org.testng.annotations.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
public class UNIRestClass {
	@Test
	public void shouldReturnStatusOkay() throws UnirestException {
	    HttpResponse<JsonNode> jsonResponse1 
	      = Unirest.get("https://reqres.in//api/users?page=2")
	      .header("accept", "application/json")
	      .asJson();
	 
	    assertEquals(200, jsonResponse1.getStatus());
	    
	      
	    verifyValue(jsonResponse1.getBody().toString(), "Holt");
	    verifyValue(jsonResponse1.getBody().toString(), "Morris");
	}
	public void verifyValue(String body, String expected)
	{
		if (body.indexOf(expected)>0)
		{
			System.out.println("Found the value :" + expected);
		}
		else
		{
			System.out.println("Did not find the value :" + expected);
		}
		
		
	}
}
 