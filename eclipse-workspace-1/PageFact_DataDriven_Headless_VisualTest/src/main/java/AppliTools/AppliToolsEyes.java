package AppliTools;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.WebDriver;
public class AppliToolsEyes {
	 Eyes eyes = new Eyes();

	public void setAPIKey (String apiKey)
	
	{
		eyes.setApiKey(apiKey);
	}
	public void startTest (WebDriver driver, String testName, String testTitle)
	{
		
		eyes.open(driver,testName,testTitle,
                new RectangleSize(800, 600));
	}
	
	public void setCheckPointWindow(String checkPointName)
	{
		 eyes.checkWindow(checkPointName);
	}
	
	public void closeEyes()
	{
		eyes.close();
	}
	
}
