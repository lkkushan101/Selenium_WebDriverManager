package stepdefs;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.NgWebDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import ExtentReport.ExtentReport;
import PageFactory.*;
import ReadExcel.ExcelRead;
import Utilities.BrowserStart;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class CreateCompany {
	    WebDriver driver;
        String gridStatus, gridIP;
	    //Login objLogin;
        
    	static NgWebDriver ngdriver;
    	
	    HomePage objHomePage;
	 
	    ExtentReport extRpt = new ExtentReport();
	    ExcelRead excel = new ExcelRead();
	    Logger log = Logger.getLogger("devpinoyLogger");
	   
	    BrowserStart bwStart = new BrowserStart();
	
	    @Given("^When I'm in the add company page$")
	    public void when_I_m_in_the_add_company_page() throws Throwable {
		 try {
		   System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		   System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
	       
		   
		   
		   String browserMode = excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1");
		    if (browserMode.equals("Chrome-Headless"))
		    {
		    	String gridStatus = excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1");
		    	
		    	if (gridStatus.equals("Yes"))
		    	{
		    		driver = bwStart.startGridChormeHeadless(driver);
		    		
		    	}
		    	else
		    	{
				    driver = bwStart.startChromeHeadless(driver);
		    	}
		    }
		    else if (browserMode.equals("Chrome"))
		    {
		    	String gridStatus = excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1");
		    	
		    	if (gridStatus.equals("Yes"))
		    	{
		    	     driver = bwStart.startGridChorme(driver);
		    	   
		    	}
		    	else
		    	{
		    	   driver = bwStart.startChrome(driver);
		    	   ngdriver = new NgWebDriver((JavascriptExecutor) driver);
		    	}
		    }
		    else if (browserMode.equals("Firefox"))
		    {
		    	String gridStatus = excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1");
		    	
		    	if (gridStatus.equals("Yes"))
		    	{
		    	    driver = bwStart.startGridFireFox(driver);
		    	   
		    	}
		    	else
		    	{
		    	  driver = bwStart.startFireFox(driver);
		    	}
		    }
		    else if (browserMode.equals("Firefox-Headless"))
		    {
		    
			   String gridStatus = excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1");
		    	
		    	if (gridStatus.equals("Yes"))
		    	{
		    	      driver = bwStart.startGridFireFoxHeadless(driver);
		    	   
		    	}
		    	else
		    	{
			         driver = bwStart.startFireFoxHeadless(driver);
		    	}
		    }
		    
		    

	        driver.get(excel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1"));
	        log.debug("Navigating to Login Page");
	        extRpt.setUpReport();
		 }
		 catch (NoSuchElementException e)
		 {
			 log.error("Element was not found");
			    extRpt.logFail("Element was not found");
		 }
	  
	}
	    @When("^I add \"([^\"]*)\" as the name \"([^\"]*)\" as the headoffice and \"([^\"]*)\" as employees$")
	    public void i_add_as_the_name_as_the_headoffice_and_as_employees(String name, String headoffice, String employees) throws Throwable  {
	     try {
		   extRpt.startTestCase("Adding Company");
	
		   objHomePage = new HomePage(driver);
          
		    objHomePage.addCompany(name, headoffice, employees);
		   
		   
			  
		    extRpt.logEvents("Added Company Successfully");
	     }
	     catch (NoSuchElementException e)
	     {
	    	  
	     }

	   
	}
	
	    @Then("^the record should get added$")
	    public void the_record_should_get_added() throws Throwable {
		
		try {
		
	      if (objHomePage.newCompanyAdded())
	      {
	    	  log.debug("Company created"); 
	    	  extRpt.logEvents("Company created");
	      }
	      
		    driver.close();
		    extRpt.createFinalReport();
		    log.debug("Creating final report");
		}
		catch (NoSuchElementException e)
		{
			 log.error("Element was not found");
			 extRpt.logFail("Element was not found");
		}
	
	}

}
