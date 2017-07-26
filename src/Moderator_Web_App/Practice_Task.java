package Moderator_Web_App;
import java.awt.List;
import java.io.File;
import java.io.IOException;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.core.har.Har;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Practice_Task {
	
public WebDriver driver;
//public BrowserMobProxyServer server;
	
	
	
	public Practice_Task(WebDriver driver1,BrowserMobProxyServer server1 ){		
		driver = driver1;
		//server = server1;
	}
	
	public void practiceTaskCompletion() throws InterruptedException
	{
		try{
			
			//server.newHar("experiment6.har");
			//driver.get("https://hivemicro.com");
			System.out.println("Going to start practice task completion");
			
			WebDriverWait wait = new WebDriverWait(driver, 80);
			
			
			Thread.sleep(5000);
		
			WebDriverWait wait_new = new WebDriverWait(driver, 5);
				try {
					WebElement skip_paypal_detail_button = wait_new.until(ExpectedConditions.visibilityOfElementLocated(By
							.linkText("Skip")));
					skip_paypal_detail_button.click();
			} catch (Exception e) {
				System.out.println("Skip button of paypal is not found in this flow");
			}
			

			System.out.println("Going to click on Apply button on my owner's wish");
			int counter=1;
			boolean flag=true;
			while(true){
			try{
			if(driver.findElement(By.xpath("/html/body/div/div/main/div/div[2]/div/table/thead/tr/th[1]")).isDisplayed()){
	
				while (true) {
					
					WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/table/tbody/tr[" + counter + "]/td[1]")));
					
					if (element.getText().equalsIgnoreCase("NSFW Images")) {
						flag=false;
						
						break;
						
					}
					counter++;
				}
						
			}}catch(Exception e)
			{
				
			}
			if(flag == false)
			{
				break;
			}
			}
			
			WebElement apply_link_job_page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/table/tbody/tr["+counter+"]/td[4]/a")));
			System.out.println(apply_link_job_page.getText());
			apply_link_job_page.click();															
			Thread.sleep(2000);
			
			
			
			
			WebElement apply_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/div/div[4]/button")));
			apply_button.click();
			Thread.sleep(3000);
			int count_for_jobs_api_call = 0;
			
			for(int i=0;i<100;i++)
			{
				Thread.sleep(1000);
				try{
					
					WebElement random_second_button = wait
							.until(ExpectedConditions.elementToBeClickable(By
									.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[2]")));
					random_second_button.click();
					
					}catch(Exception e)
					{
						System.out.println("Category button is not clakable");
					}
				try {
					
					String string_of_pop_up = driver.findElement(By.className("_2H7ucOUfSIUH-Bpg6wzhzt")).getText()
							.substring(35);
					WebElement cross_of_pop_up = wait
							.until(ExpectedConditions.elementToBeClickable(By
									.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/button")));
					cross_of_pop_up.click();
					// /html/body/div[2]/div/div[2]/div/div/div[1]/button
					String refined_string = string_of_pop_up.replace(".", "");
					String double_refined_string = refined_string.replace("\"", "");

					System.out.println(string_of_pop_up);
					System.out.println(double_refined_string);
					int counter2 = 1;
					while (true) {
						WebElement string_of_button = wait
								.until(ExpectedConditions.elementToBeClickable(By
										.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button["+ counter2 + "]")));
						System.out.println("button test is "+ string_of_button.getText());
						System.out.println("button test is "+ string_of_button.getAttribute("value"));
						if (string_of_button.getText().contains(double_refined_string)) {
							string_of_button.click();
							count_for_jobs_api_call++;
							if(count_for_jobs_api_call == 50)
							{
								//server.newHar("experiment6.har");
							}
							
							Thread.sleep(3000);
							break;
						}
						counter2++;
					}
				} catch (Exception e1) {
					//e1.printStackTrace();
				}
				Thread.sleep(1000);
				try{
					WebElement back_to_job = driver.findElement(By.linkText("Back to Jobs"));
					back_to_job.click();
					break;
					
					}catch(Exception e)
					{
						
					}
				
			}
			
			

			Thread.sleep(5000);
			System.out.println("=======================================================================================================================================================================================");
				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Thread.sleep(5000);
		}
	}
	
	public Boolean isElementPresent(String str)
	{
		try{
			WebDriverWait wait1 = new WebDriverWait(driver, 15);
			WebElement temp_element = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className(str)));
			//driver.findElement(By.className(str));
		return true;
				
		}
		catch(Exception e)
		{
			return false;
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
	public Boolean isElementPresentByXpatht(String str)
	{
		try{
			WebDriverWait wait1 = new WebDriverWait(driver, 15);
			WebElement temp_element = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
			//driver.findElement(By.className(str));
		return true;
				
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
