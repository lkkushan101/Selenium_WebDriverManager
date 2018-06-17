package UniRESTJava;
import static org.testng.Assert.*;

import java.io.IOException;

import org.testng.annotations.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
public class UNIRestClass {
	@Test
	public void shouldReturnStatusOkay() throws UnirestException, IOException {
		ExcelRead excelFile = new ExcelRead();
	    HttpResponse<JsonNode> jsonResponse1 
	      = Unirest.post(excelFile.readExcel(1,0,"C:\\data.xlsx","Sheet1"))
	      .header("accept", "application/json")
	      .field("FirstName", excelFile.readExcel(1,1,"C:\\data.xlsx","Sheet1"))
	      .field("LastName", excelFile.readExcel(1,2,"C:\\data.xlsx","Sheet1"))
	      .field("UserName", excelFile.readExcel(1,3,"C:\\data.xlsx","Sheet1"))
	      .field("Password", excelFile.readExcel(1,4,"C:\\data.xlsx","Sheet1"))
	      .field("Email",  excelFile.readExcel(1,5,"C:\\data.xlsx","Sheet1"))
	      .asJson();
	 
	    assertEquals(200, jsonResponse1.getStatus());
	    System.out.println(jsonResponse1.getBody());
	  
	}
}
