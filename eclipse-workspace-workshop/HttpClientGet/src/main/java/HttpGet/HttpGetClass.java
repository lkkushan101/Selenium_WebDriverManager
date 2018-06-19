package HttpGet;

import org.testng.annotations.Test;

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

public class HttpGetClass {
	
@Test
public void getRequest() throws URISyntaxException, UnsupportedOperationException, IOException
{
	
	HttpClient client = new DefaultHttpClient();
	HttpGet request = new HttpGet("http://restapi.demoqa.com/utilities/weather/city/Pune");
	HttpResponse response = client.execute(request);

	// Get the response
	BufferedReader rd = new BufferedReader
	    (new InputStreamReader(
	    response.getEntity().getContent()));

	 String line = "";
     while ((line = rd.readLine()) != null) {
         System.out.println(line);
      
	}
	
  }
}
