package com.hcl.dmu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	private static final Logger log = LoggerFactory.getLogger(EmailService.class);
	
	@Autowired
	private JavaMailSender emailSender;
	
	public void sendSimpleMessage(String from,
		String to, String subject, String text,String bcc, String cc) {
		log.info("Sending mail to "+to);
		SimpleMailMessage message = new SimpleMailMessage(); 
		message.setFrom(from);
		message.setTo(to.split(","));
		message.setSubject(subject); 
		message.setText(text);
		if(cc!=null && !cc.isEmpty())
			message.setCc(cc.split(","));
		if(bcc!=null && !bcc.isEmpty())
			message.setBcc(bcc.split(","));
		
		emailSender.send(message);
	}
}
