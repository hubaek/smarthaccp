package com.ppm.mes.controllers;

import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.ppm.mes.domain.selfHygine.code.SelfHygineMaster;
import com.ppm.mes.domain.selfHygine.code.SelfHygineMasterService;
import com.ppm.mes.domain.selfHygine.code.SelfHygineMasterVO;
import com.ppm.mes.domain.selfHygine.detail.SelfHygineDetail;
import com.ppm.mes.domain.selfHygine.detail.SelfHygineDetailService;
import com.ppm.mes.domain.selfHygine.detail.SelfHygineDetailVO;
/*
 * 자체위생점검 
 */
@Controller
@RequestMapping(value="/api/v1/selfHygine")
public class SelfHygineController extends BaseController{
	
	@Inject 
	private SelfHygineMasterService selfHygineMasterService;
	@Inject 
	private SelfHygineDetailService selfHygineDetailService;
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<SelfHygineMaster> getMasterList(RequestParams<SelfHygineMasterVO> requestParams){
		return selfHygineMasterService.getList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<SelfHygineMasterVO> list) {
		List<SelfHygineMaster> masterList = ModelMapperUtils.mapList(list, SelfHygineMaster.class);
		selfHygineMasterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList(RequestParams<SelfHygineDetailVO> requestParams) {

		List<SelfHygineDetailVO> codes = selfHygineDetailService.getSelfHygineDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("SelfHygineController","SelfHygine Detail","GET");
        return Responses.ListResponse.of(codes); 
    } 
		
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<SelfHygineDetail> list) {
    	//UserLogUtil.saveUserLog("SelfHygineController","SelfHygine Detail","PUT");
    	selfHygineDetailService.saveSelfHygineDetailList(list);
        return ok(); 
    }
	//위생점검 공통코드목록 불러오기
	@RequestMapping(value="/originalDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse getOrigianlDetailList(RequestParams<SelfHygineDetailVO> requestParams) {
		List<SelfHygineDetailVO> codes = selfHygineDetailService.getHaccpDetailList(requestParams);
		return Responses.ListResponse.of(codes);
	}
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<SelfHygineMaster> list) {    	
    	//UserLogUtil.saveUserLog("SelfHygineController","SelfHygine","DELETE");
    	selfHygineDetailService.deleteAll(list);
    	return ok();
    }  
}
