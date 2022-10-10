package demoClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectOptions {
	WebDriver driver;
	
	@Test
	public void select() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe/");
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    driver.get("https://www.makemytrip.com/flights");
	    
        Thread.sleep(2000);
        WebElement select = driver.findElement(By.xpath("//label[@for='fromCity']"));
        select.click();
        
        String searchText = "Mumbai, India";
        Thread.sleep(2000);
        
	    List<WebElement> options = select.findElements(By.xpath("//li[@role='option']"));
	    Thread.sleep(2000);
	    
	    for(WebElement element:options) {
	      if(element.getText().contains(searchText)) {
	        element.click();
	        break;
	      } 
	    }
	}
}
