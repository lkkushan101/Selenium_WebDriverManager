package SeleniumBasics;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class SearchGoogle {
	
	WebDriver driver;
	String url = "http://unec.edu.az/application/uploads/2014/12/pdf-sample.pdf";
@BeforeTest
	public void setup()
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}

@Test

	public void verifyPDF()
	{
			 verifyPDFContent(url, "Document");
	
	}

public void verifyPDFContent(String strURL, String reqTextInPDF) {
	
	
	
	String text ="";
	try {
		URL url = new URL(strURL);
		BufferedInputStream  file = new BufferedInputStream(url.openStream());
		
		PDDocument doc = PDDocument.load(file);
		text = new PDFTextStripper().getText(doc);
		
		System.out.println(text);
		
		
		
	} catch (MalformedURLException e2) {
		System.err.println("URL string could not be parsed "+e2.getMessage());
		
	} catch (IOException e) {
		System.err.println("Unable to open PDF Parser. " + e.getMessage());
		
		}
	
     if (text.contains(reqTextInPDF))
     {
    	System.out.println("Text found in PDF");
     }
	}

@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
