package Customer_Web_App;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Browse_File {
	WebDriver driver2;
	Robot robot = new Robot();
	static boolean flag= true;
	public Browse_File(WebDriver driver) throws AWTException{
		driver2=driver;
		
	}
	
	public void UploadFileUsingJacobDll(String image_path, String upload_button_path, String loop_or_single)
			throws InterruptedException, AWTException {
 
//		try {
//			driver2.findElement(By.xpath(plus_button_xpath)).click();
//		} catch (Exception e1) {
//			System.out.println("Plus Icon not found");	
//		}
		
		WebDriverWait wait = new WebDriverWait(driver2, 40);
		WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(upload_button_path)));
		fileInput.click();
		
//		try {
//			driver2.findElement(By.xpath(plus_button_xpath)).click();
//		} catch (Exception e1) {
//			System.out.println("Plus Icon not found");	
//		}
		
		//fileInput.sendKeys("/Users/viveksingh/Documents/Image_formats/bike.tiff");
		//File file = new File(image_path);
		StringSelection stringSelection= new StringSelection(image_path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		//file.getAbsolutePath()
			
		if(loop_or_single.equalsIgnoreCase("loop"))
		{
		
		if(flag){
		robot.keyPress(KeyEvent.VK_META);
		 
		robot.keyPress(KeyEvent.VK_TAB);
		 
		robot.keyRelease(KeyEvent.VK_META);
		 
		robot.keyRelease(KeyEvent.VK_TAB);
		flag=false;
		}
		 System.out.println(image_path);
		robot.delay(2000);
		
		robot.keyPress(KeyEvent.VK_META);
		 
		robot.keyPress(KeyEvent.VK_SHIFT);
		 
		robot.keyPress(KeyEvent.VK_G);
		 
		robot.keyRelease(KeyEvent.VK_META);
		 
		robot.keyRelease(KeyEvent.VK_SHIFT);
		 
		robot.keyRelease(KeyEvent.VK_G);
		System.out.println("pressed com+shift+g");
		
		robot.delay(2000);
		
		robot.keyPress(KeyEvent.VK_META);
		 
		robot.keyPress(KeyEvent.VK_V);
		 
		robot.keyRelease(KeyEvent.VK_META);
		 
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.delay(2000);
		

		robot.keyPress(KeyEvent.VK_ENTER);
		 
		robot.keyRelease(KeyEvent.VK_ENTER);
		 
		robot.delay(3000);

		
		robot.keyPress(KeyEvent.VK_ENTER);
		 
		robot.keyRelease(KeyEvent.VK_ENTER);
		
//		robot.keyPress(KeyEvent.VK_META);
//		 
//		robot.keyPress(KeyEvent.VK_TAB);
//		 
//		robot.keyRelease(KeyEvent.VK_META);
//		 
//		robot.keyRelease(KeyEvent.VK_TAB);
		
		}
		else
		{
			if(flag){
			robot.keyPress(KeyEvent.VK_META);
			 
			robot.keyPress(KeyEvent.VK_TAB);
			 
			robot.keyRelease(KeyEvent.VK_META);
			 
			robot.keyRelease(KeyEvent.VK_TAB);
			flag=false;
			}
			 
			robot.delay(2000);
			
			robot.keyPress(KeyEvent.VK_META);
			 
			robot.keyPress(KeyEvent.VK_SHIFT);
			 
			robot.keyPress(KeyEvent.VK_G);
			 
			robot.keyRelease(KeyEvent.VK_META);
			 
			robot.keyRelease(KeyEvent.VK_SHIFT);
			 
			robot.keyRelease(KeyEvent.VK_G);
			
			
			robot.keyPress(KeyEvent.VK_META);
			 
			robot.keyPress(KeyEvent.VK_V);
			 
			robot.keyRelease(KeyEvent.VK_META);
			 
			robot.keyRelease(KeyEvent.VK_V);
			
			
			robot.keyPress(KeyEvent.VK_ENTER);
			 
			robot.keyRelease(KeyEvent.VK_ENTER);
			 
			robot.delay(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			 
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_END);
			
			
		}
		
	}

}

