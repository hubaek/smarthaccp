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
import com.ppm.mes.domain.pc.pc300.Purchase;
import com.ppm.mes.domain.pc.pc300.PurchaseService;
import com.ppm.mes.domain.pc.pc300.PurchaseVO;
import com.ppm.mes.domain.pc.pc310.PurchaseDetailService;
/*
 * 구매서관리
 */
@Controller
@RequestMapping(value = "/api/v1/purchase")	//구매서
public class PurchaseController extends BaseController {

    @Inject private PurchaseService purchaseService;
    @Inject private PurchaseDetailService purchaseDetailService;
    
   	// header
   	@RequestMapping(value = "header", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse header(RequestParams<PurchaseVO> request) {
   		List<PurchaseVO> list = purchaseService.header(request);
   		//UserLogUtil.saveUserLog("PurchaseController","Purchase","GET");
   		return Responses.ListResponse.of(list);	
   	}
   	
	// 품목별 구매현황
	@RequestMapping(value = "itemList", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse itemList(RequestParams<PurchaseVO> request) {
		List<PurchaseVO> list = purchaseService.itemDetail(request);
		return Responses.ListResponse.of(list);
	}
   	
    //임시저장,확정
    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public Purchase save(@RequestBody Purchase request) {
    	//UserLogUtil.saveUserLog("PurchaseController","Purchase","PUT");
    	return purchaseService.savePurchase(request);
    } 

    //삭제
    @RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody Purchase t) {    			
    	//UserLogUtil.saveUserLog("PurchaseController","Purchase","DELETE");
    	purchaseDetailService.deleteAll(t);
    	return ok();
    }
    
    /*
     * 낭만연구소
    @RequestMapping(value ="printbarcode", method = {RequestMethod.POST}, produces = APPLICATION_JSON)
    public void printbarcode(@RequestBody Map<String, Object> paramMap) {
    	purchaseService.printbarcode(paramMap);
    }
    */
}