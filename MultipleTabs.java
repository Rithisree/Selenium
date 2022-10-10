package demoClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleTabs {
private WebDriver driver;
	
	@Test
	public void multipleTabs() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe/");
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    driver.get("https://amazon.in");
     
	    String parent = driver.getWindowHandle();
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags", Keys.ENTER);
	    driver.findElement(By.xpath("//span[contains(text(),'uppercase Medium 23 Ltrs Tall Boy (14.6 inch) Laptop Backpack 2500EBP1 3x more water repellent sustainable bags with rain proof zippers for Men, Women, Boys and Girls')]")).click();
	    
	    Set <String> tabs = driver.getWindowHandles();
	    
	    for(String child : tabs) {
	      if(!child.equalsIgnoreCase(parent)) {
	    	  driver.switchTo().window(child);
	          Thread.sleep(3000);
	          driver.switchTo().window(parent);
	      }
	    }
	}
}
