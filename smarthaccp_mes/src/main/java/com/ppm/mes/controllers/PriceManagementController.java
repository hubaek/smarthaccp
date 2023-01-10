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
import com.ppm.mes.domain.item.item000.ItemMaster;
import com.ppm.mes.domain.pr.pr100.PcPriceManagement;
import com.ppm.mes.domain.pr.pr100.PcPriceManagementService;
import com.ppm.mes.domain.pr.pr100.PcPriceVO;
import com.ppm.mes.domain.pr.pr200.SaPriceManagement;
import com.ppm.mes.domain.pr.pr200.SaPriceManagementService;
import com.ppm.mes.domain.pr.pr200.SaPriceVO;
/*
 * 구매/영업 단가 관리
 */
@Controller
@RequestMapping(value = "/api/v1/price")
public class PriceManagementController extends BaseController {

	@Inject private PcPriceManagementService pcPriceManagementService;   

	@Inject private SaPriceManagementService saPriceManagementService;   
	
    @RequestMapping(value="pcPrice", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getPcPrice(RequestParams<PcPriceVO> requestParams) {
		List<PcPriceVO> list = pcPriceManagementService.getPcPriceList(requestParams);
		//UserLogUtil.saveUserLog("PriceManagementController","PC Price","GET");
        return Responses.ListResponse.of(list); 
    }
    
    //거래처별 단가 가져오기 - 없을시 품목마스터 단가
    @RequestMapping(value = "pcUnitPrice", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public ItemMaster pcUnitPrice(RequestParams<PcPriceManagement> requestParams) {
    	//UserLogUtil.saveUserLog("PriceManagementController","PC Unit Price","GET");
    	return pcPriceManagementService.getPcUnitPrice(requestParams);
    }

    
    @RequestMapping(value="pcPrice", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse save(@RequestBody List<PcPriceManagement> list) {
    	//UserLogUtil.saveUserLog("PriceManagementController","PC Price","PUT");
    	pcPriceManagementService.savePcPrice(list);
        return ok(); 
    }     

    //영업
    @RequestMapping(value="saPrice", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getSaPrice(RequestParams<SaPriceVO> requestParams) {
		List<SaPriceVO> codes = saPriceManagementService.getSaPriceList(requestParams);
		//UserLogUtil.saveUserLog("PriceManagementController","SA Price","GET");
        return Responses.ListResponse.of(codes); 
    }

    
    //거래처별 단가 가져오기 - 없을시 품목마스터 단가
    @RequestMapping(value = "salesUnitPrice", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public ItemMaster getSalesUnitPrice(RequestParams<SaPriceManagement> requestParams) {
    	//UserLogUtil.saveUserLog("PriceManagementController","SA Unit Price","GET");
    	return saPriceManagementService.getSaUnitPrice(requestParams);
    }
    
    @RequestMapping(value="saPrice", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveSalesPrice(@RequestBody List<SaPriceManagement> list) { 
    	//UserLogUtil.saveUserLog("PriceManagementController","SA Price","PUT");
    	saPriceManagementService.saveSaPrice(list);
        return ok(); 
    }     
}
