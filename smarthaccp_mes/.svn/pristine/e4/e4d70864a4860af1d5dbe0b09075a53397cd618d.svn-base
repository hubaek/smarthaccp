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
import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.ppm.mes.domain.haccp.cycleCheck.CycleCheckMaster;
import com.ppm.mes.domain.haccp.cycleCheck.CycleCheckMasterService;
import com.ppm.mes.domain.haccp.cycleCheck.CycleCheckMasterVO;

@Controller
@RequestMapping(value="/api/v1/cycle")
public class CycleCheckController extends BaseController{
	@Inject
	private CycleCheckMasterService masterService;
	
	@RequestMapping(value="/master", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse getMasterList(RequestParams<CycleCheckMaster> requestParams){
		List<CycleCheckMaster> list = masterService.getList(requestParams);
		//UserLogUtil.saveUserLog("CycleCheckController", "CycleCheck Master", "GET");
		return Responses.ListResponse.of(list);
	}
	
	@RequestMapping(value="/master", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<CycleCheckMasterVO> list){
		List<CycleCheckMaster> masterList = ModelMapperUtils.mapList(list, CycleCheckMaster.class);
		masterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(value="/alram", method = {RequestMethod.GET}, produces = APPLICATION_JSON)
	public Responses.MapResponse getPopAlarmList(RequestParams<CycleCheckMaster> requestParams){
		masterService.updateLastDate();
		List<CycleCheckMasterVO> list = masterService.getPopAlarmList(requestParams);
		List<CycleCheckMasterVO> list2 = masterService.getAlarmList(requestParams);
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		map.put("list2",list2);
		return Responses.MapResponse.of(map);
	}
	
	
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
	public ApiResponse delete(@RequestBody CycleCheckMaster m){
		//UserLogUtil.saveUserLog("CycleCheckController", "CycleCheck", "DELETE");
		masterService.delete(m);
		return ok();
	}
}
