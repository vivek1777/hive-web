import java.io.File;
import java.io.IOException;

import net.lightbody.bmp.core.har.Har;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Signup {
	
	public WebDriver driver;
	static Random rand = new Random();
	static int  n = rand.nextInt(50) + 1;
	static int  n1 = rand.nextInt(50) + 1;
	public static String email = "testqa+"+n+n1+"@kiwi.qa";
	
	
	
	public Signup(WebDriver driver1){		
		driver = driver1;
	}
	public Signup(){		
		
	}
	
	
	
	
	
	public void signup() throws InterruptedException
	{	
		try{
		//driver.manage().window().maximize();
		driver.get("https://hivemicro.com");
		WebElement full_name_text_field;
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement signup_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/header/div[2]/nav/div/a")));
		signup_button.click();
		
		full_name_text_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
		full_name_text_field.sendKeys("tester"+n+"");
		
		
		WebElement email_of_user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		email_of_user.sendKeys(email);
		System.out.println(email);
		
		WebElement phone_number = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone_number")));
		phone_number.sendKeys("9582027416");
		
		WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address")));
		address.sendKeys("Castle");
		
		Select dropdown = new Select(driver.findElement(By.id("country")));
		 dropdown.selectByValue("IN");
		 
		 
		 WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		 password.sendKeys("kiwikiwi");
		
		WebElement confirm_password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm_password")));
		confirm_password.sendKeys("kiwikiwi");
		
		driver.findElement(By.id("legal-verification")).click();
		driver.findElement(By.id("age-verification")).click();
		
		WebElement signup_submit_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/div[3]/input")));
		signup_submit_button.click();
		
		Thread.sleep(5000);
		
		if(isElementPresentBylinkText("Skip")){
			WebElement skip_paypal_detail_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Skip")));
			skip_paypal_detail_button.click();
			Thread.sleep(10000);
		}
		
		//Thread.sleep(7000);
		
		//WebElement signout_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("headerButton")));
		//WebElement signout_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/header/div[2]/nav/button")));
//		WebElement signout_link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div[2]/nav/button")));
//		signout_link.click();
		System.out.println("=======================================================================================================================================================================================");
		
		Thread.sleep(10000);
		//driver.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	public Boolean isElementPresentBylinkText(String str)
	{
		try{
			WebDriverWait wait1 = new WebDriverWait(driver, 15);
			WebElement temp_element = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(str)));
			//driver.findElement(By.className(str));
		return true;
				
		}
		catch(Exception e)
		{
			return false;
		}
	}
	

}
