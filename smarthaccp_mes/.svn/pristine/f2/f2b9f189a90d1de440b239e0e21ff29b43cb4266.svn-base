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
import com.ppm.mes.domain.haccp.ster.detail.HaccpSterDetail;
import com.ppm.mes.domain.haccp.ster.detail.HaccpSterDetailService;
import com.ppm.mes.domain.haccp.ster.detail.HaccpSterDetailVO;
import com.ppm.mes.domain.haccp.ster.master.HaccpSterMaster;
import com.ppm.mes.domain.haccp.ster.master.HaccpSterMasterService;
import com.ppm.mes.domain.haccp.ster.master.HaccpSterMasterVO;

@Controller
@RequestMapping(value="/api/v1/haccpSter")
public class HaccpSterController extends BaseController{
	
	@Inject
	private HaccpSterMasterService sterMasterService;
	@Inject
	private HaccpSterDetailService sterDetailService;
	
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpSterMasterVO> getMasterList(RequestParams<HaccpSterMasterVO> requestParams){
		return sterMasterService.getMasterList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HaccpSterMasterVO> list) {
		List<HaccpSterMaster> masterList = ModelMapperUtils.mapList(list, HaccpSterMaster.class);
		sterMasterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList(RequestParams<HaccpSterDetailVO> requestParams) {

		List<HaccpSterDetailVO> codes = sterDetailService.getHaccpSterDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpSterController","HaccpSter Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	// 201211 kjm 차트 생성시
	@RequestMapping(value = "/GetCharts1", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse GetCharts1(RequestParams<HaccpSterDetailVO> requestParams) {
		List<HaccpSterDetailVO> codes = sterDetailService.GetCharts1(requestParams);		
		//UserLogUtil.saveUserLog("HaccpSterController","GetCharts1","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/GetCharts2", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse GetCharts2(RequestParams<HaccpSterDetailVO> requestParams) {
		List<HaccpSterDetailVO> codes = sterDetailService.GetCharts2(requestParams);		
		//UserLogUtil.saveUserLog("HaccpSterController","GetCharts2","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/GetCharts3", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse GetCharts3(RequestParams<HaccpSterDetailVO> requestParams) {
		List<HaccpSterDetailVO> codes = sterDetailService.GetCharts3(requestParams);		
		//UserLogUtil.saveUserLog("HaccpSterController","GetCharts3","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getHaccpDetailList(RequestParams<HaccpSterDetailVO> requestParams) {

		List<HaccpSterDetailVO> codes = sterDetailService.getHaccpDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpSterController","Ster Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<HaccpSterDetail> list) {
    	//UserLogUtil.saveUserLog("HaccpSterController","HaccpSter Detail","PUT");
    	sterDetailService.saveHaccpSterDetailList(list);
        return ok(); 
    }
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HaccpSterMaster> list) {    	
    	//UserLogUtil.saveUserLog("HaccpSterController","HaccpSter","DELETE");
    	sterDetailService.deleteAll(list);
    	return ok();
    }
}
