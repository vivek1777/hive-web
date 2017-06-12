package Customer_Web_App;

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
	
	public Add_Project(WebDriver driver1){		
		driver = driver1;
	}

	public void addCategorizationProject()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		SoftAssert softAssert = new SoftAssert();
		try{
																												
			WebElement add_project_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/a/button")));
			add_project_button.click();
			
			WebElement custom_div = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[2]")));
			custom_div.click();
			
			WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[1]/div/input")));
			title.sendKeys("Custom Categorization Testing project");
			
			WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/div/textarea[3]")));
			description.sendKeys("Description for Custom Categorization Testing project");
			
			WebElement prompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div/textarea[3]")));
			prompt.sendKeys("Description for Custom Categorization Testing project");
			
			WebElement category_check_box = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[5]/div/label[2]/span[2]")));
			Actions actions = new Actions(driver);
			actions.moveToElement(category_check_box).click().perform();
			
			
			
			WebElement add_cat_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[9]/div/button")));
			add_cat_button.click();
			
			WebElement add_cat_button_again = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[9]/div/button")));
			add_cat_button_again.click();
		
			WebElement cat_name_field_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[9]/table/tbody/tr/td[1]/div/div/input")));
			cat_name_field_1.sendKeys("Electronics");
			
			WebElement cat_slug_field_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[9]/table/tbody/tr/td[2]/div/div/input")));
			cat_slug_field_1.sendKeys("electronics");
			
			WebElement cat_name_field_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[9]/table/tbody/tr[2]/td[1]/div/div/input")));
			cat_name_field_2.sendKeys("Kitchenware");
			
			WebElement cat_slug_field_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[9]/table/tbody/tr[2]/td[2]/div/div/input")));
			cat_slug_field_2.sendKeys("kitchenware");
			
			WebElement create_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[10]/button")));
			create_button.click();
			
			WebElement created_project_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr[1]/td[2]")));

			if(created_project_name.getText().equalsIgnoreCase("Custom Categorization Testing project"))
		    {
				Network_Capturing.cust_mail_msg += "<tr>" + "<td align='center'  color='white' bgcolor='#e5ede3'>"+2+"</td>" 
						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + "Category Custom Project Creation" + "</td>"
						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + "Pass" + "</td>";
				Network_Capturing.cust_mail_msg += "</tr>";
			}
			else
		    {
				Network_Capturing.cust_mail_msg += "<tr>" + "<td align='center'  color='white' bgcolor='#e5ede3'>"+2+"</td>" 
						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + "Category Custom Project Creation" + "</td>"
						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + "Fail" + "</td>";
				Network_Capturing.cust_mail_msg += "</tr>";
			}
			
			
			
			Thread.sleep(5000);
			WebElement add_project_button_again = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/a/button/span[1]")));
			Actions action4 = new Actions(driver);
			action4.moveToElement(add_project_button_again).click().perform();
			
			
			WebElement custom_div_again = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[2]")));
			custom_div_again.click();
			
			WebElement title_again = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[1]/div/input")));
			title_again.sendKeys("Bounding Box Testing project");
			
			WebElement description_again = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/div/textarea[3]")));
			description_again.sendKeys("Description for Bounding Box Testing project");
			
			WebElement prompt_again = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div/textarea[3]")));
			prompt_again.sendKeys("Description for Bounding Box Testing project");
			
			WebElement bounding_box_check_box = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[5]/div/label[1]/span[2]")));
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(bounding_box_check_box).click().perform();
			
			Thread.sleep(1000);
			WebElement bounding_box_create_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[6]/button/span[1]")));
			actions1.moveToElement(bounding_box_create_button).click().perform();
			
			boolean flag=true;
			for(int i=0;i<4;i++)
			{
				try {
					if (driver
							.findElement(
									By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr["
											+ i + "]/td[2]")).getText()
							.equalsIgnoreCase("Bounding Box Testing project")) {
						Network_Capturing.cust_mail_msg += "<tr>" + "<td align='center'  color='white' bgcolor='#e5ede3'>"+3+"</td>" 
								+ "<td align='center' color='white' bgcolor='#e5ede3'>" + "Bounding Box Project Creation" + "</td>"
								+ "<td align='center' color='white' bgcolor='#e5ede3'>" + "Pass" + "</td>";
						Network_Capturing.cust_mail_msg += "</tr>";
						flag=false;
						break;
					}
				} catch (Exception e) {

				}
			}
			if (flag == true)
			{
				Network_Capturing.cust_mail_msg += "<tr>" + "<td align='center'  color='white' bgcolor='#e5ede3'>"+3+"</td>" 
						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + "Bounding Box Project Creation" + "</td>"
						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + "Fail" + "</td>";
				Network_Capturing.cust_mail_msg += "</tr>";
			}
			
			
			Thread.sleep(5000);
			System.out.println("going to press add add project button again");
			WebElement add_project_button_nsfw = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/a/button/span[1]")));
			Actions action3 = new Actions(driver);
			action3.moveToElement(add_project_button_nsfw).click().perform();
			
			WebElement custom_div_again_nsfw = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]")));
			custom_div_again_nsfw.click();
			
			WebElement title_again_nsfw = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/form/div[1]/div/input")));
			title_again_nsfw.sendKeys("NSFW Testing Project");
			
			WebElement nsfw_create_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/form/div[3]/button")));
			actions1.moveToElement(nsfw_create_button).click().perform();
			
			boolean flag1=true;
			for(int i=0;i<4;i++)
			{
				try {
					if (driver
							.findElement(
									By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr["
											+ i + "]/td[2]")).getText()
							.equalsIgnoreCase("NSFW Testing Project")) {
						Network_Capturing.cust_mail_msg += "<tr>" + "<td align='center'  color='white' bgcolor='#e5ede3'>"+4+"</td>" 
								+ "<td align='center' color='white' bgcolor='#e5ede3'>" + "NSFW Project Creation" + "</td>"
								+ "<td align='center' color='white' bgcolor='#e5ede3'>" + "Pass" + "</td>";
						Network_Capturing.cust_mail_msg += "</tr>";
						flag1=false;
						break;
					}
				} catch (Exception e) {

				}
			}
			if (flag1 == true)
			{
				Network_Capturing.cust_mail_msg += "<tr>" + "<td align='center'  color='white' bgcolor='#e5ede3'>"+4+"</td>" 
						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + "NSFW Project Creation" + "</td>"
						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + "Fail" + "</td>";
				Network_Capturing.cust_mail_msg += "</tr>";
			}
			
			Thread.sleep(5000);
			System.out.println(Network_Capturing.cust_mail_msg);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(Network_Capturing.cust_mail_msg);
		}
	}
}
