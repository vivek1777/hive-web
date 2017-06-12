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
		//driver.manage().window().maximize();
		//driver.get("https://hivemicro.com");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement signout_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/header/div[2]/nav/button")));
		signout_link.click();
		
		WebElement log_in_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log In")));
		log_in_link.click();
		
		WebElement user_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		user_name.sendKeys("testqa+44@kiwi.qa");
		WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		pwd.sendKeys("kiwikiwi");
			try {
				WebElement login_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/input")));
				login_button.click();
			}
			catch (Exception e) {
				try {
					WebElement error_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath("/html/body/div/div/main/div/div[2]/div/form/div")));
					System.out.println("Login is failed in first atempt");
					pwd.clear();
					pwd.sendKeys("kiwikiwi");
					WebElement login_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/input")));
					login_button.click();
				} catch (Exception e1) {
					System.out.println("Login Successfully");
				}
			}
		
		
		
		Thread.sleep(10000);
		System.out.println("=======================================================================================================================================================================================");
		//driver.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
