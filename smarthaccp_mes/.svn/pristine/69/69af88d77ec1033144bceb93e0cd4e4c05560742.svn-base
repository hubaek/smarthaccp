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
import com.ppm.mes.domain.haccp.heat.detail.HaccpHeatDetail;
import com.ppm.mes.domain.haccp.heat.detail.HaccpHeatDetailService;
import com.ppm.mes.domain.haccp.heat.detail.HaccpHeatDetailVO;
import com.ppm.mes.domain.haccp.heat.master.HaccpHeatMaster;
import com.ppm.mes.domain.haccp.heat.master.HaccpHeatMasterService;
import com.ppm.mes.domain.haccp.heat.master.HaccpHeatMasterVO;

/*가열,살균 점검*/
@Controller
@RequestMapping(value="/api/v1/haccpHeat")
public class HaccpHeatController extends BaseController{
	
	@Inject
	private HaccpHeatMasterService heatMasterService;
	@Inject
	private HaccpHeatDetailService heatDetailService;
	
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpHeatMasterVO> getMasterList(RequestParams<HaccpHeatMasterVO> requestParams){
		return heatMasterService.getMasterList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HaccpHeatMasterVO> list) {
		List<HaccpHeatMaster> masterList = ModelMapperUtils.mapList(list, HaccpHeatMaster.class);
		heatMasterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList(RequestParams<HaccpHeatDetailVO> requestParams) {

		List<HaccpHeatDetailVO> codes = heatDetailService.getHaccpHeatDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpHeatController","HaccpHeat Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
		
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getHaccpDetailList(RequestParams<HaccpHeatDetailVO> requestParams) {

		List<HaccpHeatDetailVO> codes = heatDetailService.getHaccpDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpHeatController","Heat Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<HaccpHeatDetail> list) {
    	//UserLogUtil.saveUserLog("HaccpHeatController","HaccpHeat Detail","PUT");
    	heatDetailService.saveHaccpHeatDetailList(list);
        return ok(); 
    }
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HaccpHeatMaster> list) {    	
    	//UserLogUtil.saveUserLog("HaccpHeatController","HaccpHeat","DELETE");
    	heatDetailService.deleteAll(list);
    	return ok();
    } 
}
