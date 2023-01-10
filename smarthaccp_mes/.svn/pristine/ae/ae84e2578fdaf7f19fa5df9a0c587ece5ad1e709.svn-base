package com.ppm.mes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.health.health000.Health;
import com.ppm.mes.domain.health.health000.HealthService;
import com.ppm.mes.domain.health.health000.HealthVO;

@Controller
@RequestMapping(value = "/api/v1/health")
public class HealthCardController extends BaseController {
    @Inject private HealthService healthService;

   	// 조회
   	@RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getList(RequestParams<HealthVO> requestParams) {   
   		//UserLogUtil.saveUserLog("HealthCardController","getList","GET");
   		List<HealthVO> list = healthService.getHealthList(requestParams);
        return Responses.ListResponse.of(list);
   	}

   	//저장
   	@RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveHealth(@RequestBody Health m) {    	
   		//UserLogUtil.saveUserLog("HealthCardController","saveHealth","PUT");
   		healthService.saveHealth(m);
    	return ok();
    }
   	
   	//삭제
   	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteHealth(@RequestBody Health m) {    			
    	//UserLogUtil.saveUserLog("HealthCardController","deleteHealth","DELETE");
    	healthService.delete(m);
    	return ok();
    }
   	
   	//보건증 알림
   	@RequestMapping(value="/alram", method = {RequestMethod.GET}, produces = APPLICATION_JSON)
	public Responses.MapResponse getAlarmList(RequestParams<Health> requestParams){
		
		List<HealthVO> list = healthService.getAlarmList(requestParams);
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		
		return Responses.MapResponse.of(map);
	}
   	
}