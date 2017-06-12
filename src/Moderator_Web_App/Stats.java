package Moderator_Web_App;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
			Thread.sleep(4000);
			
			//Select dropdown1 = new Select(driver.findElement(By.cssSelector("html body div#root div._16oH3vDkJwUqQV5FY2YhEO main div._2JQfo9WA2r6cyJJ9v3cabW div._1qNj5T8seunyaLpMLgtfRe div._3q65UxUb5eKSkA5ji1lFo_ div._3p975IMjWxEi2E4QV723L8 div._2RVbZgHLkx__IXBTBwLkso div.-TUfIFeuy9zMM0PSklia5 div.Select.Select--small.Select--single.is-searchable.has-value div.Select-control span#react-select-3--value.Select-multi-value-wrapper div.Select-value")));
//			WebElement drop_down = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("html body div#root div._16oH3vDkJwUqQV5FY2YhEO main div._2JQfo9WA2r6cyJJ9v3cabW div._1qNj5T8seunyaLpMLgtfRe div._3q65UxUb5eKSkA5ji1lFo_ div._3p975IMjWxEi2E4QV723L8 div._2RVbZgHLkx__IXBTBwLkso div.-TUfIFeuy9zMM0PSklia5 div.Select.Select--small.Select--single.is-searchable.has-value div.Select-control span#react-select-3--value.Select-multi-value-wrapper div.Select-value")));
//			drop_down.click();
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
