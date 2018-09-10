package stepdefs;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import ExtentReport.ExtentReport;
import PageObject.*;
import ReadExcel.ExcelRead;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class LoginScenario {
	    WebDriver driver;
	  
	    Login objLogin;

	    HomePage objHomePage;
	    NewCustomer newCustomer;
	    ExtentReport extRpt = new ExtentReport();
	    ExcelRead excel = new ExcelRead();
	    Logger log = Logger.getLogger("devpinoyLogger");
	    
@Given("^I have a user name and password$")
public void i_have_a_user_name_and_password() throws Throwable {
	 System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
     driver = new ChromeDriver();

     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     driver.get(excel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1"));
     log.debug("Navigating to Login Page");
     extRpt.setUpReport();
    
     
       
}

@When("^I successfully login and fill forms to create a customer$")
public void i_successfully_login_and_fill_forms_to_create_a_customer() throws Throwable {
	   extRpt.startTestCase("User Login");
	   objLogin = new Login(driver);
	   newCustomer = new NewCustomer(driver);
	    //Verify login page title
     
	    String loginPageTitle = objLogin.getLoginTitle();
	  
	    objLogin.loginToGuru99(excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"), excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"));
	   log.debug("Entered the user name and password");
	   //assertThat(objHomePage.getHomePageDashboardUserName().toLowerCase()).isEqualTo("manger id : mgr123");//login to application
	   extRpt.logEvents("Logged Successfully");
	  newCustomer.navigateNewCustomer(driver);
    
}

@Then("^I should be able to create a new customer$")
public void i_should_be_able_to_create_a_new_customer() throws Throwable {
	 newCustomer.createNewCustomer();
	   
   
}
}
