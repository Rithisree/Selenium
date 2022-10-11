package demoClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Selenium {
	WebDriver driver;
	
	
	@Test
	public void screenshot() throws IOException{
		 try {
			 System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe/");
			 driver = new ChromeDriver();
		     driver.manage().window().maximize();
		     driver.get("https://amazon.in/");
		     
		     TakesScreenshot scrShot =((TakesScreenshot)driver);
		     File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		     File DestFile=new File("D://CGI_CORE_TRAINING/test1.png");
		     FileUtils.copyFile(SrcFile, DestFile);
		 }
		 catch(IOException e) {
			 throw new IOException();
		 }
	}
	
	@Test
	public void scroll() {
		try {		
			System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe/");
			driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://amazon.in/");
			JavascriptExecutor exe = (JavascriptExecutor) driver;
			exe.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(2000);
			exe.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("//img[@alt=\"Amazon Brand - Presto! Dish Wash Gel - 2 L (Lemon)\"]"));
			exe.executeScript("arguments[0].scrollIntoView()",element);		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void mouseActions() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe/");
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://amazon.in/");
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//img[@alt=\"Amazon Brand - Presto! Dish Wash Gel - 2 L (Lemon)\"]"));
		action.click(element).build().perform();
		action.contextClick().build().perform();
	}
}



















