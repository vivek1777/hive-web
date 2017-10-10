package Customer_Web_App;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Customer_Login {
	
	public WebDriver driver;
	public Customer_Login(WebDriver driver1){		
		driver = driver1;
		
	}
	
	public void logIn() throws InterruptedException
	{
		driver.get("https://thehive.ai/");
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement login_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/div[2]/div/div[1]/div[1]/header/div/div/nav/div[2]/a[1]/button/span[1]")));
		Actions action = new Actions(driver);
		action.moveToElement(login_button).click().perform();
		
		WebElement email_text_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div/div/div[1]/form/div/div[1]/div/div/input")));
		email_text_field.sendKeys("testqa+91@kiwi.qa");
		
		WebElement pwd_text_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div/div/div[1]/form/div/div[2]/div/div/input")));
		pwd_text_field.sendKeys("kiwikiwi1");
		
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div/div/div[1]/form/div/div[3]/button/span[1]")));
		
		action.moveToElement(login).click().perform();
		
	}

}
