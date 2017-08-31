package Moderator_Web_App;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Stats {
	
	public WebDriver driver;

	public Stats(WebDriver driver1) {
		driver = driver1;
	}
	
	public void statsStic() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			WebElement stats_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Stats")));
			stats_link.click();
			Thread.sleep(7000);
			
			
			WebElement drop_down = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/div[1]/div/div[2]/div/div/span[1]/div[1]")));
			Actions action = new Actions(driver);
			action.moveToElement(drop_down).click();
			
//			Thread.sleep(5000);
			
			//WebElement first_option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Select-value-label")));
			//drop_down.click();
			//Select-value-label
			 //dropdown1.selectByValue("Earnings");
			 //Thread.sleep(5000);
			 //dropdown1.selectByValue("Accuracy");
			 //Thread.sleep(5000);
			
			
			//Select-arrow class of drop-down

		}
		catch(Exception e){
			 Thread.sleep(5000);
		
		}
		
	}

}
