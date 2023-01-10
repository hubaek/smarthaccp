package com.ppm.mes.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ppm.mes.domain.file.CommonFile;

@Component
public class MailConfig {

  	@Autowired public JavaMailSender mailSender;
  	
  	
  	public void sendMail(String fName , String fEmail , String tName , String tEmail,String mTitle, String mContents,List<CommonFile> files){

		String mailProtocol = "smtp";
		String mailHost = "ezsmtp.bizmeka.com";
		String mailPort = "587";
		String mailId = "jeon.jy@8pmbiz.com";
		String mailPassword = "roqkf12#";
		
		String fromName = fName;
		String fromEmail = fEmail; // 보내는 사람 메일
		String toEmail = tEmail; // 받는사람메일
		String mailTitle = mTitle;
		String mailContents = mContents;
		String debugMode = "false";
		String authMode = "true";

	try {
			boolean debug = Boolean.valueOf(debugMode).booleanValue();
			Properties mailProps = new Properties();
			mailProps.put("mail.smtp.starttls.enable", "true");
			mailProps.setProperty("mail.transport.protocol", mailProtocol); 
			mailProps.put("mail.debug", debugMode);
			mailProps.put("mail.smtp.host", mailHost);
			mailProps.put("mail.smtp.port", mailPort);
			mailProps.put("mail.smtp.connectiontimeout", "5000");
			mailProps.put("mail.smtp.timeout", "5000");  
			mailProps.put("mail.smtp.auth", authMode);
			
			Session msgSession = null;

			if(authMode.equals("true")) {
		        Authenticator auth = new MyAuthentication(mailId, mailPassword);
				msgSession = Session.getInstance(mailProps, auth);
			} else {
				msgSession = Session.getInstance(mailProps, null); 
			}

			msgSession.setDebug(debug);			
			MimeMessage message = new MimeMessage(msgSession);
			message.setFrom(new InternetAddress(fromEmail, fromName));

			String[] toEmails = toEmail.split(",");
			InternetAddress[] toAddr = new InternetAddress[toEmails.length]; 
			
			int addIdx = 0;
	    	for (String c : toEmails) {
				toAddr[addIdx] = new InternetAddress (c); 
				addIdx++;
	    	}

			message.setRecipients(Message.RecipientType.TO, toAddr);
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");            
            messageHelper.setSubject(mailTitle);            
            String htmlContent = mailContents;
            
            messageHelper.setText(htmlContent, true);      			
            
            if(null != files){     		
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Calendar cal = Calendar.getInstance();
                String fildDt = sdf.format(cal.getTime());
                
        		int attachCnt = 1;
            	for (CommonFile file : files) {       
            		String fileNm = file.getFileNm();
            		String extension = FilenameUtils.getExtension(fileNm);
                    DataSource dataSource = new FileDataSource(file.getSaveNm());     
                	fileNm = "첨부_" + fildDt +"_" + attachCnt;
                    fileNm = fileNm + "." + extension;
                    messageHelper.addAttachment(MimeUtility.encodeText(fileNm, "UTF-8", "B"), dataSource);
                	attachCnt++;
            	}
            }
            
			// 스태틱함수로 직접 보내지 않고 객체를 이용해서 보내고 객체를 닫아준다. 
			Transport t = msgSession.getTransport(mailProtocol);
			try {
				t.connect();
				t.sendMessage(message, message.getAllRecipients());
			} finally {
			  t.close();
			}
		} catch(Exception e) {

			e.printStackTrace();

		}
	}

  	public void sendSignMail(String signCode,String categoryName, Long apprSeq , String apprType, String noApprType){
  		String fName = "DPIN 전자결재시스템";
  		String fEmail = "sign@8pmbiz.com";
  		/*
        RequestParams<SignMasterVO> requestParams = new RequestParams<>(SignMasterVO.class);
        requestParams.put("signCode", signCode);
        requestParams.put("apprSeq", apprSeq);
        requestParams.put("apprType", apprType);
        requestParams.put("noApprType", noApprType);
        
  		List<SignMasterVO> users = signMasterService.getSignMasterUserList(requestParams);
  		if(null != users){
            for (SignMasterVO c : users) {
            	sendMail(fName , fEmail , c.getApprUserNm() , c.getApprEmail(),"["+categoryName+"] "+c.getSignTitle(), c.getSignContents(),null);
            }
  		}
  		*/
  	}
  	
  	
    class MyAuthentication extends Authenticator {
        PasswordAuthentication pa;
        public MyAuthentication(String mailId, String mailPass) {
            pa = new PasswordAuthentication(mailId, mailPass);  
        }
        @Override
		public PasswordAuthentication getPasswordAuthentication() {
            return pa;
        }
    }  
}