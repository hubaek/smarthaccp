package com.ppm.mes.domain.scheduler;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import com.ppm.mes.domain.haccp.metal.detail.HaccpMetalDetailMapper;
import com.ppm.mes.domain.haccp.metal.master.HaccpMetalMasterMapper;

import com.ppm.mes.domain.haccp.temp.detail.HaccpTempDetailMapper;
import com.ppm.mes.domain.haccp.temp.master.HaccpTempMasterMapper;
import com.ppm.mes.domain.lmt.master.LmtMasterMapper;
import com.ppm.mes.domain.lmt.master.LmtMasterVO;
import com.ppm.mes.domain.user.user000.UserVO;
import com.ppm.mes.utils.MailHandler;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;



@Service
public class SchedulerService {
	@Inject private SchedulerMapper schmapper;
	@Inject private LmtMasterMapper lmtMasterMapper;
	@Inject private JavaMailSender sender;
	
	Date now = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	String time1 = format.format(now);		// 중복검사 and list 호출용
	int time2 = Integer.parseInt(time1)- 1;				// test용
	String time3 = format2.format(now); 	// created-at용
	
	Map<String, String> map = new HashMap<>();
	
	/*
	 * 한계기준이탈체크 및 메일전송(renewal)
	 * 한계기준 테이블(tb_mes_lmt000) column 추가 
	 *     1)LMTCHKTIME(INT)  - 실서버 이탈체크시간
	 *     2)TESTCHKTIME(INT) - 테스트 이탈체크시간
	 * process : 1.등록된 한계기준 List조회 -> 2.가장 최근 게더링데이터를 조회  -> 3.한계기준이탈 check -> 4.메일전송처리
	 *
	 */
	
	 @Value("${alert.mail.fromAddress}")
	   String fromAddress;
		
	 @Value("${alert.domain.url}")
	   String domainUrl;
	
	public void limitCheckTemp(String yyyyMMdd) {
		
		System.out.println("********************************************");
 		System.out.println("********************************************");
 		System.out.println("fromAddress : " + fromAddress);
 		System.out.println("domainUrl : " + domainUrl);
 		System.out.println("********************************************");
 		System.out.println("********************************************");
		
		//1.등록된 한계기준 List조회
		Map<String, String> LmtparamMap = new HashMap<>();
		LmtparamMap.put("emailYn", "Y");
		LmtparamMap.put("prcsslmtId", "TEMP");
		List<LmtMasterVO> ccpList = lmtMasterMapper.getLmtList(LmtparamMap);
		
		int chktime;
		
		try{
			Map<String, String> CCPparamMap = new HashMap<>();
			for(int k = 0; k < ccpList.size(); k++){
				LmtMasterVO lmtVo = ccpList.get(k);
				CCPparamMap.put("ccpId", lmtVo.getPrcsslmtId());

				//2.가장 최근 게더링데이터를 조회 
				Map<String, String> lastsensingData = schmapper.getlastsensingdata(CCPparamMap);
				String value  = String.valueOf(lastsensingData.get("value"));  //값
				String lmtmin = String.valueOf(lastsensingData.get("lmtmin")); //한계기준 최솟값
				String lmtmax = String.valueOf(lastsensingData.get("lmtmax")); //한계기준 최댓값
				String lmtchktime  = String.valueOf(lastsensingData.get("lmtchktime"));  //실서버 이탈체크시간
				String testchktime = String.valueOf(lastsensingData.get("testchktime")); //개발 및 테스트서버 이탈체크시간
				
				//3.한계기준이탈 check
				boolean pass = true; //한계기준이탈 check값 (true : 정상, false : 이탈)
				if(!value.equals("") && value != null){
					Double dblval = Double.parseDouble(value);
					if(!lmtmin.equals("") && lmtmin != null && lmtmin != "null"){
						Double dblmin = Double.parseDouble(lmtmin);
						if(dblval < dblmin){ //최솟값보다 작은경우(한계기준이탈)
							pass = false;
						}
					}
					if(!lmtmax.equals("") && lmtmax != null && lmtmax != "null"){
						Double dblmax = Double.parseDouble(lmtmax);
						if(dblmax < dblval){ //최댓값보다 큰경우(한계기준이탈)
							pass = false;
						}
					}
				}
				
				/*
				 * ip로 Server or Local구분
				 * Server ip 패턴은 172.27.0.*
				 */
				String hostAddr = InetAddress.getLocalHost().getHostAddress();
				System.out.println("hostAddr : " + hostAddr);
				boolean isServer = hostAddr.contains("172.27.0");
				System.out.println("isServer : " + isServer);
				
				if(isServer){//Server
					System.out.println("Server");
					CCPparamMap.put("site", "server");
					chktime = Integer.parseInt(lmtchktime) + 1;
				}else{//Local 및 기타
					System.out.println("Local 및 기타");
					CCPparamMap.put("site", "etc");
					chktime = Integer.parseInt(testchktime) + 1;
				}
				
				//4.메일전송처리
				if(!pass){
					schmapper.updatetime(CCPparamMap);
				
					if(chktime > 29){/*30분 이후 메일 전송*/
						List<UserVO> userList = schmapper.getUserPhoneList();
						System.out.println("*****************************");
						System.out.println("한계기준이 30분이상 지속");
						
						boolean send = false;
						Integer mst = lmtVo.getMst(); //한계기준 주기알람값(MailSendTime)
						if(mst == null){ mst = 1; }
						System.out.println("이탈 알림 메일전송주기 : " + mst + "분");
						
						if(chktime == 30){send = true;}//최초로 1번 전송
						else if((chktime%mst) == 0){send = true;}//30분 이후 주기적으로 전송(주기는 한계기준정보 화면에서 setting)
						
						if(send){
							StringBuffer mailText = new StringBuffer();
							mailText.append("<h1>한계기준 이탈</h1>");
							mailText.append("<br>한계기준이 30분이상 지속</br>");
							mailText.append("<br>" + "이탈 알림 메일전송주기 : " + mst + "분" + "</br>");
							mailText.append("<br>"+"메일내용"+"</br>");
							mailText.append("<br>[" + lmtVo.getPrcsslmtNm() + "]</br>");
							mailText.append("<br>"+"마지막이탈시간 : " + String.valueOf(lastsensingData.get("dtm")) + "</br>");
							mailText.append("<br>"+"마지막이탈데이터 : " + value + "°C</br>");
							mailText.append("<br>한계기준이탈 후 30분이내 원복되지 않았습니다.</br>");
							mailText.append("<p>밑의 링크를 클릭하면 관리 페이지로 넘어갑니다.</p>");
							mailText.append("<a href='"+ domainUrl +"'>관리페이지</a>"); 
							
							
							if(isServer){
								for(UserVO userVo : userList){
							    	String email = userVo.getEmail();
									MailHandler mail = new MailHandler(sender);
									
									mail.setFrom(fromAddress,"스마트해썹앤팩토리");
									mail.setTo(email);
									mail.setSubject("["+lmtVo.getPrcsslmtNm()+"]한계기준 이탈");
									mail.setText(mailText.toString()); 
									mail.send();
								}
							}else{
								MailHandler mail = new MailHandler(sender);
								mail.setFrom(fromAddress,"스마트해썹앤팩토리");
								mail.setTo("smarthaccp.factory@gmail.com");
								mail.setSubject("["+lmtVo.getPrcsslmtNm()+"]한계기준 이탈");
								mail.setText(mailText.toString()); 
								mail.send();
							}
						}
					}
				}else{
					schmapper.cleartime(CCPparamMap);//정상값으로 돌아오면 체크시간 초기화
				}
				
			}
		}catch (Exception e){
			e.printStackTrace();
		}  
	}
}
