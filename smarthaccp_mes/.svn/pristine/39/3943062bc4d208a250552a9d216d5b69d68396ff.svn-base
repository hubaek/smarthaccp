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
import com.ppm.mes.domain.cust.cust000.CustInfo;
import com.ppm.mes.domain.cust.cust000.CustInfoService;
 /*
  * 거래처관리
  */
@Controller
@RequestMapping(value = "/api/v1/custInfo")
public class CustInfoController extends BaseController {
  
    @Inject private CustInfoService custInfoService; 
    
    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getCustInfoList(RequestParams<CustInfo> requestParams) {
    	List<CustInfo> list = custInfoService.getCustInfoList(requestParams);
    	//UserLogUtil.saveUserLog("CustInfoController","Cust List","GET");
        return Responses.ListResponse.of(list); 
    }

    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public CustInfo save(@RequestBody CustInfo custs) {
    	custInfoService.saveCustInfo(custs);
    	//UserLogUtil.saveUserLog("CustInfoController","Cust Save","PUT");
        return custs;
    }
    
    @RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteCust(@RequestBody CustInfo t) {    			
    	//UserLogUtil.saveUserLog("CustInfoController","Cust Delete","DELETE");
    	custInfoService.delete(t);
    	return ok();
    }
}