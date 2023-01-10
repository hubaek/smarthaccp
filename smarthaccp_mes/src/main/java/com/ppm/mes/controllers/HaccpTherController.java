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
import com.ppm.mes.domain.haccp.ther.detail.HaccpTherDetail;
import com.ppm.mes.domain.haccp.ther.detail.HaccpTherDetailService;
import com.ppm.mes.domain.haccp.ther.detail.HaccpTherDetailVO;
import com.ppm.mes.domain.haccp.ther.master.HaccpTherMaster;
import com.ppm.mes.domain.haccp.ther.master.HaccpTherMasterService;
import com.ppm.mes.domain.haccp.ther.master.HaccpTherMasterVO;

@Controller
@RequestMapping(value="/api/v1/haccpTher")
public class HaccpTherController extends BaseController{
	
	@Inject
	private HaccpTherMasterService therMasterService;
	@Inject
	private HaccpTherDetailService therDetailService;
	
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpTherMasterVO> getMasterList(RequestParams<HaccpTherMasterVO> requestParams){
		return therMasterService.getMasterList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HaccpTherMasterVO> list) {
		List<HaccpTherMaster> masterList = ModelMapperUtils.mapList(list, HaccpTherMaster.class);
		therMasterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList(RequestParams<HaccpTherDetailVO> requestParams) {

		List<HaccpTherDetailVO> codes = therDetailService.getHaccpTherDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpTherController","HaccpTher Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	// 201211 kjm 차트 생성시
	@RequestMapping(value = "/GetCharts", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse GetCharts(RequestParams<HaccpTherDetailVO> requestParams) {
		List<HaccpTherDetailVO> codes = therDetailService.GetCharts(requestParams);		
		//UserLogUtil.saveUserLog("HaccpTherController","GetCharts","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getHaccpDetailList(RequestParams<HaccpTherDetailVO> requestParams) {

		List<HaccpTherDetailVO> codes = therDetailService.getHaccpDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpTherController","Ther Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<HaccpTherDetail> list) {
    	//UserLogUtil.saveUserLog("HaccpTherController","HaccpTher Detail","PUT");
    	therDetailService.saveHaccpTherDetailList(list);
        return ok(); 
    }
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HaccpTherMaster> list) {    	
    	//UserLogUtil.saveUserLog("HaccpTherController","HaccpTher","DELETE");
    	therDetailService.deleteAll(list);
    	return ok();
    } 
}
