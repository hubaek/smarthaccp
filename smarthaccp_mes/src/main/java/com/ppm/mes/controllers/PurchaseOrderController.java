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
import com.ppm.mes.domain.pc.pc200.PurchaseOrder;
import com.ppm.mes.domain.pc.pc200.PurchaseOrderService;
import com.ppm.mes.domain.pc.pc200.PurchaseOrderVO;
import com.ppm.mes.domain.pc.pc210.PurchaseOrderDetail;
import com.ppm.mes.domain.pc.pc210.PurchaseOrderDetailService;
/*
 * 발주관리
 */
@Controller
@RequestMapping(value = "/api/v1/porder")	//발주
public class PurchaseOrderController extends BaseController {

    @Inject private PurchaseOrderService purchaseOrderService;
    @Inject private PurchaseOrderDetailService purchaseOrderDetailService;
    
    
   	// 헤더조회
   	@RequestMapping(value = "header", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse header(RequestParams<PurchaseOrderVO> request) {
   		List<PurchaseOrderVO> list = purchaseOrderService.header(request);
   		//UserLogUtil.saveUserLog("PurchaseOrderController","Purchase Order","GET");
   		return Responses.ListResponse.of(list);
   	}   	
   	
	// 상세조회
	@RequestMapping(value = "itemList", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse itemList(RequestParams<PurchaseOrderVO> request) {
		List<PurchaseOrderVO> list = purchaseOrderService.itemDetail(request);
		return Responses.ListResponse.of(list);
	}

    //저장
    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public PurchaseOrder save(@RequestBody PurchaseOrder request) {
    	//UserLogUtil.saveUserLog("PurchaseOrderController","Purchase Order","PUT");
    	return purchaseOrderService.saveOrderRequest(request);
    } 

    //발주마감 or 마감취소
    @RequestMapping(value="saveDetail", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveDetail(@RequestBody List<PurchaseOrderDetail> list) {
    	purchaseOrderDetailService.save(list);
    	return ok();
    } 
    
    //삭제
    @RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody PurchaseOrder t) {    			
    	//UserLogUtil.saveUserLog("PurchaseOrderController","Purchase Order","DELETE");
    	purchaseOrderDetailService.deleteAll(t);
    	return ok();
    }     	
}