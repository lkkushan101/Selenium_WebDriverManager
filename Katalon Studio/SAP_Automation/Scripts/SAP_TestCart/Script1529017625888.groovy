import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('https://sapui5.hana.ondemand.com/test-resources/sap/m/demokit/cart/webapp/index.html')

WebUI.waitForPageLoad(10000)

WebUI.sendKeys(findTestObject('SAP_Objects/Search_Input'), 'Phone')

WebUI.waitForElementPresent(findTestObject('SAP_Objects/Item'), 20000)

WebUI.click(findTestObject('SAP_Objects/Item'))

WebUI.waitForElementPresent(findTestObject('SAP_Objects/Cart_Icon'), 30000)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SAP_Objects/Cart_Icon'))

WebUI.click(findTestObject('SAP_Objects/ViewCart'))

WebUI.verifyElementPresent(findTestObject('SAP_Objects/List_Item'), 10)

