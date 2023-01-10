package com.ppm.mes.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 0. Project	: SMART HACCP
 * 1. 작성자  	: 김재민
 * 2. 작성일		: 2020.07.15
 * 3. Comment 	: 메일 전송 
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */


public class MailHandler {
	
	private JavaMailSender sender;
	private MimeMessage message;
	private MimeMessageHelper helper;
	
	//MailHandler 생산자
	public MailHandler(JavaMailSender jSender) throws MessagingException{
		this.sender = jSender;
		message = jSender.createMimeMessage();
		helper = new MimeMessageHelper(message, true, "UTF-8");
		// true => 다수의 사람에게 보낼 수 있는 설정
	}	
	public void setFrom(String email, String name) throws UnsupportedEncodingException, MessagingException{
		helper.setFrom(email, name);
	}	
	// 받는사람
	public void  setTo(String strings) throws MessagingException{
		helper.setTo(strings);
	}
	// 메일 제목
	public void setSubject(String subject) throws MessagingException{
		helper.setSubject(subject);
	}
	// 메일 내용
	public void setText(String text)throws MessagingException{
		helper.setText(text, true); // -> true = html형식도 받아준다.
	}
	public void addInline(String contentId, Resource resource) throws MessagingException{
		helper.addInline(contentId, resource);
	}
	
	public void addInline(String contentId, File file) throws MessagingException{
		helper.addInline(contentId, file);
	}
	
	public void addInline(String contentId, DataSource source) throws MessagingException{
		helper.addInline(contentId, source);
	}
	// 메일을 보내는 메서드
	public void send(){
		try{
			sender.send(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
