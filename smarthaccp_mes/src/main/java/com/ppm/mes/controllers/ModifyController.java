package com.ppm.mes.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.st.st300.Modify;
import com.ppm.mes.domain.st.st300.ModifyService;
import com.ppm.mes.domain.st.st300.ModifyVO;
import com.ppm.mes.domain.st.st310.ModifyDetailService;
/*
 * 실사관리
 */
@Controller
@RequestMapping(value = "/api/v1/modify")	//실사
public class ModifyController extends BaseController {

    @Inject private ModifyService modifyService;
    @Inject private ModifyDetailService modifyDetailService;
    
   	// header
   	@RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse header(RequestParams<ModifyVO> estimate) {
   		List<ModifyVO> list = modifyService.header(estimate);
   		//UserLogUtil.saveUserLog("ModifyController","Modify","GET");
   		return Responses.ListResponse.of(list);
   	}   	
   	
	// 품목별
	@RequestMapping(value = "itemList", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse itemList(RequestParams<ModifyVO> estimate) {
		List<ModifyVO> list = modifyService.itemDetail(estimate);
		return Responses.ListResponse.of(list);

	}

	
    //임시저장,확정
    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public Modify save(@RequestBody Modify m) {
    	//UserLogUtil.saveUserLog("ModifyController","Modify","PUT");
    	return modifyService.saveModify(m);
    }
}