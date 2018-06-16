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
	      = Unirest.put("https://reqres.in/api/users/100")
	      .header("accept", "application/json")
	      .field("name", "morpheus")
	      .field("job", "engineer")
	      .asJson();
	 
	    assertEquals(200, jsonResponse1.getStatus());
	    System.out.println(jsonResponse1.getBody());
	  
	}
}
