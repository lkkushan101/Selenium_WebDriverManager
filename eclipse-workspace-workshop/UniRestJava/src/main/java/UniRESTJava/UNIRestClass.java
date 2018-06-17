package UniRESTJava;
import static org.testng.Assert.*;
import org.testng.annotations.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.log4j.Logger;
public class UNIRestClass {
	
	 Logger log = Logger.getLogger("devpinoyLogger");
@Test
	public void shouldReturnStatusOkay() throws UnirestException {
	    HttpResponse<JsonNode> jsonResponse1 
	      = Unirest.get("http://restapi.demoqa.com/utilities/weather/city/Pune")
	      .header("accept", "application/json")
	      .asJson();
	 
	    assertEquals(200, jsonResponse1.getStatus());
	    log.info(jsonResponse1.getBody());
	    log.info(jsonResponse1.getStatus());
	    log.info(jsonResponse1.getStatusText());
	    log.info(jsonResponse1.getHeaders());
	}
}
