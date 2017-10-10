package Moderator_Web_App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Leaderboard {
	
	public WebDriver driver;
	public Leaderboard(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickLeaderboardLink()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 40);
			WebElement leaderboard_link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Leaderboard")));
			leaderboard_link.click();
			
			WebElement last_day = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/main/div/div[2]/div/div/div[1]/button[1]/div/span")));
			Actions action = new Actions(driver);
			action.moveToElement(last_day).click();
			
			Thread.sleep(4000);
			WebElement all_time = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/main/div/div[2]/div/div/div[1]/button[3]/div/span")));
			action.moveToElement(all_time).click();
			
		}
		catch(Exception e)
		{
			System.out.println("Last day or all-time button is not clicked");
		}
	}

}
