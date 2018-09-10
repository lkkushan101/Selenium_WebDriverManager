package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver )
	{
		this.driver = driver;
	}
	
	  By user99GuruName = By.name("uid");

	  By password99Guru = By.name("password");

	  By titleText = By.className("barone");

	  By login = By.name("btnLogin");
	  
	   //Set user name in textbox

	    public void setUserName(String strUserName){

	     	$(user99GuruName).setValue(strUserName);      

	    }
	    
	    public void setPassword(String strUserName){

	     	$(password99Guru).setValue(strUserName);      

	    }
	    
	    public void clickLogin(){

	     	$(login).click();

	    }
	    
	    public void login(String userName, String Password)
	    {
	    	this.setUserName(userName);
	    	this.setPassword(Password);
	    	this.clickLogin();
	    }

}
