package UniRESTJava;
import static org.testng.Assert.*;
import org.testng.annotations.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
public class UNIRestClassLogin {
	@Test
	public void shouldReturnStatusOkay() throws UnirestException {
	    HttpResponse<JsonNode> jsonResponse1 
	      = Unirest.post("https://reqres.in/api/register")
	      .header("accept", "application/json")
	      .field("email", "kushan@lk.lk")
	      .field("password", "kushan")
	  
	      .asJson();
	 
	    assertEquals(201, jsonResponse1.getStatus());
	    System.out.println(jsonResponse1.getBody());
	  
	}
}
