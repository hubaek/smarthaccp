package com.ppm.mes.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chequer.axboot.core.controllers.BaseController;
import com.ppm.mes.domain.erp.ErpService;

@Controller
@RequestMapping(value = "/api/v1/erp")
public class ErpController extends BaseController {
	
	@Autowired
	private ErpService erpservice;
	
	@RequestMapping(value = "/SyncErpData" , method = RequestMethod.GET, produces = APPLICATION_JSON)
    public void SyncErpData(@RequestParam Map<String,Object> requestParams) {
		try{
			//테이블 별로 서비스 추가
			//1. 공통코드(ERP, MES 따로 처리)
			//erpservice.syncTbMesCd000(requestParams);
			//erpservice.syncTbMesCd100(requestParams);
			
			//2. 품목
			erpservice.syncTbMesItem000(requestParams);
			erpservice.syncTbMesItem100(requestParams);
			erpservice.syncTbMesItem150(requestParams);
			
			//3. 발주 및 구매
			erpservice.syncTbMesPc200(requestParams);
			erpservice.syncTbMesPc210(requestParams);
			erpservice.syncTbMesPc300(requestParams);
			erpservice.syncTbMesPc310(requestParams);
			
			//4. BOM
			erpservice.syncTbMesBom000(requestParams);
			erpservice.syncTbMesBom100(requestParams);
			
			//5. 설비
			erpservice.syncTbMesEq000(requestParams);
			
			//6. 주문 및 판매
			erpservice.syncTbMesSa300(requestParams);
			erpservice.syncTbMesSa310(requestParams);
			erpservice.syncTbMesSa400(requestParams);
			erpservice.syncTbMesSa410(requestParams);
			
			//7.거래처
			erpservice.syncTbMesCust000(requestParams);
			
			//8.품목 거래처별 판매단가
			erpservice.syncTbMesPr200(requestParams);

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
    }	  
}
