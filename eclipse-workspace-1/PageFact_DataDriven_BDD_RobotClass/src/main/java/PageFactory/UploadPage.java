package PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;


public class UploadPage {


    WebDriver driver;

    By addFiles = By.cssSelector(".btn.btn-success.fileinput-button");

    By imageName = By.xpath("//*[@id='fileupload']/table/tbody/tr/td[2]/p");
    
   
    public UploadPage(WebDriver driver){

        this.driver = driver;

    }

    public void uploadFile(String fileName){

    	driver.findElement(addFiles).click();
    	
	     uploadFileWithRobotClass(fileName);

    }
    
    public void verifyUpload() throws InterruptedException
    {
    	   Thread.sleep(5000);
    	   assertThat(driver.findElement(By.xpath("//*[@id='fileupload']/table/tbody/tr/td[2]/p")).getText()).contains("car1.png");
    	   
    }

    public void uploadFileWithRobotClass (String fileName) {
    	String imagePath =  System.getProperty("user.dir") + "\\Files\\" + fileName;
	    StringSelection stringSelection = new StringSelection(imagePath);
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents(stringSelection, null);
	
	    Robot robot = null;
	
	    try {
	        robot = new Robot();
	    } catch (AWTException e) {
	        e.printStackTrace();
	    }
	
	    robot.delay(250);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.delay(150);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	}

  
}
    