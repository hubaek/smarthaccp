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
import com.ppm.mes.domain.pc.pc400.PurchaseReturn;
import com.ppm.mes.domain.pc.pc400.PurchaseReturnService;
import com.ppm.mes.domain.pc.pc400.PurchaseReturnVO;
import com.ppm.mes.domain.pc.pc410.PurchaseReturnDetailService;
/*
 * 구매반품
 */
@Controller
@RequestMapping(value = "/api/v1/purchaseReturn")
public class PurchaseReturnController extends BaseController {

    @Inject private PurchaseReturnService purchaseReturnService;
    @Inject private PurchaseReturnDetailService purchaseReturnDetailService;
    
    
   	// header
   	@RequestMapping(value = "header", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse header(RequestParams<PurchaseReturnVO> request) {
   		List<PurchaseReturnVO> list = purchaseReturnService.header(request);
   		//UserLogUtil.saveUserLog("PurchaseReturnController","Purchase Return","GET");
   		return Responses.ListResponse.of(list);
   	}
   	
	// 품목별 구매현황
	@RequestMapping(value = "itemList", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse itemList(RequestParams<PurchaseReturnVO> request) {
		List<PurchaseReturnVO> list = purchaseReturnService.itemDetail(request);
		return Responses.ListResponse.of(list);
	}
	
    //임시저장,확정
    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public PurchaseReturn save(@RequestBody PurchaseReturn request) {
    	//UserLogUtil.saveUserLog("PurchaseReturnController","Purchase Return","PUT");
    	return purchaseReturnService.savePurchaseReturn(request);
    } 

    //삭제
    @RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody PurchaseReturn t) {    	
    	//UserLogUtil.saveUserLog("PurchaseReturnController","Purchase Return","DELETE");
    	purchaseReturnDetailService.deleteAll(t);
    	return ok();
    }   
}