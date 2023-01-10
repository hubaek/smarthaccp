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
import com.ppm.mes.domain.snsr.SnsrMaster;
import com.ppm.mes.domain.snsr.SnsrMasterService;
import com.ppm.mes.domain.snsr.SnsrMasterVO;

@Controller
@RequestMapping(value = "/api/v1/snsr")
public class SnsrMasterController extends BaseController {
	
	@Inject private SnsrMasterService snsrMasterService;
	
	// 조회
    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getSensorList(RequestParams<SnsrMasterVO> requestParams) {
   		List<SnsrMaster> list = snsrMasterService.getSensorList(requestParams);
   		//UserLogUtil.saveUserLog("SnsrMasterController","getSensorList","GET");
        return Responses.ListResponse.of(list); 
    }
	
    //점검월 중복체크
    @RequestMapping(value = "snsrId", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getSensorIdCheck(RequestParams<SnsrMaster> requestParams) {
    	List<SnsrMaster> list = snsrMasterService.getSensorIdCheck(requestParams);
   		//UserLogUtil.saveUserLog("SnsrMasterController","getSensorIdCheck","GET");
        return Responses.ListResponse.of(list);
    }
    
    
    //저장
    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveSensorInfo(@RequestBody SnsrMaster m){
    	//UserLogUtil.saveUserLog("SnsrMasterController","saveSensorInfo","PUT");
    	snsrMasterService.saveSensorInfo(m);
    	return ok();
    }
    //삭제
    @RequestMapping( method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody SnsrMaster m){
    	//UserLogUtil.saveUserLog("SnsrMasterController","deleteAll","DELETE");
    	snsrMasterService.deleteAll(m);
    	return ok();
    }
}
