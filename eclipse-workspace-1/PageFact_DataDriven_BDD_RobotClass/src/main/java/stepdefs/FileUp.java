package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageFactory.UploadPage;

import static org.assertj.core.api.Assertions.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
public class FileUp {
	    WebDriver driver;
	    public WebDriverWait wait;
	    UploadPage uPage ;
	
	
	@Given("^I have gone to the file upload site$")
	public void i_have_gone_to_the_file_upload_site() throws Throwable {
		 System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
	     driver = new ChromeDriver();
        
		 driver.get("https://blueimp.github.io/jQuery-File-Upload/");
	     uPage = new UploadPage(driver);
	}

	@When("^I click add file and select the file$")
	public void i_click_add_file_and_select_the_file() throws Throwable {
	//	 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.fileinput-button")));
	    uPage.uploadFile("car1.png");
	   
	}

	@Then("^I the file shuld get uploaded successfully$")
	public void i_the_file_shuld_get_uploaded_successfully() throws Throwable {
	uPage.verifyUpload();
	driver.close();
	}
	
	
}
