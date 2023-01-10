package com.ppm.mes.utils;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.mail.MessagingException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendMail {
	
	@Inject private JavaMailSender sender;
	private String stmp = "23";
	
	
	@Scheduled(fixedDelay = 20000)
	public void SendTest() throws UnsupportedEncodingException, MessagingException {
		if(stmp != null && Integer.parseInt(stmp) < 22){
//			String memberMail = "rlawoals5704@naver.com,k003o85894o4@gmail.com";			
			try{
				MailHandler mail = new MailHandler(sender);
				mail.setFrom("k003o85894o4@gmail.com", "김재민 사원");
				mail.setTo("rlawoals5704@naver.com");
				mail.setSubject("mail 전송 Test");
				mail.setText(new StringBuffer().append("<h1>Mail 전송 테스트</h1>")
						.append("<p>밑의 링크를 클릭하면 관리 페이지로 넘어갑니다.<p>")
						.append("<table><tr><td>온도</td><td> 22도 </td></tr></table>")
						.append("<a href='localhost:8080'>관리페이지</a>").toString());
//				mail.setText("mail 전송테스트");
				mail.send();				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		
		}
	}
}
