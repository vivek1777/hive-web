import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;

import org.apache.bcel.classfile.Constant;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;

import de.sstoehr.harreader.model.HarEntry;
import de.sstoehr.harreader.model.HarLog;
import de.sstoehr.harreader.model.HarPage;
import edu.umass.cs.benchlab.har.HarEntries;
import edu.umass.cs.benchlab.har.HarPages;
import edu.umass.cs.benchlab.har.tools.HarFileReader;

public class Network_Capturing {

	// public static WebDriver driver;
	public static WebDriver driver;
	public String operation_going_to_performed;
//	public String[][] method = new String[20][3];
	public BrowserMobProxyServer server;
	//public HashMap<String, Integer> newmap = new HashMap<String, Integer>();
	public static String msg1;
	int count = 1;

	@BeforeClass
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/viveksingh/Documents/chromedriver");
		server = new BrowserMobProxyServer();
		server.start();
		int port = server.getPort();
		Proxy proxy = ClientUtil.createSeleniumProxy(server);
		DesiredCapabilities seleniumCapabilities = new DesiredCapabilities();
		seleniumCapabilities.setCapability(CapabilityType.PROXY, proxy);
		driver = new ChromeDriver(seleniumCapabilities);
		System.out.println("Port started:" + port);
		msg1 = "Hi All,<br><br><h2 align='center'/>Web APPLICATION & API AUTOMATION REPORT</h2><div><div align='center'></div><br>";
		msg1 += "<br><h3 align=\"center\"><i>Test Execution Details </i></h3>"
				+ "<table style=\"height:100%\" bordercolor='BLACK' border='1' cellpadding='7' cellspacing='0' align='center'>" + "<tr>"
				+ "<th align='center' color='white' bgcolor='#F5DA81'>S.No.</th>"
				+ "<th align='center' color='white' bgcolor='#F5DA81'>Operation Performed</th>"
				+  "<th align='center' color='white' bgcolor='#F5DA81'>Method</th>"
				+  "<th align='center' color='white' bgcolor='#F5DA81'>API Name</th>"
				+ "<th align='center' color='white' bgcolor='#F5DA81'>STATUS CODE</th>"
				+ "</tr>";
	}

	
	@Test(priority = 1)
	public void Signup_Test() throws InterruptedException, IOException {

		server.newHar("experiment1.har");
		operation_going_to_performed = "Signup / Register";
		Signup go_signup = new Signup(driver);
		go_signup.signup();
		System.out.println("GOing to read HAR file for Signup");

		Har har = server.getHar();
		Thread.sleep(5000);
		File harFile = new File("/Users/viveksingh/Documents/Animals/experiment1.har");
		har.writeTo(harFile);
		ReadHarFile("experiment1.har", operation_going_to_performed);

	}
	
	@Test(priority = 2)
	public void Practice_task() throws IOException, InterruptedException
	{
		 server.newHar("experiment6.har");
			operation_going_to_performed = "Practice Task Completion";
			Practice_Task practice_task_object = new Practice_Task(driver);
			practice_task_object.practiceTaskCompletion();
			//System.out.println("Going to read HAR file for Profile");

			Har har = server.getHar();
			Thread.sleep(10000);
			File harFile = new File("/Users/viveksingh/Documents/Animals/experiment6.har");
			har.writeTo(harFile);
			ReadHarFile("experiment6.har", operation_going_to_performed);
	}
	
	@Test(priority = 3)
	public void Profile() throws InterruptedException, IOException {

		 server.newHar("experiment2.har");
		operation_going_to_performed = "Profile Page";
		Profile profile_object = new Profile(driver);
		profile_object.profile();
		System.out.println("Going to read HAR file for Profile");

		Har har = server.getHar();
		Thread.sleep(5000);
		File harFile = new File("/Users/viveksingh/Documents/Animals/experiment2.har");
		har.writeTo(harFile);
		ReadHarFile("experiment2.har", operation_going_to_performed);
	}
	
	@Test(priority = 4)
	public void Statistics() throws InterruptedException, IOException {

		 server.newHar("experiment3.har");
		operation_going_to_performed = "Stats";
		Stats stats_object = new Stats(driver);
		stats_object.statsStic();
		System.out.println("Going to read HAR file for Profile");

		Har har = server.getHar();
		Thread.sleep(5000);
		File harFile = new File("/Users/viveksingh/Documents/Animals/experiment3.har");
		har.writeTo(harFile);
		ReadHarFile("experiment3.har", operation_going_to_performed);
	}
	
	@Test(priority = 5)
	public void Contact_Us_Test() throws InterruptedException, IOException {

		 server.newHar("experiment4.har");
		operation_going_to_performed = "Contact Us";
		Contact_Us contactus = new Contact_Us(driver);
		contactus.contactUs();
		System.out.println("GOing to read HAR file for Contact Us");

		Har har = server.getHar();
		Thread.sleep(5000);
		File harFile = new File("/Users/viveksingh/Documents/Animals/experiment4.har");
		har.writeTo(harFile);
		ReadHarFile("experiment4.har", operation_going_to_performed);
	}
	
	
//	@Test(priority = 2) //5
//	public void browserRefresh() throws InterruptedException
//	{
//		driver.navigate().refresh();
//		Thread.sleep(6000);
//	}
	
	
	
	@Test(priority = 6)//6
	public void Login_Test() throws InterruptedException, IOException {

		server.newHar("experiment7.har");
		operation_going_to_performed = "Login";
		Login go_login = new Login(driver);
		go_login.login();
		System.out.println("GOing to read HAR file for Login");
		
		 Har har = server.getHar();
		 Thread.sleep(5000);
		 File harFile = new File("/Users/viveksingh/Documents/Animals/experiment7.har");
		 Thread.sleep(2000);
		 har.writeTo(harFile);
		 ReadHarFile("experiment7.har",operation_going_to_performed );
	}
	
	@Test(priority = 7)//7
	public void Moderation_task() throws InterruptedException, IOException
	{
		 server.newHar("experiment8.har");
			operation_going_to_performed = "Moderation Task Completion";
			Moderate_Task moderate_task_object = new Moderate_Task(driver);
			moderate_task_object.moderatingTask();
			System.out.println("Going to read HAR file for Profile");

			Har har = server.getHar();
			File harFile = new File("/Users/viveksingh/Documents/Animals/experiment8.har");
			
			har.writeTo(harFile);
			ReadHarFile("experiment8.har", operation_going_to_performed);
	}

	@AfterClass
	public void shutdown() {
		driver.quit();
		server.stop();
		Mailing_Report mail_report = new Mailing_Report();
		msg1 += "</table>" + "</div>";
		//System.out.println(msg1);
		mail_report.sendReport(msg1);
	}

	public void ReadHarFile(String fileName, String operation_performed) {

		File f = new File("/Users/viveksingh/Documents/Animals/" + fileName);
		HarFileReader r = new HarFileReader();
		HashMap<String, Integer> newmap = new HashMap<String, Integer>();
		String[][] method = new String[20][3];

		try {
			System.out.println(f);
			edu.umass.cs.benchlab.har.HarLog log = r.readHarFile(f);
			HarPages pages = log.getPages();
			long startTime = pages.getPages().get(0).getStartedDateTime().getTime();
			System.out.println("page start time: " + startTime);
			HarEntries entries = log.getEntries();
			List<edu.umass.cs.benchlab.har.HarEntry> hentry = entries.getEntries();
			
			
			long loadTime = 0;
			int methoud_count =0;
			long responseSize = 0;
			int entryIndex = 0;
			for (edu.umass.cs.benchlab.har.HarEntry entry : hentry) {
				if (entry.getRequest().getUrl().contains("/register") || entry.getRequest().getUrl().contains("/login")
						|| entry.getRequest().getUrl().contains("/profile")
						|| entry.getRequest().getUrl().contains("/jobs")
						|| entry.getRequest().getUrl().contains("/contact_us")
						|| entry.getRequest().getUrl().contains("/update_password")
						|| entry.getRequest().getUrl().contains("/payment")
						|| entry.getRequest().getUrl().contains("/session")
						|| entry.getRequest().getUrl().contains("/feed")
						|| entry.getRequest().getUrl().contains("/timeseries")) {
					System.out.println("entry: " + entryIndex);
					System.out.println("request url: " + entry.getRequest().getUrl());
					System.out.println("Request Method: " + entry.getRequest().getMethod());
					newmap.put(entry.getRequest().getUrl(), entry.getResponse().getStatus());
					for(int k=0;k<=2;k++)
					{
						if(k==0)
							method[methoud_count][k] = entry.getRequest().getMethod();	
						if(k==1)
							method[methoud_count][k] = entry.getRequest().getUrl();
						if (k==2)
						method[methoud_count][k] = String.valueOf(entry.getResponse().getStatus());	
					}
					System.out.println("response code: " + entry.getResponse().getStatus());
					System.out.println();
					entryIndex++;
					methoud_count++;
				}
				
				
				
				long entryLoadTime = entry.getStartedDateTime().getTime() + entry.getTime();

				if (entryLoadTime > loadTime) {
					loadTime = entryLoadTime;
				}

			}
			System.out.println(newmap);
			Iterator it = newmap.entrySet().iterator();
			int temp =1;
			int local_count=0;
			
	
			
			msg1 += "<tr>" + "<td align='center' rowspan = \""+methoud_count+"\" color='white' bgcolor='#e5ede3'>"+ count + "</td>"
					+ "<td align='center' rowspan = \""+methoud_count+"\" color='white' bgcolor='#e5ede3'>"+ operation_performed + "</td>";
			

			for(int p=0;method[p][0] != null; p++)
			{
				if(p!=0)
					msg1 += "<tr>";
				
				System.out.println(method[p][0]);System.out.println(method[p][1]);System.out.println(method[p][2]);
				
				msg1  +=  "<td align='center' color='white' bgcolor='#e5ede3'>" + method[p][0] + "</td>"
						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + method[p][1] + "</td>"
						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + method[p][2] + "</td>"
						+ "</tr>";
				
				
			}
			count++;
				
			
//			if (newmap.size() > 1) {																			
//				msg1 += "<tr>" + "<td align='center' rowspan =\""+newmap.size()+"\" color='white' bgcolor='#e5ede3'>"+ count + "</td>"
//						+ "<td align='center' rowspan =\""+newmap.size()+"\" color='white' bgcolor='#e5ede3'>"+ operation_performed + "</td>";
//				while (it.hasNext()) {
//					HashMap.Entry pair = (HashMap.Entry) it.next();
//					if( temp == 1 )
//					{
//					msg1  +=  "<td align='center' color='white' bgcolor='#e5ede3'>" + method[local_count] + "</td>"
//							+ "<td align='center' color='white' bgcolor='#e5ede3'>" + pair.getKey() + "</td>"
//							+ "<td align='center' color='white' bgcolor='#e5ede3'>" + pair.getValue() + "</td>"
//							+ "</tr>";
//					temp++;
//					local_count++;
//					}
//					else
//					{				
//							msg1  +=  "<tr>" + "<td align='center' color='white' bgcolor='#e5ede3'>" + method[local_count] + "</td>"
//									+"<td align='center' color='white' bgcolor='#e5ede3'>" + pair.getKey() + "</td>"
//									+ "<td align='center' color='white' bgcolor='#e5ede3'>" + pair.getValue() + "</td>"
//									+ "</tr>";
//							temp++;
//							local_count++;					
//					}				
//				}
//				count++;
//			}
//			else {
//				HashMap.Entry pair = (HashMap.Entry) it.next();
//				msg1 += "<tr>" + "<td align='center' color='white' bgcolor='#e5ede3'>" + count + "</td>"
//						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + operation_performed + "</td>"
//						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + method[local_count] + "</td>"
//						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + pair.getKey() + "</td>"
//						+ "<td align='center' color='white' bgcolor='#e5ede3'>" + pair.getValue() + "</td>" 
//						+ "</tr>";
//				count++;
//				local_count++;
//						
//			}
			
			
			
			
			
			System.out.println(msg1);
			long loadTimeSpan = loadTime - startTime;
			System.out.println("loadTimeSpan: " + loadTimeSpan);
			Double webLoadTime = ((double) loadTimeSpan) / 1000;
			double webLoadTimeInSeconds = Math.round(webLoadTime * 100.0) / 100.0;
			System.out.println("Web Load Time: " + webLoadTimeInSeconds);

		} catch (JsonParseException e) {
			e.printStackTrace();
			System.out.println("Parsing error during test");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO exception during test");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
