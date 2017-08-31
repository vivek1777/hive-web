package Moderator_Web_App;
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

public class Profile {
	public WebDriver driver;
	boolean flag_for_profile_update = false;
	boolean flag_for_paypal_update = false;
	boolean flag_for_password_update = false;

	public Profile(WebDriver driver1) {
		driver = driver1;
	}

	public void profile() {

		try 
		{
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			WebElement profile_page_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("/html/body/div/div/header/div[2]/nav/a[6]")));
			profile_page_link.click();
			
			Thread.sleep(2000);
			WebElement profile_full_name_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.id("fullname")));
			profile_full_name_field.sendKeys("12");;
			
			WebElement profile_update_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("/html/body/div/div/main/div/div[2]/div[1]/div/div/input")));
							
			profile_update_button.click();
			Thread.sleep(8000);
			
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("/html/body/div/div/main/div/div[2]/div[1]/div/form/div")));
//				driver.findElement(By.xpath("/html/body/div/div/main/div/div[2]/div[1]/div/form/div"));
				flag_for_profile_update =true;
				
			} catch (Exception e) {

			}
			
			WebElement paypal_first_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.id("first_name")));
			paypal_first_name.sendKeys("12");
			
			WebElement paypal_last_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.id("last_name")));
			paypal_last_name.sendKeys("engineer");
			
			Thread.sleep(5000);
			try{
			WebElement paypal_email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/main/div/div[2]/div[2]/div/form/fieldset[3]/input")));
																									
				paypal_email.sendKeys("vineet1777@yahoo.com");
			System.out.println("Entered  email");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
//			WebElement paypal_email = wait.until(ExpectedConditions.visibilityOfElementLocated(By
//					.id("email")));
//			paypal_email.sendKeys("vineet1777@yahoo.com");
			
			WebElement paypal_update_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("/html/body/div/div/main/div/div[2]/div[2]/div/div/input")));
			paypal_update_button.click();
			Thread.sleep(8000);
			
			try {
				driver.findElement(By.xpath("/html/body/div/div/main/div/div[2]/div[2]/div/form/div"));
				flag_for_paypal_update=true;
				
			} catch (Exception e) {

			}
			
			
			
			WebElement update_password_old_pwd_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.id("old_password")));
			update_password_old_pwd_field.sendKeys("kiwikiwi");
			
			WebElement update_password_new_pwd_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.id("new_password")));
			update_password_new_pwd_field.sendKeys("kiwikiwi1");
			
			WebElement update_password_confirm_pwd_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.id("confirm_password")));
			update_password_confirm_pwd_field.sendKeys("kiwikiwi1");
			
			WebElement password_update_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("/html/body/div/div/main/div/div[2]/div[3]/div/div/input")));
			password_update_button.click();
			Thread.sleep(5000);
			
			try {
				driver.findElement(By.xpath("/html/body/div/div/main/div/div[2]/div[3]/div/form/div"));
				flag_for_password_update=true;
				
			} catch (Exception e) {

			}
			
			if(flag_for_profile_update == true && flag_for_paypal_update == true && flag_for_password_update == true)
			{
				Network_Capturing.mod_mail_msg += "<tr>" +
						 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
						 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
						 "Verify if all details can be added and submitted successfully on Profile screen" + "</td>"
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
						 "Verify if all details can be added and submitted successfully on Profile screen" + "</td>"
						 + "<td align='center' color='white' bgcolor='#FDE2DC'>" +
						 "Fail" + "</td>";
						 Network_Capturing.mod_mail_msg += "</tr>";
						 Network_Capturing.var_for_report_counter++;
			}
			
			System.out.println("=======================================================================================================================================================================================");
			
			Thread.sleep(5000);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
