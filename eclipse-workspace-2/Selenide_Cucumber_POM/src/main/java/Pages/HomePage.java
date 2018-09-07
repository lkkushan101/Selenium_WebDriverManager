package Pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver )
	{
		this.driver = driver;
	}
	
	  By homePageUserName = By.xpath("//table//tr[@class='heading3']");
	    

	  //Get the User name from Home Page

      public String getHomePageDashboardUserName(){

       return 	$(homePageUserName).getText();    

       

      }

}
