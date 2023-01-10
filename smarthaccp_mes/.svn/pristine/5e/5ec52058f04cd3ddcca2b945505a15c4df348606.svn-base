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
import com.ppm.mes.domain.sys.sys300.PopManage;
import com.ppm.mes.domain.sys.sys300.PopManageService;
import com.ppm.mes.domain.sys.sys310.PopEquipManage;
import com.ppm.mes.domain.sys.sys310.PopEquipManageService;

/*
 * UPDATE 관리
 */
@Controller
@RequestMapping(value = "/api/v1/system")
public class SystemManageController extends BaseController {

    @Inject private PopManageService popManageService;
    @Inject private PopEquipManageService popEquipManageService;
    
   	///현장Setup///
   	// 조회
   	@RequestMapping(value="pop",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getPopSetupList(RequestParams<PopManage> requestParams) {    
        List<PopManage> list = popManageService.getPopSetupList(requestParams);
        return Responses.ListResponse.of(list);
   	}

    //저장
   	@RequestMapping(value="pop",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse savePopSetup(@RequestBody List<PopManage> items) {    	
   		popManageService.savePopSetup(items);
    	return ok();
    } 

   	// 조회 - 설비
   	@RequestMapping(value="popEquip",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getPopEquipSetupList(RequestParams<PopEquipManage> requestParams) {    
        List<PopEquipManage> list = popEquipManageService.getPopEquipSetupList(requestParams);
        return Responses.ListResponse.of(list);
   	}

    //저장 - 설비
   	@RequestMapping(value="popEquip",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse savePopEquipSetup(@RequestBody List<PopEquipManage> items) {    	
   		popEquipManageService.save(items);
    	return ok();
    } 
}