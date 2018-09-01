package PageFactory;

import org.openqa.selenium.By;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By name1 = ByAngular.model("name");
    By employees1 = ByAngular.model("employees");
    By headoffice1 = ByAngular.model("headoffice");
    By button1 = By.xpath("//input[@value='Submit']");
    By newCompany = By.xpath("/html/body/div/div[6]/table/tbody/tr/td[1]/table/tbody/tr[6]/td[1]");    
    
    
    public HomePage(WebDriver driver){

        this.driver = driver;

    }

    

    //Get the User name from Home Page

        public void addCompany(String name, String headoffice, String employees ) throws InterruptedException{

         driver.findElement(name1).sendKeys(name);
         driver.findElement(employees1).sendKeys(headoffice);
         driver.findElement(headoffice1).sendKeys(employees);
         driver.findElement(button1).click();
         Thread.sleep(3000);
         
        }
        
        public boolean newCompanyAdded ()
        {
          return driver.findElement(newCompany).isDisplayed();
        }
        
        
       

}