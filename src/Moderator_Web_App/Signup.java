package Moderator_Web_App;
import java.io.File;
import java.io.IOException;

import net.lightbody.bmp.core.har.Har;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Signup {
	
	public WebDriver driver;
	static Random rand = new Random();
	static int  n = rand.nextInt(50) + 1;
	static int  n1 = rand.nextInt(50) + 1;
	public static String email = "testqa+"+1+n+n1+"@kiwi.qa";
	
	
	
	public Signup(WebDriver driver1){		
		driver = driver1;
	}
	
	public void signup() throws InterruptedException
	{	
		try{
		//driver.manage().window().maximize();
		driver.get("https://hivemicro.com");
		WebElement full_name_text_field;
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
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
		
		try{
			WebElement ToS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/div[1]/label/p")));
			Actions action = new Actions(driver);
			action.moveToElement(ToS).click().perform();
			Thread.sleep(2000);
			WebElement agree_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div/button/span[1]")));
			Actions action1 = new Actions(driver);
			action1.moveToElement(agree_button).click().perform();
			Thread.sleep(2000);
		
		}catch(Exception e)
		{
			System.out.println("legal-verificatio or age-verification is not clickable");
		}
		
		WebElement signup_submit_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/input")));
		signup_submit_button.click();
		Thread.sleep(5000);
		
		try{
			driver.findElement(By.xpath("/html/body/div/div/main/div/div[2]/div/form/fieldset[2]/div"));
			 int  n3 = rand.nextInt(50) + 1;
			 int  n4 = rand.nextInt(50) + 1;
			 String email_new = "testqa+"+n+n1+"@kiwi.qa";
			 email_of_user.sendKeys(email_new);
				System.out.println(email_new);
				WebElement signup_submit_button_new = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/div[3]/input")));
				signup_submit_button_new.click();
				Thread.sleep(5000);
			
		}
		catch(Exception e3)
		{
			System.out.println("given email worked successfully.");
		}
		
		
		Thread.sleep(5000);
		
		while(true)
		{
				try {
					WebElement skip_paypal_detail_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
							.linkText("Skip")));
					skip_paypal_detail_button.click();
					break;
				} catch (Exception e) {
					System.out.println("Skip button of payemnt page after signup is not found");
				}
		}
		

		System.out.println("=======================================================================================================================================================================================");
		
		//Thread.sleep(10000);
		//driver.close();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("/html/body/div/div/header/div[2]/nav/a[6]")).isDisplayed()){
		Network_Capturing.mod_mail_msg += "<tr>" +
				 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
				 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
				 "User is able to sign up successfully on Customer Portal." + "</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Pass" + "</td>";
				 Network_Capturing.mod_mail_msg += "</tr>";
				 Network_Capturing.var_for_report_counter++;
		}
		else
		{
			Network_Capturing.mod_mail_msg += "<tr>" +
					 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
					 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
					 "User is able to sign up successfully on Customer Portal." + "</td>"
					 + "<td align='center' color='white' bgcolor='#FDE2DC'>" +
					 "Fail" + "</td>";
					 Network_Capturing.mod_mail_msg += "</tr>";
					 Network_Capturing.var_for_report_counter++;
		}
		
		Thread.sleep(5000);
		//FOr All apply button appearing test case
		List<WebElement> number_of_apply_link = driver.findElements(By.linkText("Apply"));
		List<WebElement> number_of_rows = driver.findElements(By.tagName("tr"));
		if((number_of_rows.size()-1) == number_of_apply_link.size())
		{
			Network_Capturing.mod_mail_msg += "<tr>" +
					 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
					 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
					 "New User can see All Jobs status as 'Apply' on Feature and General Jobs Screen" + "</td>"
					 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
					 "Pass" + "</td>";
					 Network_Capturing.mod_mail_msg += "</tr>";
					 Network_Capturing.var_for_report_counter++;
		}
		else
		{
			Network_Capturing.mod_mail_msg += "<tr>" +
					 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
					 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
					 "New User can see All Jobs status as 'Apply' on Feature and General Jobs Screen" + "</td>"
					 + "<td align='center' color='white' bgcolor='#FDE2DC'>" +
					 "Fail" + "</td>";
					 Network_Capturing.mod_mail_msg += "</tr>";
					 Network_Capturing.var_for_report_counter++;
			
		}
		
		}
		catch(Exception e)
		{
			Network_Capturing.mod_mail_msg += "<tr>" +
					 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
					 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
					 "User is able to sign up successfully on Customer Portal." + "</td>"
					 + "<td align='center' color='white' bgcolor='#FDE2DC'>" +
					 "Fail" + "</td>";
					 Network_Capturing.mod_mail_msg += "</tr>";
					 Network_Capturing.var_for_report_counter++;
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
