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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
			
			WebDriverWait wait = new WebDriverWait(driver, 40);
//			WebElement jobs_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Jobs")));
//			jobs_link.click();  //commented this snippet coz if this section is called just after practice module
			
			List<WebElement> myElements = driver.findElements(By.tagName("span"));
			int i=0;
			for(WebElement e : myElements) {
				  
				if (e.getText().contains("Active")) {
					System.out.println(e.getText());
					i++;
				}
				}
			System.out.println("Total number of Active task is " +i);
			
			if(isElementPresentByClassName("_2sQiieIo03qrJhLGS-Lfky _3xDhhLog2fS9PQtPXrpbHO")) // if toggle is enabled
			{
				
				WebElement first_start_working_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_3VKG6gpwuvcgvDd94G4m_U")));
				first_start_working_button.click(); // click on start working button
				//driver.findElement(By.className("_3VKG6gpwuvcgvDd94G4m_U"));// click on start working button
				Thread.sleep(7000);
				if(isElementPresentByClassName("_1xMA1J_25JShnn1OrgerRz"))// if start working button of final page appears
				{								
					driver.findElement(By.className("_1xMA1J_25JShnn1OrgerRz")).click();   // then click it
					//Thread.sleep(3000);
				}
				int attempt_counter =0;
				
				while(isElementPresentByXpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span") && attempt_counter<5) // if no more task appears
				{
					driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span")).click(); // clicking cross button of no more task
					Thread.sleep(2000);
					driver.findElement(By.className("_1xMA1J_25JShnn1OrgerRz")).click();  // again click on Start working button
				}
				Thread.sleep(5000);
					int task_counter=0;
					while (task_counter < 5) {
						if (task_counter % 2 == 0) {
							WebElement button1 = wait
									.until(ExpectedConditions.visibilityOfElementLocated(By
											.xpath("/html/body/div/div/main/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/div/div/div/button[1]")));
							button1.click(); // category1 button
							Thread.sleep(1000);
							int local_attempt_counter=0;
							while(isElementPresentByXpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span") &&  local_attempt_counter<5) // if no more task appears
							{
								driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span")).click(); // clicking cross button of no more task
								Thread.sleep(2000);
								driver.findElement(By.className("_1xMA1J_25JShnn1OrgerRz")).click();  // again click on Start working button
								local_attempt_counter++;
							}
						} else {
							WebElement button2 = wait
									.until(ExpectedConditions.visibilityOfElementLocated(By
											.xpath("/html/body/div/div/main/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/div/div/div/button[2]")));
							button2.click(); // category2 button
							Thread.sleep(1000);
							int local_attempt_counter=0;
							while(isElementPresentByXpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span") &&  local_attempt_counter<5) // if no more task appears
							{
								driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span")).click(); // clicking cross button of no more task
								Thread.sleep(2000);
								driver.findElement(By.className("_1xMA1J_25JShnn1OrgerRz")).click();  // again click on Start working button
								local_attempt_counter++;
							}
						}

						task_counter++;
					}
					WebElement end_job_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div/div/main/div/div[1]/div[2]/div/div[1]/button")));
					end_job_button.click();	
			}
			else
			{
				WebElement toggle_to_enable_job = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_3xDhhLog2fS9PQtPXrpbHO")));
				toggle_to_enable_job.click();
				Thread.sleep(3000);
				WebElement start_working_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_3VKG6gpwuvcgvDd94G4m_U")));
				start_working_button.click(); // click on start working button
				//driver.findElement(By.className("_3VKG6gpwuvcgvDd94G4m_U"));// click on start working button
				Thread.sleep(7000);
				if(isElementPresentByClassName("_1xMA1J_25JShnn1OrgerRz")) // if start working button of final page appears
				{
					driver.findElement(By.className("_1xMA1J_25JShnn1OrgerRz")).click(); // click start working button of final page
				
				}
				
				int attempt_counter =0;
				while(isElementPresentByXpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span") && attempt_counter<5) // if no more task appears
				{
					driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span")).click(); // clicking cross button of no more task
					Thread.sleep(2000);
					driver.findElement(By.className("_1xMA1J_25JShnn1OrgerRz")).click();  // again click on Start working button
				}	
				Thread.sleep(5000);
					int task_counter=0;
					while (task_counter < 5) {
						if (task_counter % 2 == 0) {
							WebElement button1 = wait
									.until(ExpectedConditions.elementToBeClickable(By
											.xpath("/html/body/div/div/main/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/div/div/div/button[1]")));
							button1.click(); // category1 button
							Thread.sleep(1000);
							int local_attempt_counter=0;
							while(isElementPresentByXpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span") &&  local_attempt_counter<5) // if no more task appears
							{
								driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span")).click(); // clicking cross button of no more task
								Thread.sleep(2000);
								driver.findElement(By.className("_1xMA1J_25JShnn1OrgerRz")).click();  // again click on Start working button
							}
						} else {
							WebElement button2 = wait
									.until(ExpectedConditions.elementToBeClickable(By
											.xpath("/html/body/div/div/main/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/div/div/div/button[2]")));
							button2.click(); // category2 button
							Thread.sleep(1000);
							int local_attempt_counter=0;
							while(isElementPresentByXpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span") &&  local_attempt_counter<5) // if no more task appears
							{
								driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[1]/button/span")).click(); // clicking cross button of no more task
								Thread.sleep(2000);
								driver.findElement(By.className("_1xMA1J_25JShnn1OrgerRz")).click();  // again click on Start working button
							}
						}

						task_counter++;
					}
					WebElement end_job_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div/div/main/div/div[1]/div[2]/div/div[1]/button")));
					end_job_button.click();				
				
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
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			WebElement temp_element = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
			//driver.findElement(By.className(str));
		return true;
				
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
