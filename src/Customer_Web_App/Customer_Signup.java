package Customer_Web_App;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Moderator_Web_App.Network_Capturing;


public class Customer_Signup {
	
	public WebDriver driver;
	static Random rand = new Random();
	static int  n = rand.nextInt(50) + 1;
	static int  n1 = rand.nextInt(50) + 1;
	public static String global_email = "testqa+"+n+n1+"@kiwi.qa";
	
	public Customer_Signup(WebDriver driver1){		
		driver = driver1;
	}
	
	public void signup() throws InterruptedException
	{
		driver.get("https://thehive.ai");
		
		
		
		Thread.sleep(10000);
		SoftAssert softAssert = new SoftAssert();
		try{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement signup_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[1]/header/div/div/nav/div[2]/a[2]/button/span[1]")));
		Actions actions = new Actions(driver);
		actions.moveToElement(signup_button).click().perform();
		
		//signup_button.click();
		
		WebElement name_text_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
		name_text_field.sendKeys("Tester");
		
		WebElement email_text_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		email_text_field.sendKeys(global_email);
		
		WebElement password_text_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password_text_field.sendKeys("kiwikiwi");
		
		WebElement submit_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/div/div[1]/form/div/div[7]/button")));
		submit_button.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 50);
		WebElement title_after_signu = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/h1")));
		title_after_signu.getText();
		
		softAssert.assertEquals("title_after_signu.getText()", "My Project");
		
		if(title_after_signu.getText().equalsIgnoreCase("My Projects"))
		    {
				Network_Capturing.cust_mail_msg += "<tr>" + "<td align='center'  color='white' bgcolor='#e5ede3'>" + 1
						+ "</td>" + "<td align='center' color='white' bgcolor='#e5ede3'>" + "Sign-Up" + "</td>"
						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + "Pass" + "</td>";
				Network_Capturing.cust_mail_msg += "</tr>";
			}
		
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
	}

}
