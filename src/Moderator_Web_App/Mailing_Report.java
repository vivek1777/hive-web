package Moderator_Web_App;



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
		
		String subject = "Hive Automation Report";
		boolean sessionDebug = false;
		String host = "smtp.gmail.com";
		String user = "vivek.singh@kiwi.qa";
		
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		// props.put("mail.smtp.socketFactory.fallback", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
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
			message.setContent(multipart);

			//String recipi = "vivek.singh@kiwi.qa ,mukul.bhaisora@kiwi.qa,surakhshit.pawanotra@kiwi.qa";
			String recipi = "vivek.singh@kiwi.qa";
			String[] recipientList = recipi.split(",");
			InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
			int counter = 0;
			for (String recipient : recipientList) {
				recipientAddress[counter] = new InternetAddress(recipient.trim());
				counter++;
			}
			message.setRecipients(Message.RecipientType.TO, recipientAddress);

			message.setSubject(subject);

			message_for_mail = msg1;

			message.setContent(message_for_mail, "text/html; charset=utf-8");
			Transport.send(message);

			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			System.out.println(e);
		}

	} 

}

