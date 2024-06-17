package com.raj.utill;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender 	mailSender;
	
	public boolean sendMail1(String subject,String body,String to,File f) {
		try {
			//System.out.println("file name data-----------------"+f);
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setSubject(subject);
			helper.setText(body,true);
			helper.addAttachment("Plans_info", f );
			helper.setTo(to);
			mailSender.send(mimeMessage);
			System.out.println("file name data-----------------"+f);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		return true;
	}

}
