package Moderator_Web_App;
import java.io.File;
import java.io.IOException;

import net.lightbody.bmp.core.har.Har;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login {
	
	public WebDriver driver;
	
	public Login(WebDriver driver1){
		driver = driver1;
	}
	
	
	public void login() throws InterruptedException
	{	
		try{
		//driver.get("https://hivemicro.com");
		
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try{
		driver.findElement(By.xpath("/html/body/div/div/header/div[2]/nav/button")).click();
		
		 Network_Capturing.mod_mail_msg += "<tr>" +
				 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
				 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
				 "Verify if user can sign out of account successfully." + "</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Pass" + "</td>";
				 Network_Capturing.mod_mail_msg += "</tr>";
				 Network_Capturing.var_for_report_counter++;
		
		}catch(Exception e)
		{
			System.out.println("signout link not found");
			Network_Capturing.mod_mail_msg += "<tr>" +
					 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
					 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
					 "Verify if user can sign out of account successfully." + "</td>"
					 + "<td align='center' color='white' bgcolor='#FDE2DC'>" +
					 "Fail" + "</td>";
					 Network_Capturing.mod_mail_msg += "</tr>";
					 Network_Capturing.var_for_report_counter++;
		}
		
		WebElement log_in_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log In")));
		log_in_link.click();
		
		WebElement user_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		user_name.sendKeys("testqa+44@kiwi.qa");
		WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		pwd.sendKeys("kiwikiwi1");
			try {
				WebElement login_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/input")));
				login_button.click();
				
				try {
					WebElement error_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath("/html/body/div/div/main/div/div[2]/div/form/div")));
					System.out.println("Login is failed in first atempt");
					pwd.clear();
					pwd.sendKeys("kiwikiwi");
//					WebElement login_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
//							.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/input")));
					login_button.click();
				} catch (Exception e1) {
					System.out.println("Login Successfully");
				}
				
				
				
				
			}
			catch (Exception e) {
				
			}
		
		
			Thread.sleep(7000);
			if(driver.findElement(By.xpath("/html/body/div/div/header/div[2]/nav/a[6]")).isDisplayed()){
				Network_Capturing.mod_mail_msg += "<tr>" +
						 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
						 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
						 "User is able to log in successfully on moderator portal." + "</td>"
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
							 "User is able to log in successfully on moderator portal." + "</td>"
							 + "<td align='center' color='white' bgcolor='#FDE2DC'>" +
							 "Fail" + "</td>";
							 Network_Capturing.mod_mail_msg += "</tr>";
							 Network_Capturing.var_for_report_counter++;
				}
		
		Thread.sleep(10000);
		System.out.println("=======================================================================================================================================================================================");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
