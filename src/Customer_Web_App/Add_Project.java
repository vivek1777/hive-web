package Customer_Web_App;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Moderator_Web_App.Network_Capturing;

public class Add_Project {
	
	public WebDriver driver;
	FileInputStream fileInput = null;
	Properties prop = new Properties();
	
	public Add_Project(WebDriver driver1) {
		File file = new File("/Users/viveksingh/Documents/workspace/Practice_Enterprise_Leve/src/addProject.properties");

		driver = driver1;
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
	

	public void addCategorizationProject() throws InterruptedException
 {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		SoftAssert softAssert = new SoftAssert();
		int counter = 1;
		while (true) {
			try {

				if(counter==1){
					Thread.sleep(5000);
					System.out.println("Inside welcome add project button code block");
				WebElement add_project_button_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(prop.getProperty("welcome_add_project_button"))));
				Actions act = new Actions(driver);
				act.moveToElement(add_project_button_1).click().perform();
				}
				else{
					System.out.println("Inside regular add project button code block");
					WebElement add_project_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath(prop.getProperty("regular_add_project_button"))));
					Actions act = new Actions(driver);
					act.moveToElement(add_project_button).click().perform();
				}
				
				
				WebElement data_labeling = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(prop.getProperty("data_labeling_section"))));
				Actions act1 = new Actions(driver);
				act1.moveToElement(data_labeling).click().perform();


				WebElement title = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath(prop.getProperty("project_title"))));
				title.sendKeys("Custom Categorization Testing project");

				WebElement description = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath(prop.getProperty("descriotion_project"))));
										
				description.sendKeys("Description for Custom Categorization Testing project");

				WebElement prompt = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath(prop.getProperty("prompt_project"))));
				prompt.sendKeys("Description for Custom Categorization Testing project");

				WebElement category_check_box = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath(prop.getProperty("category_radio_button"))));
										
				Actions actions = new Actions(driver);
				actions.moveToElement(category_check_box).click().perform();

				WebElement cat_name_field_1 = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath(prop.getProperty("cate_label_first"))));
				cat_name_field_1.sendKeys("category1");

				WebElement cat_slug_field_1 = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath(prop.getProperty("cate_slug_first"))));
				cat_slug_field_1.sendKeys("cate1");

				WebElement cat_name_field_2 = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath(prop.getProperty("cate_label_sceond"))));
				cat_name_field_2.sendKeys("category2");

				WebElement cat_slug_field_2 = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath(prop.getProperty("cate_slug_second"))));
				cat_slug_field_2.sendKeys("cate2");

				WebElement create_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(prop.getProperty("create_project_button"))));
				create_button.click();

				Thread.sleep(7000);
				//Going to create Report if project created successfully
				
				WebElement created_project_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(prop.getProperty("first_success_created_project"))));
				System.out.println(driver.findElement(By.xpath(prop.getProperty("first_success_created_project"))).getText());

				 if(created_project_name.getText().contains("Categorization"))
				 {
				 Network_Capturing.cust_mail_msg += "<tr>" +
				 "<td align='center'  color='white' bgcolor='#e5ede3'>"+1+"</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Category Custom Project Creation" + "</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Pass" + "</td>";
				 Network_Capturing.cust_mail_msg += "</tr>";
				 }
				 else
				 {
				 Network_Capturing.cust_mail_msg += "<tr>" +
				 "<td align='center'  color='white' bgcolor='#e5ede3'>"+1+"</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Category Custom Project Creation" + "</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Fail" + "</td>";
				 Network_Capturing.cust_mail_msg += "</tr>";
				 }
				

				 
				
				WebElement add_project_button_again = wait.until(ExpectedConditions.elementToBeClickable(By
						.xpath(prop.getProperty("regular_add_project_button"))));
				Actions action4 = new Actions(driver);
				action4.moveToElement(add_project_button_again).click().perform();

				
				WebElement custom_div_again = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(prop.getProperty("custom_div_button"))));
				custom_div_again.click();

				WebElement title_again = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath(prop.getProperty("project_title"))));
									
				title_again.sendKeys("Bounding Box Testing project");

				WebElement description_again = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath(prop.getProperty("descriotion_project"))));
				description_again.sendKeys("Description for Bounding Box Testing project");

				WebElement prompt_again = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath(prop.getProperty("prompt_project"))));
				prompt_again.sendKeys("Description for Bounding Box Testing project");

				WebElement bounding_box_check_box = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath(prop.getProperty("boundingbox_radio_button"))));
				Actions actions1 = new Actions(driver);
				actions1.moveToElement(bounding_box_check_box).click().perform();

				Thread.sleep(1000);
				WebElement bounding_box_create_button = wait
						.until(ExpectedConditions.elementToBeClickable(By
								.xpath(prop.getProperty("create_project_button"))));
				actions1.moveToElement(bounding_box_create_button).click().perform();
				Thread.sleep(5000);

				 boolean flag=true;
				 for(int i=1;i<4;i++)
				 {
					 
				 try {
					 System.out.println(driver
							 .findElement(
							 By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[1]/div")).getText());
				 if (driver
				 .findElement(
				 By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr["
				 + i + "]/td[1]/div")).getText()
				 .equalsIgnoreCase("Bounding Box Testing project")) {
				 Network_Capturing.cust_mail_msg += "<tr>" +
				 "<td align='center'  color='white' bgcolor='#e5ede3'>"+2+"</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Bounding Box Project Creation" + "</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Pass" + "</td>";
				 Network_Capturing.cust_mail_msg += "</tr>";
				 flag=false;
				 break;
				 }
				 } catch (Exception e) {
				
				 }
				 }
				 if (flag == true)
				 {
				 Network_Capturing.cust_mail_msg += "<tr>" +
				 "<td align='center'  color='white' bgcolor='#e5ede3'>"+2+"</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Bounding Box Project Creation" + "</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Fail" + "</td>";
				 Network_Capturing.cust_mail_msg += "</tr>";
				 }

				Thread.sleep(5000);
				System.out.println("going to press add add project button again");

//				if(counter==1){
//					WebElement add_project_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
//							.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div/a/button/span[1]")));
//					Actions act = new Actions(driver);
//					act.moveToElement(add_project_button).click().perform();
//					}
//					else{
//						WebElement add_project_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
//								.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div/div[1]/div/a/button/span[1]")));
//						Actions act = new Actions(driver);
//						act.moveToElement(add_project_button).click().perform();
//					}
				WebElement add_project_button_nsfw = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(prop.getProperty("regular_add_project_button"))));
				Actions action3 = new Actions(driver);
				action3.moveToElement(add_project_button_nsfw).click().perform();

				WebElement custom_div_again_nsfw = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(prop.getProperty("nsfw_div_button"))));
				Actions action5 = new Actions(driver);
				action5.moveToElement(custom_div_again_nsfw).click().perform();
				// custom_div_again_nsfw.click();

				WebElement title_again_nsfw = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(prop.getProperty("nsfw_title"))));
				title_again_nsfw.sendKeys("NSFW Testing Project");

				WebElement nsfw_create_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(prop.getProperty("nsfw_create_button"))));
				actions1.moveToElement(nsfw_create_button).click().perform();
				Thread.sleep(5000);

				 boolean flag1=true;
				 for(int i=1;i<4;i++)
				 {
					
				 try {
					 System.out.println(driver
							 .findElement(
							 By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[1]/div")).getText());
				 if (driver
				 .findElement(
				 By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr["
						 + i + "]/td[1]/div")).getText()
				 .equalsIgnoreCase("NSFW Testing Project")) {
				 Network_Capturing.cust_mail_msg += "<tr>" +
			 "<td align='center'  color='white' bgcolor='#e5ede3'>"+3+"</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "NSFW Project Creation" + "</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Pass" + "</td>";
				 Network_Capturing.cust_mail_msg += "</tr>";
				 flag1=false;
				 break;
				 }
				 } catch (Exception e) {
				
				 }
				 }
				 if (flag1 == true)
				 {
				 Network_Capturing.cust_mail_msg += "<tr>" +
				 "<td align='center'  color='white' bgcolor='#e5ede3'>"+3+"</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "NSFW Project Creation" + "</td>"
				 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
				 "Fail" + "</td>";
				 Network_Capturing.cust_mail_msg += "</tr>";
				 }

				Thread.sleep(5000);
				System.out.println(Network_Capturing.cust_mail_msg);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(Network_Capturing.cust_mail_msg);
			}
			
			WebElement add_project_button_transcription = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(prop.getProperty("regular_add_project_button"))));
			Actions action4 = new Actions(driver);
			action4.moveToElement(add_project_button_transcription).click().perform();
			
			WebElement custom_div = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(prop.getProperty("custom_div_button"))));
			Actions act1 = new Actions(driver);
			act1.moveToElement(custom_div).click().perform();
			
			WebElement title = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath(prop.getProperty("project_title"))));
			title.sendKeys("Custom Transcription Testing project");

			WebElement description = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath(prop.getProperty("descriotion_project"))));
									
			description.sendKeys("Description for Custom Transcription Testing project");

			WebElement prompt = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath(prop.getProperty("prompt_project"))));
			prompt.sendKeys("Description for Custom Transcription Testing project");
			
			WebElement transcription_check_box = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath(prop.getProperty("transcription_radio_button"))));
			Actions actions5 = new Actions(driver);
			actions5.moveToElement(transcription_check_box).click().perform();
			
			WebElement transcription_create_button = wait
					.until(ExpectedConditions.elementToBeClickable(By
							.xpath(prop.getProperty("create_project_button"))));
			actions5.moveToElement(transcription_create_button).click().perform();
			Thread.sleep(5000);
			
			 boolean flag1=true;
			 for(int i=1;i<4;i++)
			 {
				
			 try {
				 System.out.println(driver
						 .findElement(
						 By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr["
						 + i + "]/td[1]/div")).getText());
			 if (driver
			 .findElement(
			 By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr["
					 + i + "]/td[1]/div")).getText()
			 .contains("Transcription")) {
			 Network_Capturing.cust_mail_msg += "<tr>" +
		 "<td align='center'  color='white' bgcolor='#e5ede3'>"+4+"</td>"
			 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
			 "Transcription Project Creation" + "</td>"
			 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
			 "Pass" + "</td>";
			 Network_Capturing.cust_mail_msg += "</tr>";
			 flag1=false;
			 break;
			 }
			 } catch (Exception e) {
			
			 }
			 }
			 if (flag1 == true)
			 {
			 Network_Capturing.cust_mail_msg += "<tr>" +
			 "<td align='center'  color='white' bgcolor='#e5ede3'>"+4+"</td>"
			 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
			 "NSFW Project Creation" + "</td>"
			 + "<td align='center' color='white' bgcolor='#e5ede3'>" +
			 "Fail" + "</td>";
			 Network_Capturing.cust_mail_msg += "</tr>";
			 }

			Thread.sleep(5000);
			System.out.println(Network_Capturing.cust_mail_msg);
			
			
			
			counter++;
			if (counter == 2) {
				break;
			}
		}

	}
}
