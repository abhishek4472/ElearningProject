package hooks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class hooksClass {
	 public static	WebDriver driver;

	  
	  @Before
		public void init()
		{
			System.setProperty("webdriver.chrome.driver", ".//lib//chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://elearningm1.upskills.in/");
			driver.findElement(By.name("login")).sendKeys("abhi");
			driver.findElement(By.name("password")).sendKeys("abhishek");
			driver.findElement(By.name("submitAuth")).click();
			driver.findElement(By.xpath("//a[text()='Social network']")).click();
			driver.findElement(By.xpath("//img[@title='Messages']")).click();
			System.out.println("webdriver is initialized");
			
		}
		
		
		@After
		public void quit()
		{
			driver.quit();
			System.out.println("driver is closed");
		}

}
