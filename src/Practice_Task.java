import java.awt.List;
import java.io.File;
import java.io.IOException;

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
	
	
	
	public Practice_Task(WebDriver driver1){		
		driver = driver1;
	}
	
	public void practiceTaskCompletion() throws InterruptedException
	{
		try{
			
			//driver.get("https://hivemicro.com");
			System.out.println("Going to start practice task completion");
			
			WebDriverWait wait = new WebDriverWait(driver, 80);
			
//			WebElement log_in_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log In")));
//			log_in_link.click();
			
			///Signup for_fetching_signup_email = new Signup();
//			WebElement user_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
////			
//			user_name.sendKeys("testqa+44@kiwi.qa");
//			user_name.sendKeys(Signup.email);
//			
//			WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
//			pwd.sendKeys("kiwikiwi");
//			
//			WebElement login_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/input")));
//			login_button.click();
//			Thread.sleep(5000);
			//driver.navigate().refresh();
			
//			WebElement profile_page_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By
//					.xpath("/html/body/div/div/header/div[2]/nav/a[5]")));
//			profile_page_link.click();
//			
//			WebElement paypal_first_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By
//					.id("first_name")));
//			paypal_first_name.sendKeys("vivek");
//			//System.out.println("Entered first name");
//			
//			
//			WebElement paypal_last_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By
//					.id("last_name")));
//			paypal_last_name.sendKeys("singh");
			//System.out.println("Entered last name");
			
			
//			Thread.sleep(5000);
//			try{
//			WebElement paypal_email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/main/div/div[2]/div[2]/div/form/fieldset[3]/input")));
//			paypal_email.sendKeys("vineet1777@yahoo.com");
//			System.out.println("Entered  email");
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//			
//			WebElement paypal_update_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
//					.xpath("/html/body/div/div/main/div/div[2]/div[2]/div/div/input")));
//			paypal_update_button.click();
//			driver.navigate().refresh();
		
			
			WebElement jobs_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Jobs")));
			jobs_link.click();
			Thread.sleep(10000);
			
			if(isElementPresentBylinkText("Skip")){
			WebElement skip_paypal_detail_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Skip")));
			skip_paypal_detail_button.click();
			Thread.sleep(10000);
			}

			System.out.println("Going to click on Apply button on my owner's wish");
			int counter=1;
			if(isElementPresentByXpatht("/html/body/div/div/main/div/div[2]/div/table/thead/tr/th[1]")){
				System.out.println("Step-1");
				while (true) {
					System.out.println("Step-2");
					WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/table/tbody/tr[" + counter + "]/td[1]")));
					System.out.println("Step-3");
					if (element.getText().equalsIgnoreCase("NSFW Images")) {
						System.out.println("Step-4");
						break;
					}
					counter++;
				}
			}
			
			WebElement apply_link_job_page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/table/tbody/tr["+counter+"]/td[4]/a")));
			apply_link_job_page.click();															
			Thread.sleep(2000);
			
			
			
			
			WebElement apply_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/div/div[4]/button")));
			apply_button.click();
			Thread.sleep(3000);
			
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
							Thread.sleep(3000);
							break;
						}
						counter2++;
					}
				} catch (Exception e1) {
					//e1.printStackTrace();
				}
				try{
					WebElement back_to_job = driver.findElement(By.linkText("Back to Jobs"));
					back_to_job.click();
					break;
					
					}catch(Exception e)
					{
						
					}
				
			}
			
			
//			
//			for(int i=0;i<100;i++) //// Code for Types of violence
//				{
//					
//					try{
//						
//						WebElement blood_gloor_button = wait
//								.until(ExpectedConditions.elementToBeClickable(By
//										.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[2]")));
//						blood_gloor_button.click();
//						
//						}catch(Exception e)
//						{
//							System.out.println("Clean category button is not clakable");
//						}
//					
////						WebElement pg_13_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[2]")));
////						pg_13_button.click();//_2H7ucOUfSIUH-Bpg6wzhzt
//					//Thread.sleep(2000);//_25qSclWMCIhEsr29NdJ-P8   class for PG-13 button
//					
//					//if (isElementPresent("_2H7ucOUfSIUH-Bpg6wzhzt")) 
//					try {
//						Thread.sleep(2000);
//						driver.findElement(By.className("_2H7ucOUfSIUH-Bpg6wzhzt"));
//						if (driver.findElement(By.className("_2H7ucOUfSIUH-Bpg6wzhzt")).getText().contains("Guns/firearms")) {
//							driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/button")).click(); /// clicking cross button
//							Thread.sleep(1000);
//							WebElement clean_button = wait
//									.until(ExpectedConditions.elementToBeClickable(By
//											.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[1]")));
//							clean_button.click();
//							Thread.sleep(2000);
//						}
//	
//						else {
//							
//							if (driver.findElement(By.className("_2H7ucOUfSIUH-Bpg6wzhzt")).getText()
//									.contains("Unclear violence")) {
//								driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/button")).click();
//								Thread.sleep(1000);
//								WebElement sexual_button = wait
//										.until(ExpectedConditions.elementToBeClickable(By
//												.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[5]")));
//								sexual_button.click();
//								Thread.sleep(2000);
//							}
//							else {
//	
//								if (driver.findElement(By.className("_2H7ucOUfSIUH-Bpg6wzhzt")).getText()
//										.contains("Guns AND Blood")) {
//									driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/button"))
//											.click();
//									Thread.sleep(1000);
//									WebElement sexual_button = wait
//											.until(ExpectedConditions.elementToBeClickable(By
//													.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[3]")));
//									sexual_button.click();
//									Thread.sleep(2000);
//								} else {
//									if (driver.findElement(By.className("_2H7ucOUfSIUH-Bpg6wzhzt")).getText()
//											.contains("Fights")) {
//										driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/button"))
//												.click();
//										Thread.sleep(1000);
//										WebElement fights_button = wait
//												.until(ExpectedConditions.elementToBeClickable(By
//														.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[4]")));
//										fights_button.click();
//										Thread.sleep(2000);
//									}
//									
//								else{
//					
//									
//								
//									driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/button"))
//											.click();
//									Thread.sleep(2000);
//									WebElement explosion_button = wait
//											.until(ExpectedConditions.elementToBeClickable(By
//													.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[6]")));
//									explosion_button.click();
//									Thread.sleep(2000);}
//	
//								}
//							}
//						}
//						try{
//						WebElement back_to_job = driver.findElement(By.linkText("Back to Jobs"));
//						back_to_job.click();
//						break;
//						
//						}catch(Exception e)
//						{
//							
//						}
//	
//					}
//					catch(Exception e)
//					{
//						try{
//							WebElement back_to_job = driver.findElement(By.linkText("Back to Jobs"));
//							back_to_job.click();
//							break;
//							
//							}catch(Exception e1)
//							{
//								
//							}
//					}
////					else
////					{
////						try{
////						WebElement clean_button = wait
////								.until(ExpectedConditions.elementToBeClickable(By
////										.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[1]")));
////						clean_button.click();
////						}catch(Exception e)
////						{
////							System.out.println("Clean category button is clakable");
////						}
////					}
//					
//					
//				}
			
			
//			for(int i=0;i<100;i++) //// Code for NSFW Project
//			{
//				
//				try{
//					
//					WebElement clean_button = wait
//							.until(ExpectedConditions.elementToBeClickable(By
//									.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[1]")));
//					clean_button.click();
//					
//					}catch(Exception e)
//					{
//						System.out.println("Clean category button is not clakable");
//					}
//				
////					WebElement pg_13_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[2]")));
////					pg_13_button.click();//_2H7ucOUfSIUH-Bpg6wzhzt
//				//Thread.sleep(2000);//_25qSclWMCIhEsr29NdJ-P8   class for PG-13 button
//				
//				//if (isElementPresent("_2H7ucOUfSIUH-Bpg6wzhzt")) 
//				try {
//					Thread.sleep(2000);
//					driver.findElement(By.className("_2H7ucOUfSIUH-Bpg6wzhzt"));
//					if (driver.findElement(By.className("_2H7ucOUfSIUH-Bpg6wzhzt")).getText().contains("Clean")) {
//						driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/button")).click();
//						Thread.sleep(1000);
//						WebElement clean_button = wait
//								.until(ExpectedConditions.elementToBeClickable(By
//										.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[1]")));
//						clean_button.click();
//						Thread.sleep(2000);
//					}
//
//					else {
//						
//						if (driver.findElement(By.className("_2H7ucOUfSIUH-Bpg6wzhzt")).getText()
//								.contains("PG-13")) {
//							driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/button")).click();
//							Thread.sleep(1000);
//							WebElement sexual_button = wait
//									.until(ExpectedConditions.elementToBeClickable(By
//											.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[2]")));
//							sexual_button.click();
//							Thread.sleep(2000);
//						}
//						else {
//
//							if (driver.findElement(By.className("_2H7ucOUfSIUH-Bpg6wzhzt")).getText()
//									.contains("Explicit, Sexual")) {
//								driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/button"))
//										.click();
//								Thread.sleep(1000);
//								WebElement sexual_button = wait
//										.until(ExpectedConditions.elementToBeClickable(By
//												.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[3]")));
//								sexual_button.click();
//								Thread.sleep(2000);
//							} else {
//								driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/button"))
//										.click();
//								Thread.sleep(2000);
//								WebElement violent_button = wait
//										.until(ExpectedConditions.elementToBeClickable(By
//												.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[4]")));
//								violent_button.click();
//								Thread.sleep(2000);
//
//							}
//						}
//					}
//					try{
//					WebElement back_to_job = driver.findElement(By.linkText("Back to Jobs"));
//					back_to_job.click();
//					break;
//					
//					}catch(Exception e)
//					{
//						
//					}
//
//				}
//				catch(Exception e)
//				{
//					
//				}
////				else
////				{
////					try{
////					WebElement clean_button = wait
////							.until(ExpectedConditions.elementToBeClickable(By
////									.xpath("/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[1]")));
////					clean_button.click();
////					}catch(Exception e)
////					{
////						System.out.println("Clean category button is clakable");
////					}
////				}
//				
//				
//			}
			
			
			
			
			
			
//			
//			WebElement back_to_job_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Back to Jobs")));
//			back_to_job_link.click();
			Thread.sleep(20000);
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
