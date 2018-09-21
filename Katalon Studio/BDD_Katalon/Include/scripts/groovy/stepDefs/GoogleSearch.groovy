package stepDefs

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import internal.GlobalVariable

public class GoogleSearch {

	@Given("I im in the google search")
	public void i_im_in_the_google_search() {
		WebUI.openBrowser("http://www.google.lk")
	}

	@When("I type selenium and click search")
	public void i_type_selenium_and_click_search() {
		WebUI.setText(findTestObject('Object Repository/SearchInput'), 'Selenium')
		WebUI.click(findTestObject('Object Repository/GoogleImage'))
		WebUI.click(findTestObject('Object Repository/SearchButton'))
	}

	@Then("I should be navigated to the Selenium - Web Browser Automation")
	public void i_should_be_navigated_to_the_Selenium_Web_Browser_Automation() {
		WebUI.click(findTestObject('Object Repository/Link'))
		WebUI.waitForPageLoad(5)
		WebUI.verifyElementPresent(findTestObject('SeleniumLogo'),30)
	}
}
