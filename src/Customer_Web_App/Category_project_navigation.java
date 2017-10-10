package Customer_Web_App;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Moderator_Web_App.Network_Capturing;

public class Category_project_navigation {
	
public WebDriver driver;
FileInputStream fileInput = null;
Properties prop = new Properties();
	
	public Category_project_navigation(WebDriver driver1){		
		driver = driver1;
		
		File file = new File("/Users/viveksingh/Documents/workspace/Practice_Enterprise_Leve/src/addProject.properties");
		try {

			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void clickCategoryProjectFromProjectListingPage() throws InterruptedException
	{
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement header_projects = wait1.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[1]/h1")));
		if(header_projects.isDisplayed())
		{
			System.out.println("Projects page is loaded");
		}
		else
		{
			System.out.println("Projects page is not detected");
		}
		
		
		WebElement first_row_of_table = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr[1]/td[1]/div")));
		if(first_row_of_table.isDisplayed())
		{
			System.out.println("First row of project table is displayed");
		}
		
		
		Thread.sleep(7000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		 for(int i=1;i<25;i++)
		 {		
			try {
				if (driver
						.findElement(
								By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[1]/div")).getText().contains("categor") || driver
								.findElement(
										By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[1]/div")).getText().contains("Categor")) {
					System.out.println("category project found and now going to clcik it");
					WebElement first_row_of_table_for_categ = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr["
									 + i + "]/td[1]/div")));
					Actions action = new Actions(driver);
					action.moveToElement(first_row_of_table_for_categ).click().perform();
//					driver
//					.findElement(
//							By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr["
//									 + i + "]/td[1]/div")).click();
					break;

				}
			} catch (Exception e) {
				System.out.println("Not Found in "+ i + "Attempt");
			}
		}
		 Thread.sleep(5000);
		 if(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/header/div/div[2]/nav/h1")).getText().contains("categor") || driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/header/div/div[2]/nav/h1")).getText().contains("Categor"))
		 {
			 System.out.println("Reached to setting page of categorisation project");
		 }
		  
		 String api_key = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/p[2]")).getText();
		 // going to refresh api_key
		 driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/p[2]/button")).click();
		String refreshed_api_key = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/p[2]")).getText();
		Thread.sleep(5000);
		if(api_key.equals(refreshed_api_key))
		{
			System.out.println("API token refreshed successfully");
			
		}
		else
		{
			System.out.println("Issue in refreshing api token on setting page");
		}
		
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement slider_holder = wait2.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div/div[1]/div[4]/div/div/div[4]")));
		String project_charge = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div/div[1]/div[4]/div/p")).getText();
		
		Actions action = new Actions(driver);
		action.clickAndHold(slider_holder).moveByOffset(-50, 0).release(slider_holder).build().perform();
		Thread.sleep(5000);
		String changed_project_charge = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div/div[1]/div[4]/div/p")).getText();
		
		if(project_charge.equals(changed_project_charge))
		{
			System.out.println("Price is not changed through slider");
			
		}
		else
		{
			System.out.println("Price is changed through slider");
		}
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div[2]/button/span[1]")).click();// clicking update button of settings page
		Thread.sleep(5000);
		
		    	driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[2]/div/button")).click();
		    	driver.navigate().refresh();
		    	// to accept alert of project updation
		    
	}
	
	public void guideline_navigation() throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait_40 = new WebDriverWait(driver, 30);
		Actions action =  new Actions(driver);
		WebElement guideline_tab = wait_40.until(ExpectedConditions.elementToBeClickable(By
				.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[2]/div/div[1]/a[2]/div")));
						String temp = guideline_tab.getText();
						
						
//						WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[2]/div/div[1]/a[2]/div"));
//						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//						Thread.sleep(500);
						
						System.out.println("+++++++++++++++++++++++++++++"+temp+"=========================================");
						
						
		
		action.moveToElement(guideline_tab).click().build().perform();
		
		
		WebDriverWait wait_10 = new WebDriverWait(driver, 40);
		WebElement markdown_editor_heading = wait_10.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div/div[1]/h1")));
		
		
	      
//		WebElement preview_text = wait_10.until(ExpectedConditions.visibilityOfElementLocated(By
//				.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div/div[6]/div[1]/div/div/div/div[5]/pre[7]/span/span")));
//		preview_text.clear();
		
		WebElement update_buttont = wait_10.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/button")));
		update_buttont.click();
		
		WebElement ok_button_of_success_pop_up = wait_10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/button")));
		ok_button_of_success_pop_up.click();
		
		WebElement project_updated_text = wait_10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div[1]/p")));
		String alert_text = project_updated_text.getText();
		
		if(alert_text.equals("Project updated"))
		{
		 Network_Capturing.cust_mail_msg += "<tr>" +
				 "<td align='center'  color='white' bgcolor='#e5ede3'>"+1+"</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Updated Project Setting Page" + "</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Pass" + "</td>";
				 Network_Capturing.cust_mail_msg += "</tr>";
		}
		else
		{
			Network_Capturing.cust_mail_msg += "<tr>" +
					 "<td align='center'  color='white' bgcolor='#e5ede3'>"+1+"</td>"
					 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
					 "Updated Project Setting Page" + "</td>"
					 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
					 "Fail" + "</td>";
					 Network_Capturing.cust_mail_msg += "</tr>";
		}
		
		
	}
	
	public void navigate_prelabeled_tab()
	{
		WebDriverWait wait_30 = new WebDriverWait(driver, 30);
		
		WebElement prelabeled_tab = wait_30.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[2]/div/div[1]/a[3]/div")));
		prelabeled_tab.click();
		
		WebElement practice_tab = wait_30.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[1]/div[1]")));
		WebElement honeypot_tab = wait_30.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[1]/div[2]")));
	if(practice_tab.isDisplayed())
		{
			System.out.println("Navigated to pre-labeles tab");
		}
		
	}
	
	public void uplaodSingleTask() throws AWTException, InterruptedException
	{
		WebDriverWait wait_30 = new WebDriverWait(driver, 30);
		Actions action = new Actions(driver);
		
		WebElement single_upload_button = wait_30.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div/div[1]/div[3]")));
		single_upload_button.click();
		
		WebElement browse_button_of_popup = wait_30.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div/form/div[1]/div/div/button/span[1]")));
		
		if(browse_button_of_popup.isDisplayed())
		{
		String xpath_for_browse = "/html/body/div[5]/div/div[2]/div/form/div[1]/div/div/button/span[1]";
		String file_path = "/Users/viveksingh/Documents/Marketplace_formats/Marketplace_Testing_1.png";
		Browse_File browse = new Browse_File(driver);
		browse.UploadFileUsingJacobDll(file_path,xpath_for_browse,"Single");
		
		WebElement practice_radi_button = wait_30.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div/form/div[2]/div[2]/div/div/label[3]/span[2]")));
		action.moveToElement(practice_radi_button).click().perform();
		
		WebElement text_data_text = wait_30.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div/form/div[2]/div[3]/div/div/div/textarea[3]")));
		action.moveToElement(text_data_text).sendKeys("Single Upload").perform();
		
		WebElement first_available_cate = wait_30.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div/form/div[2]/div[4]/div/div/label[2]/span[2]")));
		action.moveToElement(first_available_cate).click().perform();
		
		WebElement submit_button_of_sibgle_upload_popup = wait_30.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div/form/div[3]/button")));
		action.moveToElement(submit_button_of_sibgle_upload_popup).click().perform();
		
		
		}
		
	}

}
