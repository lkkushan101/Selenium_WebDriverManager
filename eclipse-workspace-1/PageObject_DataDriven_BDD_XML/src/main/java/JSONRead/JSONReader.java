package JSONRead;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	
	JSONParser parser = new JSONParser(); 
	public String jsonRead(String filePath, String tagName) throws FileNotFoundException, IOException, ParseException
	{
		 
		 Object obj = parser.parse(new FileReader(filePath));

	      JSONObject jsonObject = (JSONObject) obj;
	       return (String) jsonObject.get(tagName);
	      
	}
	

}
