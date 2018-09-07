package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

public class NewCustomer {
	
	WebDriver driver;
	Fairy fairy = Fairy.create();
	
	  By cutomerName = By.name("name");
	  By male = By.name("rad1");
	  By dob = By.name("dob");
	  By address = By.name("addr");
	  By city = By.name("city");
	  By state = By.name("state");
	  By pinno = By.name("pinno");
	  By telephoneno = By.name("telephoneno");
	  By password = By.name("password");
	  By createCustomerButton = By.name("sub");
	  By email = By.name("emailid");
    public NewCustomer(WebDriver driver){

        this.driver = driver;

      
    }
    
    public void createNewCustomer()
    {
    	Person person = fairy.person();
    	
    	driver.findElement(cutomerName).sendKeys(person.getFirstName() + person.getLastName());
    	driver.findElement(male).click();
    	driver.findElement(dob).sendKeys("12/12/1980");
    	driver.findElement(address).sendKeys(person.getAddress().toString());
    	driver.findElement(city).sendKeys(person.getAddress().getCity().toString());
    	driver.findElement(state).sendKeys(person.getAddress().getStreet());
    	driver.findElement(pinno).sendKeys("123456");
    	driver.findElement(telephoneno).sendKeys("123355666");
    	driver.findElement(email).sendKeys(person.getEmail().toString());
    	driver.findElement(password).sendKeys(person.getPassword().toString());
    	driver.findElement(createCustomerButton).click();
  
    }
    
    public void navigateNewCustomer(WebDriver driver)
    {
    	driver.navigate().to("https://demo.guru99.com/v4/manager/addcustomerpage.php");
    }
    

}
