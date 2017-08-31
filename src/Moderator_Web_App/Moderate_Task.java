package Moderator_Web_App;
import java.io.File;
import java.io.IOException;

import net.lightbody.bmp.core.har.Har;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Moderate_Task {
	
public WebDriver driver;
	
	public Moderate_Task(WebDriver driver1){
		driver = driver1;
	}
	
	public void moderatingTask()
	{
		try{
			System.out.println("Entered Moderator Project Listing page");
			WebDriverWait wait = new WebDriverWait(driver, 20);
//			WebElement jobs_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Jobs")));
//			jobs_link.click();  //commented this snippet coz if this section is called just after practice module
			int i=0;
			try{
			List<WebElement> myElements_active = driver.findElements(By.className("_3L4fiOedr3CQ182BsYHJUW"));
		
			for(WebElement e : myElements_active) {
				  
				if (e.getText().contains("Active")) {
					System.out.println(e.getText());
					i++;
				}
				}
			System.out.println("Total number of Active task is " +i);
			}catch(Exception e)
			{
				System.out.println("Moderator_Task.java field > Error between line 38-49");
				e.printStackTrace();
			
			}
						
			// Going to disable all active jobs
				try{
					List<WebElement> all_active_elements = driver.findElements(By.xpath("//div[contains(@class, '_2sQiieIo03qrJhLGS-Lfky _3xDhhLog2fS9PQtPXrpbHO')]"));
					Iterator itr = all_active_elements.iterator();
					while(itr.hasNext())
					{
						WebElement active_toggle = (WebElement) itr.next();
						active_toggle.click();
						Thread.sleep(1000);
					}
					
				}catch(Exception e){
					System.out.println("Not Found any enabled pop-up");
				}
				
				
				System.out.println("Disabled all the active jobs.");
				
				try{
				WebElement first_start_working_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_3VKG6gpwuvcgvDd94G4m_U")));
				first_start_working_button.click(); // click on start working button
				}
				catch(Exception e)
				{
					System.out.println("First start working button is not found");
				}
				
				System.out.println("Clicked first Start Job button");
				
				try{
					Thread.sleep(2000);
					driver.findElement(By.className("_1xMA1J_25JShnn1OrgerRz")).click(); // final start working button
				}
				catch(Exception e)
				{
					System.out.println("Second start working button not found");
				}
				
				System.out.println("Clicked second start Job button");
				
				Thread.sleep(10000);
				
				try{
					
					if(isElementPresentByXpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span"))// no more task pop-up
					{
						driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span")).click();
						Network_Capturing.mod_mail_msg += "<tr>" +
								 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
								 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
								 "Verify if a active job is toggle-disabled then feed does not contains task from disabled job." + "</td>"
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
								 "Verify if a active job is toggle-disabled then feed does not contains task from disabled job." + "</td>"
								 + "<td align='center' color='white' bgcolor='#FDE2DC'>" +
								 "Fail" + "</td>";
								 Network_Capturing.mod_mail_msg += "</tr>";
								 Network_Capturing.var_for_report_counter++;
					}
					
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("No More Task pop-up Not Found");
				}
				
				System.out.println("Closed the no more task pop-up for invoked for reporting purpose");
				
				
				Thread.sleep(10000);
				System.out.println("=======================================================================================================================================");
				System.out.println("Now going to enabled active project");
				// New Logic
				int counter=1;
				try{
													
					if(isElementPresentByXpath("/html/body/div/div/main/div/div[2]/div/table/thead/tr/th[1]")){
			
						System.out.println("Found Project Listing Table");
						while (true) {
																													
							WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/table/tbody/tr[" + counter + "]/td[1]")));
							
							if (element.getText().equalsIgnoreCase("NSFW Images")) {
								System.out.println("Found NSFW row now going to find and click toggle to enable NSFW");
								WebElement toggle_button_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/table/tbody/tr["+counter+"]/td[5]/div")));
																															 
								Actions action2 = new Actions(driver);
								action2.moveToElement(toggle_button_1).click(toggle_button_1).perform();
								System.out.println(counter);
							
								break;
								
							}
							counter++;
						}
								
					}}catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Some error in the code of enabling active task");
					}
	
					
					
					
			
					System.out.println("crossed the code of enabling toggle");
			
			
				
				WebElement first_start_working_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_3VKG6gpwuvcgvDd94G4m_U")));
				first_start_working_button.click(); // click on start working button
				
				Thread.sleep(3000);
				try {
					driver.findElement(By.className("_1xMA1J_25JShnn1OrgerRz")).click();
					
					Network_Capturing.mod_mail_msg += "<tr>" +
							 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
							 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
							 "Verify if user can start moderating jobs using Start Working button." + "</td>"
							 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
							 "Pass" + "</td>";
							 Network_Capturing.mod_mail_msg += "</tr>";
							 Network_Capturing.var_for_report_counter++;
				} catch (Exception e) {
					System.out.println("final start working button not found");
					
					Network_Capturing.mod_mail_msg += "<tr>" +
							 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
							 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
							 "Verify if user can start moderating jobs using Start Working button." + "</td>"
							 + "<td align='center' color='white' bgcolor='#FDE2DC'>" +
							 "Fail" + "</td>";
							 Network_Capturing.mod_mail_msg += "</tr>";
							 Network_Capturing.var_for_report_counter++;
				}
				
				int attempt_counter =0;
				int moderation_counter=1;
				
			while (attempt_counter <= 10) {
				try {
					WebDriverWait wait5 = new WebDriverWait(driver, 10);
					WebElement cross_button_no_more_popup = wait5.until(ExpectedConditions
							.visibilityOfElementLocated(By
									.xpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span")));
					cross_button_no_more_popup.click();
					Thread.sleep(3000);
					WebDriverWait wait8 = new WebDriverWait(driver, 7);
					WebElement stsrt_working_button = wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[2]/div/div/div/div/a")));
					Actions act = new Actions(driver);
					act.moveToElement(stsrt_working_button).click().perform();
					Thread.sleep(2000);
					
					driver.findElement(By.className("_1xMA1J_25JShnn1OrgerRz")).click();
					

				} catch (Exception e) {

					try {
						WebDriverWait wait6 = new WebDriverWait(driver, 7);
						WebElement category_button = wait6.until(ExpectedConditions
								.visibilityOfElementLocated(By
										.xpath("/html/body/div/div/main/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/div/div/div/button[2]")));
						category_button.click();
						moderation_counter++;
						if(moderation_counter == 5)
						{
							break;
						}
	
					} catch (Exception e1) {
						System.out.println("Some error occured");
					}
					

					
				}

				Thread.sleep(4000);
				attempt_counter++;

			}
				
				
				
				

				
				Thread.sleep(5000);
				
	
					
					try{
					WebElement end_job_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[1]/div[2]/div/div[1]/button")));
					end_job_button.click();	
					
					Network_Capturing.mod_mail_msg += "<tr>" +
							 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
							 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
							 "Verify if user can Click \"End-Job\" option once started Job." + "</td>"
							 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
							 "Pass" + "</td>";
							 Network_Capturing.mod_mail_msg += "</tr>";
							 Network_Capturing.var_for_report_counter++;
					
					}catch(Exception e)
					{
						Network_Capturing.mod_mail_msg += "<tr>" +
								 "<td align='center'  color='white' bgcolor='#e5ede3'>"+Network_Capturing.var_for_report_counter+"</td>"
								 + "<td align='left' color='white' bgcolor='#e5ede3'>" +
								 "Verify if user can Click \"End-Job\" option once started Job." + "</td>"
								 + "<td align='center' color='white' bgcolor='#FDE2DC'>" +
								 "Fail" + "</td>";
								 Network_Capturing.mod_mail_msg += "</tr>";
								 Network_Capturing.var_for_report_counter++;
						System.out.println("End Job button not found");
					}
			int l=500;
			while(i>0)
			{
				i--;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Boolean isElementPresentByClassName(String str)
	{
		try{
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			WebElement temp_element = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className(str)));
			//driver.findElement(By.className(str));
		return true;
				
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public Boolean isElementPresentByXpath(String str)
	{
		try{
			WebDriverWait wait2 = new WebDriverWait(driver, 45);
			WebElement temp_element = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
		return true;
				
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
