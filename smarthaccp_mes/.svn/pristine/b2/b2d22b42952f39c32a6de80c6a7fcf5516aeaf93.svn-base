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
import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.ppm.mes.domain.haccp.lamp.insect.HaccpLampInsect;
import com.ppm.mes.domain.haccp.lamp.insect.HaccpLampInsectService;
import com.ppm.mes.domain.haccp.lamp.insect.HaccpLampInsectVO;
import com.ppm.mes.domain.haccp.lamp.master.HaccpLampMaster;
import com.ppm.mes.domain.haccp.lamp.master.HaccpLampMasterService;
import com.ppm.mes.domain.haccp.lamp.master.HaccpLampMasterVO;

@Controller
@RequestMapping(value="/api/v1/haccpLamp")
public class HaccpLampController extends BaseController{
	
	@Inject
	private HaccpLampMasterService masterService;
	@Inject
	private HaccpLampInsectService insectService;
	
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpLampMaster> getMasterList(RequestParams<HaccpLampMasterVO> requestParams){		
		return masterService.getList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HaccpLampMasterVO> list) {
		List<HaccpLampMaster> masterList = ModelMapperUtils.mapList(list, HaccpLampMaster.class);
		masterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(value = "/insect", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList(RequestParams<HaccpLampInsectVO> requestParams) {

		List<HaccpLampInsectVO> codes = insectService.getHaccpInsectList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpLampController","getHaccpInsectList","GET");
        return Responses.ListResponse.of(codes); 
    } 
	//포충등 저장
	@RequestMapping(value = "/insect", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse insectSave(@RequestBody List<HaccpLampInsect> list) {
    	//UserLogUtil.saveUserLog("HaccpLampController","HaccpLampInsect","PUT");
    	insectService.insectSave(list);
        return ok(); 
    }
	
	// 공통코드 조회용
	@RequestMapping(value = "/getInsect", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getInsectList(RequestParams<HaccpLampInsectVO> requestParams) {
		List<HaccpLampInsectVO> codes = insectService.getInsectList(requestParams);		
		//UserLogUtil.saveUserLog("HaccpLampController","insect List","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HaccpLampMaster> list) {    	
    	//UserLogUtil.saveUserLog("HaccpLampController","HaccpLamp","DELETE");
    	masterService.deleteAll(list);
    	return ok();
    } 
}
