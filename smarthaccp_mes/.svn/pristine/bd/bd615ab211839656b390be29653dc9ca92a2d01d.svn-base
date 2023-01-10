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
import com.ppm.mes.domain.haccp.clean.detail.HaccpCleanDetail;
import com.ppm.mes.domain.haccp.clean.detail.HaccpCleanDetailService;
import com.ppm.mes.domain.haccp.clean.detail.HaccpCleanDetailVO;
import com.ppm.mes.domain.haccp.clean.master.HaccpCleanMaster;
import com.ppm.mes.domain.haccp.clean.master.HaccpCleanMasterService;
import com.ppm.mes.domain.haccp.clean.master.HaccpCleanMasterVO;

/*세척 점검*/
@Controller
@RequestMapping(value="/api/v1/haccpClean")
public class HaccpCleanController extends BaseController{
	
	@Inject
	private HaccpCleanMasterService masterService;
	@Inject
	private HaccpCleanDetailService detailService;
	
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpCleanMasterVO> getMasterList(RequestParams<HaccpCleanMasterVO> requestParams){
		return masterService.getMasterList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HaccpCleanMasterVO> list) {
		List<HaccpCleanMaster> masterList = ModelMapperUtils.mapList(list, HaccpCleanMaster.class);
		masterService.save(masterList);
		return ok();
	}
	

	@RequestMapping(value = "/GetCharts", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse GetCharts(RequestParams<HaccpCleanDetailVO> requestParams) {
		List<HaccpCleanDetailVO> codes = detailService.GetCharts(requestParams);		
		//UserLogUtil.saveUserLog("HaccpCleanController","GetCharts","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList(RequestParams<HaccpCleanDetailVO> requestParams) {

		List<HaccpCleanDetailVO> codes = detailService.getHaccpCleanDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpCleanController","HaccpClean Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getHaccpDetailList(RequestParams<HaccpCleanDetailVO> requestParams) {

		List<HaccpCleanDetailVO> codes = detailService.getHaccpDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpCleanController","Clean Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<HaccpCleanDetail> list) {
    	//UserLogUtil.saveUserLog("HaccpCleanController","HaccpClean Detail","PUT");
    	detailService.saveHaccpCleanDetailList(list);
        return ok(); 
    }
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HaccpCleanMaster> list) {    	
    	//UserLogUtil.saveUserLog("HaccpCleanController","HaccpClean","DELETE");
    	detailService.deleteAll(list);
    	return ok();
    }
}
