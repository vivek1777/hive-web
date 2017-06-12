package Moderator_Web_App;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mailing_Report {

	public String message_for_mail;
	@SuppressWarnings("rawtypes")
	public void sendReport(String msg1)
	{
		System.out.println("Finally! Going to send email");
		String host = "smtp.gmail.com";
		String user = "vineet1777.vs@gmail.com";
		String password = "vinny@sbi";
		//String to = "vineet1777@yahoo.com";
		String to = "amitrana.iit.93@gmail.com";
		String from = "vineet1777.vs@gmail.com";
		String subject = "Automation Report";
		//String messagetext = "Hi, Please find attached report";
		boolean sessionDebug = false;

		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.socketFactory.port", "587");   
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");   
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		//props.put("mail.smtp.socketFactory.fallback", "true");

		Session session = Session.getDefaultInstance(props,    
				new javax.mail.Authenticator() {    
			protected PasswordAuthentication getPasswordAuthentication() {    
				return new PasswordAuthentication(from,password);  
			}    
		});    


		try {    
			MimeMessage message = new MimeMessage(session);  

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("This is message body");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			String filename = "/Users/viveksingh/Documents/workspace/Practise/test-output/index.html";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart );




			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
			message.setSubject(subject);   


			message_for_mail = msg1;
//			msg1 = "Hi All,<br><br><h2 align='center'/>MOBILE APPLICATION ADS AUTOMATION REPORT</h2><div><div align='center'></div><br>";
//			msg1 += "<br><h3 align=\"center\"><i>Test Execution Details </i></h3>"
//					+ "<table bordercolor='BLACK' border='1' cellpadding='10' cellspacing='0' align='center'>"
//					+ "<tr>"
//					+ "<th align='center' color='white' bgcolor='#F5DA81'>S.No.</th>"
//					+ "<th align='center' color='white' bgcolor='#F5DA81'>API NAME</th>"
//					+ "<th align='center' color='white' bgcolor='#F5DA81'>STATUS CODE</th>"
//					//+ "<th align='center' color='white' bgcolor='#F5DA81'>REQUEST PARAMETERS</th>"
//					+ "</tr>";
			
//			HashMap<String, String> newmap = new HashMap<String, String>();
//			newmap.put("/register", "200");
//			newmap.put("/login", "200");
//			newmap.put("/profile", "500");
//			int count = 1;
//			Iterator it = newmap.entrySet().iterator();
//			while (it.hasNext()) {
//				HashMap.Entry pair = (HashMap.Entry)it.next();
//				msg1 += "<tr>"
//						+ "<td align='center' color='white' bgcolor='#e5ede3'>"+count+"</td>"
//						+ "<td align='center' color='white' bgcolor='#e5ede3'>"+pair.getKey()+"</td>"
//						+ "<td align='center' color='white' bgcolor='#e5ede3'>"+pair.getValue()+"</td>";
//				count++;
//		        //it.remove(); // avoids a ConcurrentModificationException
//		    }
			
				
			

			message.setContent(message_for_mail, "text/html; charset=utf-8");
			//message.setText(messagetext);
			Transport.send(message);

			//send message  
			//System.out.println("Finally! Going to send email");
			//Transport.send(message);    
			System.out.println("message sent successfully");    
		} catch (MessagingException e) {
			System.out.println(e);
		}
		//throw new RuntimeException(e);}    

	} 




}

