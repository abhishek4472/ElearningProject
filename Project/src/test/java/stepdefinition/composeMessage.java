
package stepdefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.asserts.SoftAssert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.hooksClass;
import junit.framework.Assert;

public class composeMessage {
	
	WebDriver driver=hooksClass.driver;
	
	@Given("click on messages tab")
	public void click_on_messages_tab() {
				
		
		driver.findElement(By.xpath("//img[@title='Compose message']")).click();
		
	
	}


	@When("enter valid data username {string} and subject{string}")
	public void enter_valid_data_username_and_subject(String username, String subject) throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("abc");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='"+username+"']")).click();
		driver.findElement(By.name("title")).sendKeys(subject);
		
		
	}

	@When("click on send message")
	public void click_on_send_message() {
		driver.findElement(By.name("compose")).click();
	    
	}

	@Then("verify the message username {string}")
	public void verify_the_message_username(String username) {
		  String expected="The message has been sent to "+username;

			String actual=driver.findElement(By.xpath("//div[contains(text(),' The message has been sent ')]")).getText();
			
			SoftAssert soft=new SoftAssert();
			soft.assertEquals(actual, expected);
			System.out.println("The test is completed");
			soft.assertAll();
			
	    
	}
	
	@When("enter invalid data username {string} and subject{string}")
	public void enter_invalid_data_username_and_subject(String username, String subject) throws InterruptedException {
	
		driver.findElement(By.name("title")).sendKeys(subject);
		
	}

	@Then("verify the output message")
	public void verify_the_output_message() {
		 String expected="There was an error while trying to send the message.";

			String actual=driver.findElement(By.xpath("//div[text()=' There was an error while trying to send the message.']")).getText();
			
			SoftAssert soft=new SoftAssert();
			soft.assertEquals(actual, expected);
			System.out.println("The test is completed");
			soft.assertAll();
		
	    
	}
	
	@When("enter valid data username")
	public void enter_valid_data_username() throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("abc");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Anamika Anamika']")).click();
	    
	}

	@Then("verify the error message")
	public void verify_the_error_message() {
		
		 String expected="required field";

			String actual=driver.findElement(By.xpath("//div[text()=' required field']")).getText();
			
			SoftAssert soft=new SoftAssert();
			soft.assertEquals(actual, expected);
			System.out.println("The test is completed");
			soft.assertAll();
		
	   
	}
	

@Given("click on outboxs")
public void click_on_outboxs() {
	driver.findElement(By.xpath("//img[@title='Outbox']")).click();
   
}
	

@When("click on delete message")
public void click_on_delete_message() {
   driver.findElement(By.xpath("//img[@title='Delete message']")).click();
}

@When("select the alert")
public void select_the_alert() {
	Alert obj= driver.switchTo().alert();
	obj.accept();
}

@Then("check for validation message")
public void check_for_validation_message() {
	 
	 
	 String expected="The selected messages have been deleted \nBack to outbox";
    String actual=driver.findElement(By.xpath("//div[contains(text(),'The selected messages ')]")).getText();	
    System.out.println(actual);
	 Assert.assertEquals(expected, actual);
	 System.out.println("The test is completed");
   
}


@When("select any given message")
public void select_any_given_message() throws InterruptedException {
    driver.findElement(By.xpath("//div//tbody//tr/td[1]")).click();
    Thread.sleep(3000);
}

@Then("check if the message is selected")
public void check_if_the_message_is_selected() {
  boolean actual=driver.findElement(By.xpath("//div//tbody//tr[2]/td[1]")).isEnabled();
  boolean expected=true;
  Assert.assertEquals(expected, actual);
  System.out.println("The test is completed");
}


@When("open a message using title title {string}")
public void open_a_message_using_title_title(String subject) throws InterruptedException {
    driver.findElement(By.xpath("//div//tbody//tr/td[2]//a[text()='"+subject+"']")).click();
    Thread.sleep(2000);
}

@Then("check if message is opened")
public void check_if_message_is_opened() {
  String expected="abhishek bahukhandi";
  String actual=driver.findElement(By.xpath("//a[text()='abhishek bahukhandi']")).getText();
  Assert.assertEquals(expected, actual);
  System.out.println("The test is completed");
}



@When("click on search and enter values value {string}")
public void click_on_search_and_enter_values_value(String word) {
    driver.findElement(By.name("keyword")).sendKeys(word);
    
}


@When("click on search button")
public void click_on_search_button() {
    driver.findElement(By.name("submit")).click();
}

@Then("check if message are avilable value{string}")
public void check_if_message_are_avilable_value(String word) {
	       String expected=word;
		    String actual=driver.findElement(By.xpath("//div//tbody//tr//td[2]//a[text()='"+word+"']")).getText();
          Assert.assertEquals(expected, actual);
          System.out.println("The test is completed");
          
}





}
