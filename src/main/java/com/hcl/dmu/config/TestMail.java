package com.hcl.dmu.config;

import java.io.IOException;

/*import java.io.IOException;
import java.util.Date;
import java.util.Properties;

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
import javax.mail.internet.MimeMultipart;*/

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*sendmail();*/
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			System.out.println(encoder.encode("abc123"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void sendmail() throws MessagingException, IOException {
			String to = "srinivas-p@hcl.com";// change accordingly
			String from = "sekhar.k@hcl.com"; // change accordingly
			String host = "CHN-EXT-RELAY.HCL.COM";// or IP address
			String password = "prabha@7";
			
			Properties properties = System.getProperties();
			properties.put("mail.smtp.auth", "false");
			properties.put("mail.smtp.port", "25");
			properties.put("mail.debug", "true");
			properties.put("mail.smtp.socketFactory.port", "25");
			properties.put("mail.smtp.socketFactory.fallback", "false");
			properties.setProperty("mail.smtp.host", host);
		   
		   Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication(from, password);
		      }
		   });
		   /*Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress(from, false));
		
		   msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		   msg.setSubject("DRP Email Checking");
		   msg.setContent("DRP Sample Email", "text/html");
		   msg.setSentDate(new Date());
		
		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("Hello!!! DRP is able to send am email thank you", "text/html");
		
		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		   MimeBodyPart attachPart = new MimeBodyPart();
		
		   attachPart.attachFile("/var/tmp/image19.png");
		   multipart.addBodyPart(attachPart);
		   msg.setContent(multipart);
		   Transport.send(msg);   */
		   MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Testing DRP Email Message");
			message.setText("Hello!!! This is DRP Team.");

			// Send message
			Transport.send(message);
			System.out.println("message sent successfully....");
		}

}
