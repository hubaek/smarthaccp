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
import com.ppm.mes.domain.haccp.all.master.HaccpAllMaster;
import com.ppm.mes.domain.haccp.all.master.HaccpAllMasterService;
import com.ppm.mes.domain.haccp.all.master.HaccpAllMasterVO;
import com.ppm.mes.domain.haccp.all.raw.HaccpAllRaw;
import com.ppm.mes.domain.haccp.all.raw.HaccpAllRawService;
import com.ppm.mes.domain.haccp.all.raw.HaccpAllRawVO;
import com.ppm.mes.domain.haccp.all.work.HaccpAllWork;
import com.ppm.mes.domain.haccp.all.work.HaccpAllWorkService;
import com.ppm.mes.domain.haccp.all.work.HaccpAllWorkVO;

@Controller
@RequestMapping(value="/api/v1/haccpAll")
public class HaccpAllController extends BaseController{
	
	@Inject
	private HaccpAllMasterService masterService;
	@Inject
	private HaccpAllWorkService workService;
	@Inject
	private HaccpAllRawService rawService;
	
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpAllMaster> getMasterList(RequestParams<HaccpAllMasterVO> requestParams){		
		return masterService.getList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HaccpAllMasterVO> list) {
		List<HaccpAllMaster> masterList = ModelMapperUtils.mapList(list, HaccpAllMaster.class);
		masterService.save(masterList);
		return ok();
	}
	
	// 공통코드 조회용
	@RequestMapping(value = "/getWork", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getWorkList(RequestParams<HaccpAllWorkVO> requestParams) {
		List<HaccpAllWorkVO> codes = workService.getWorkList(requestParams);		
		//UserLogUtil.saveUserLog("HaccpAllController","work List","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/work", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getHaccpWorkList(RequestParams<HaccpAllWorkVO> requestParams) {

		List<HaccpAllWorkVO> codes = workService.getHaccpWorkList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpAllController","getHaccpWorkList","GET");
        return Responses.ListResponse.of(codes); 
    } 
	//작업공정 저장
	@RequestMapping(value = "/work", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse workSave(@RequestBody List<HaccpAllWork> list) {
    	//UserLogUtil.saveUserLog("HaccpAllController","HaccpAllWork","PUT");
    	workService.workSave(list);
        return ok(); 
    }
	
	@RequestMapping(value = "/raw", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRawList(RequestParams<HaccpAllRawVO> requestParams) {

		List<HaccpAllRawVO> codes = rawService.getRawList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpAllController","raw List","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	//원료육 저장
	@RequestMapping(value = "/raw", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse rawSave(@RequestBody List<HaccpAllRaw> list) {
    	//UserLogUtil.saveUserLog("HaccpAllController","HaccpAllRaw","PUT");
    	rawService.rawSave(list);
        return ok(); 
    }
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HaccpAllMaster> list) {    	
    	//UserLogUtil.saveUserLog("HaccpAllController","HaccpAll","DELETE");
    	masterService.deleteAll(list);
    	return ok();
    } 
}
