package com.ppm.mes.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ppm.mes.domain.scheduler.SchedulerService;
import com.ppm.mes.domain.user.userlog.UserLogService;



@Component
@EnableScheduling
public class SchedulerController {
   
   @Autowired
   private SchedulerService schService;
   
   @Autowired
   private UserLogService userlogservice;
   
/**
 * 
 *    cron 설정방법
 * - 사용 예
 *     0 0 12 * * *           ==> 매일 12시에 실행
 *      0 15 10 * * *         ==> 매일 10시 15분에 실행
 *      0 * 14 * * *           ==> 매일 14시에 실행
 *      0 0/5 14 18 * * *    ==> 매일 14시, 18시에 시작해서 5분간격으로 실행
 *      0 0-5 14 * * *        ==> 매일 14시에 시작해서 0분동안 실행
 *     초 분 시 주 월 년
 */
  
	  
   		
      //한계기준 이탈 알림메일 스케줄러
      @Scheduled(fixedDelay = 1000 * 60)
      public void ScheduleLimit(){
         System.out.println("********스케쥴러 30분 시작*******");
         Date now = new Date();
         SimpleDateFormat format = new SimpleDateFormat("HH시mm분ss초");
         SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
         String time = format.format(now);
         String yyyyMMdd = format2.format(now);
         try{
        	
        	 //schService.limitCheckTemp(yyyyMMdd); //한계기준이탈
         }catch(Exception e){
            e.printStackTrace();
         }
      }
      
      //log 및 kpi 전송 스케줄러
      @Scheduled(cron = "0 0 23 * * *")
      public void sendLogSchedule(){
         System.out.println("********매일 23시에 log 전송*******");

         try{
        	 //userlogservice.SendLogData();
         }catch(Exception e){
            e.printStackTrace();
         }
      }
}
