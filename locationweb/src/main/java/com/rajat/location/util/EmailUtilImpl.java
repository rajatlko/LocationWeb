package com.rajat.location.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilImpl implements EmailUtil { 
	// An object of component class will create at run time and we will inject it in other class
	@Autowired
	private JavaMailSender sender;
	
	public void sendEmail(String toAddress, String subject, String body) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try {
			helper.setTo(toAddress);
			helper.setSubject(subject);
			helper.setText(body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		sender.send(message);
		}

}
