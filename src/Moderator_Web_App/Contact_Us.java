package Moderator_Web_App;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Contact_Us {
	public WebDriver driver;
	
	public Contact_Us(WebDriver driver1){		
		driver = driver1;
	}
	// This is my first commit
	// This change will be reflect only after my commit
	public void contactUs() throws InterruptedException
	{
		try{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement contact_us_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact Us")));
		contact_us_link.click();
		
		WebElement contact_us_name_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		contact_us_name_field.sendKeys("tester 44");
		
		WebElement contact_us_email_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		contact_us_email_field.sendKeys("testqa+44@kiwi.qa");
		
		WebElement contact_us_message_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text")));
		contact_us_message_field.sendKeys("testing message");
		
		WebElement contact_us_submit_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/div/div[1]/input")));
		contact_us_submit_button.click();
		
		Thread.sleep(10000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Thread.sleep(5000);
		}
		
	}
}
