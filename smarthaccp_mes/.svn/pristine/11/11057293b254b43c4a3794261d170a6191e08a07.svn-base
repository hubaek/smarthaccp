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
import com.ppm.mes.domain.haccp.metal.detail.HaccpMetalDetail;
import com.ppm.mes.domain.haccp.metal.detail.HaccpMetalDetailService;
import com.ppm.mes.domain.haccp.metal.detail.HaccpMetalDetailVO;
import com.ppm.mes.domain.haccp.metal.master.HaccpMetalMaster;
import com.ppm.mes.domain.haccp.metal.master.HaccpMetalMasterService;
import com.ppm.mes.domain.haccp.metal.master.HaccpMetalMasterVO;

/*금속검출기 20.09.14 kjm*/
@Controller
@RequestMapping(value="/api/v1/haccpMetal")
public class HaccpMetalController extends BaseController{
	
	@Inject private HaccpMetalMasterService metalMasterService;
	@Inject private HaccpMetalDetailService metalDetailService;
	
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpMetalMasterVO> getMasterList(RequestParams<HaccpMetalMasterVO> requestParams){
		return metalMasterService.getMasterList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HaccpMetalMasterVO> list) {
		List<HaccpMetalMaster> masterList = ModelMapperUtils.mapList(list, HaccpMetalMaster.class);
		metalMasterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList(RequestParams<HaccpMetalDetailVO> requestParams) {

		List<HaccpMetalDetailVO> codes = metalDetailService.getHaccpMetalDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpMetalController","HaccpMetal Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getMetalDetailList(RequestParams<HaccpMetalDetailVO> requestParams) {

		List<HaccpMetalDetailVO> codes = metalDetailService.getMetalDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpMetalController","Metal Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<HaccpMetalDetail> list) {
    	//UserLogUtil.saveUserLog("HaccpMetalController","HaccpMetal Detail","PUT");
    	metalDetailService.saveHaccpMetalDetailList(list);
        return ok(); 
    }
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HaccpMetalMaster> list) {    	
    	//UserLogUtil.saveUserLog("HaccpMetalController","HaccpMetal","DELETE");
    	metalDetailService.deleteAll(list);
    	return ok();
    } 
}
