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
import com.ppm.mes.domain.lmt.master.LmtMaster;
import com.ppm.mes.domain.lmt.master.LmtMasterService;
import com.ppm.mes.domain.lmt.master.LmtMasterVO;
	/*
	 * 한계기준정보
	 */
@Controller
@RequestMapping(value = "/api/v1/limit")
public class LimitMasterController extends BaseController{
	
	@Inject private LmtMasterService lmtMasterService;
	
	// 조회
	@RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse getLimitList(RequestParams<LmtMasterVO> requestParams){
		List<LmtMasterVO> list = lmtMasterService.getLimitList(requestParams);
		//UserLogUtil.saveUserLog("LimitMasterController","Limit List","GET");
        return Responses.ListResponse.of(list); 
	}
	//저장
	@RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public LmtMaster saveLimit(@RequestBody LmtMaster lmt) {
		lmtMasterService.saveLimitInfo(lmt);
    	//UserLogUtil.saveUserLog("LimitMasterController","Limit Save","PUT");
    	//return lmtMasterService.save(lmt);
    	return lmt;
    }    
    //삭제
    @RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteLimit(@RequestBody LmtMaster lmt) {    			
    	//UserLogUtil.saveUserLog("LimitMasterController","Limit Delete","DELETE");
    	lmtMasterService.delete(lmt);
    	return ok();
    }
}
