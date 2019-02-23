package com.hcl.dmu.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.hcl.dmu.email.service.EmailConfigurationService;
import com.hcl.dmu.email.vo.EmailVo;

@Configuration
public class EmailConfigurationComponent{

	@Autowired
	private EmailConfigurationService emailSevice;

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public JavaMailSender getJavaMailSender() {

		EmailVo emailVo = emailSevice.getEmailDetails();
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		if (emailVo != null) {
			String host = emailVo.getHost();
			String username = emailVo.getUsername();
			String password = emailVo.getPassword();
			Boolean auth = emailVo.getAuth();
			Boolean enableStartTLS = emailVo.getEnableStartTLS();
			Boolean debug = emailVo.getDebug();
			if (host != null)
				mailSender.setHost(emailVo.getHost());
			if (emailVo.getPort() != null)
				mailSender.setPort(emailVo.getPort().intValue());
//			if (username != null)
//				mailSender.setUsername(username);
//			if (password != null)
//				mailSender.setPassword(password);
			
			Properties props = mailSender.getJavaMailProperties();
			props.put("mail.smtp.auth", "false");
			props.put("mail.smtp.port", "25");
			props.put("mail.debug", "true");
			props.put("mail.smtp.socketFactory.port", "25");
			props.put("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.host", host);
			return mailSender;
		}else{
			//Fall back email properties if email properties are not present in DB
			mailSender.setHost("smtp.gmail.com");
			mailSender.setPort(587);
			mailSender.setUsername("dummy-noreply@gmail.com");
			mailSender.setPassword("password");
			Properties props = mailSender.getJavaMailProperties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.debug", "true");
			return mailSender;			
		}

	}
}
