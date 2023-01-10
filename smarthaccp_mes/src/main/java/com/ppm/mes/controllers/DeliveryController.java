package com.ppm.mes.controllers;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.controllers.BaseController;
import com.ppm.mes.domain.dvr.DeliveryService;
@Controller
@RequestMapping(value = "/api/v1/Delivery")
public class DeliveryController extends BaseController{
	
	@Inject private DeliveryService service;
	
	@RequestMapping(value ="/detail", method = RequestMethod.GET,  produces = APPLICATION_JSON)
	public List<Map<String, String>> getDeliveryDetailList(String num, String company) throws Exception{
		
		String var = num;
		List<Map<String, String>> list = service.getDeliveryDetailList(var, company);		
		 /*
		  for (Map<String, String> map : list){
			 	System.out.println("----------------------- detail 시작-----------------------------");	
			 	System.out.println("위치 : "+map.get("LOC"));
	        	System.out.println("상태 : "+map.get("STATUS"));
	        	System.out.println("시간 : "+map.get("TIME"));
	        	System.out.println("상세내용 : "+map.get("DESC"));
	        	System.out.println("----------------------- detail 종료-----------------------------");	
	        }
	     */
		return list; 
	}
	@RequestMapping(value ="/master", method = RequestMethod.GET,  produces = APPLICATION_JSON)
	public List<Map<String, String>> getDeliveryMasterList(String num, String company) throws Exception{
		
		String var = num;
		List<Map<String, String>> list = service.getDeliveryMasterList(var, company);		
		return list; 
	}
}
