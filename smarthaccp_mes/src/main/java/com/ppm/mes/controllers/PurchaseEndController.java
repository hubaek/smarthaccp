package com.ppm.mes.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.pc.pc500.PurchaseEnd;
import com.ppm.mes.domain.pc.pc500.PurchaseEndService;
import com.ppm.mes.domain.pc.pc500.PurchaseEndVO;
import com.ppm.mes.domain.pc.pc510.PurchaseEndDetailService;
/*
 * 매입마감
 */
@Controller
@RequestMapping(value = "/api/v1/purchaseEnd")
public class PurchaseEndController extends BaseController {

    @Inject private PurchaseEndService purchaseEndService;
    @Inject private PurchaseEndDetailService purchaseEndDetailService;
    
   	// header
   	@RequestMapping(value = "header", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse header(RequestParams<PurchaseEndVO> request) {
   		List<PurchaseEndVO> list = purchaseEndService.header(request);
   		//UserLogUtil.saveUserLog("PurchaseEndController","Purchase End","GET");
   		return Responses.ListResponse.of(list);
   	}
   	
	// 품목별 구매현황
	@RequestMapping(value = "itemList", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse itemList(RequestParams<PurchaseEndVO> request) {
		List<PurchaseEndVO> list = purchaseEndService.itemDetail(request);
		return Responses.ListResponse.of(list);
	}

    //임시저장,확정
    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public PurchaseEnd save(@RequestBody PurchaseEnd request) {
    	//UserLogUtil.saveUserLog("PurchaseEndController","Purchase End","PUT");
    	return purchaseEndService.savePurchaseEnd(request);
    } 
    
    //삭제
    @RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody PurchaseEnd t) {    			
    	//UserLogUtil.saveUserLog("PurchaseEndController","Purchase End","DELETE");
    	purchaseEndDetailService.deleteAll(t);
    	return ok();
    }     	
}