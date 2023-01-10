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
import com.ppm.mes.domain.haccp.code.detail.HaccpProcessCodeDetailVO;
import com.ppm.mes.domain.haccp.code.detail.HaccpProcessDetail;
import com.ppm.mes.domain.haccp.code.detail.HaccpProcessDetailService;
import com.ppm.mes.domain.haccp.code.detail.HaccpProcessDetailVO;
import com.ppm.mes.domain.haccp.code.master.HaccpProcessMaster;
import com.ppm.mes.domain.haccp.code.master.HaccpProcessMasterService;
import com.ppm.mes.domain.haccp.code.master.HaccpProcessMasterVO;



/*
 * 공정관리	
*/
@Controller
@RequestMapping(value= "/api/v1/haccpProcess") //공정관리
public class HaccpProcessController extends BaseController {
	
	@Inject 
	private HaccpProcessMasterService haccpProcessMasterService;
	@Inject 
	private HaccpProcessDetailService haccpProcessDetailService;
	
 
	//조회
	@RequestMapping(value = "/header", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse vo(RequestParams<HaccpProcessMasterVO> vo){
		List<HaccpProcessMasterVO> list = haccpProcessMasterService.getList(vo);
		//UserLogUtil.saveUserLog("HaccpProcessController","haccpProcess list","GET");
   		return Responses.ListResponse.of(list);
	}
	//마스터 저장
	@RequestMapping(value = "/master", method = { RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveHaccpProcessMaster(@RequestBody List<HaccpProcessMasterVO> list) {
        List<HaccpProcessMaster> masterProcessList = ModelMapperUtils.mapList(list, HaccpProcessMaster.class);
        haccpProcessMasterService.save(masterProcessList);
        return ok();
    }
	
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<HaccpProcessDetail> list) {
    	//UserLogUtil.saveUserLog("HaccpCodeController","HaccpCode Detail","PUT");
    	haccpProcessDetailService.saveHaccpProcessDetail(list);
        return ok(); 
    }
    //공정상세
	@RequestMapping(value = "/processDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getProcessDetailList(RequestParams<HaccpProcessDetailVO> requestParams) {
		List<HaccpProcessDetailVO> codes = haccpProcessDetailService.getHaccpProcessDetailList(requestParams);
		//UserLogUtil.saveUserLog("HaccpCodeController","HaccpCode Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HaccpProcessMaster> list) {    	
    	//UserLogUtil.saveUserLog("HaccpProcessController","HaccpProcess","DELETE");
    	haccpProcessDetailService.deleteAll(list);
    	return ok();
    }  
	
	//공정 상세 코드 조회 2020-06-30
	@RequestMapping(value = "/processCode", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getBasicDetailList(RequestParams<HaccpProcessCodeDetailVO> requestParams) {
		System.out.println("processCode@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		List<HaccpProcessCodeDetailVO> processCodes = haccpProcessDetailService.getHaccpProcessCodeDetailList(requestParams);
		//UserLogUtil.saveUserLog("HaccpCodeController","HaccpCode Detail","GET");
        return Responses.ListResponse.of(processCodes); 
    } 
	
    //점검일자 중복체크
    @RequestMapping(value = "/checkDate", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getProcessCheckInDate(RequestParams<HaccpProcessMaster> requestParams) {
    	List<HaccpProcessMaster> list = haccpProcessMasterService.getHaccpProessMasterInDate(requestParams);
   		//UserLogUtil.saveUserLog("haccpProcessController checkDate","getProcessCheckInDate","GET");
   		return Responses.ListResponse.of(list); 
    }
}
