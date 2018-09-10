package stepdefs;



import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import Pages.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;

import com.codeborne.selenide.WebDriverRunner;

import ExcelRead.ExcelRead;
public class StepDefs {
	WebDriver driver;
	ExcelRead excel = new ExcelRead();
	LoginPage loginPage = new LoginPage(driver);
	@Given("^I have a user name and password$")
	public void i_have_a_user_name_and_password() throws Exception {
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverRunner.setWebDriver(driver);
		open(excel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1"));
	 
	}

	@When("^I successfully login$")
	public void i_successfully_login() throws Exception {
	  loginPage.login(excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"), excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"));
	 
	}

	@Then("^I should be able to go to home page$")
	public void i_should_be_able_to_go_to_home_page() throws Exception {
		HomePage objHomePage = new HomePage(driver);
		assertThat(objHomePage.getHomePageDashboardUserName().toLowerCase()).isEqualTo("manger id : mgr123");
		close();
	}


}
