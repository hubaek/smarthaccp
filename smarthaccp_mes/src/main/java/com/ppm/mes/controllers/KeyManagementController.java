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
import com.ppm.mes.domain.key.system.SystemKeyManagement;
import com.ppm.mes.domain.key.system.SystemKeyManagementService;
import com.ppm.mes.domain.key.work.WorkKeyManagement;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;

@Controller
@RequestMapping(value = "/api/v1/key")
public class KeyManagementController extends BaseController {

	@Inject private SystemKeyManagementService systemKeyManagementService;
	@Inject private WorkKeyManagementService workKeyManagementService; 

    @RequestMapping(value="system",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getSystemKeyList(RequestParams<SystemKeyManagement> requestParams) {
    	List<SystemKeyManagement> list = systemKeyManagementService.gets(requestParams);
        return Responses.ListResponse.of(list); 
    }
    
    @RequestMapping(value="system",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveSystemKey(@RequestBody List<SystemKeyManagement> list) {
    	systemKeyManagementService.save(list);
        return ok();
    }
    
    @RequestMapping(value="work",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getWorkKeyList(RequestParams<WorkKeyManagement> requestParams) {
    	List<WorkKeyManagement> list = workKeyManagementService.gets(requestParams);
        return Responses.ListResponse.of(list); 
    }
    
    @RequestMapping(value="work",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveWorkKey(@RequestBody List<WorkKeyManagement> list) {
    	workKeyManagementService.save(list);
        return ok();
    }
    
}
