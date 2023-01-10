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
import com.ppm.mes.domain.haccp.tank.detail.HaccpTankDetail;
import com.ppm.mes.domain.haccp.tank.detail.HaccpTankDetailService;
import com.ppm.mes.domain.haccp.tank.detail.HaccpTankDetailVO;
import com.ppm.mes.domain.haccp.tank.master.HaccpTankMaster;
import com.ppm.mes.domain.haccp.tank.master.HaccpTankMasterService;
import com.ppm.mes.domain.haccp.tank.master.HaccpTankMasterVO;

@Controller
@RequestMapping(value="/api/v1/haccpTank")
public class HaccpTankController extends BaseController{
	
	@Inject
	private HaccpTankMasterService tankMasterService;
	@Inject
	private HaccpTankDetailService tankDetailService;
	
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpTankMasterVO> getMasterList(RequestParams<HaccpTankMasterVO> requestParams){
		return tankMasterService.getMasterList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HaccpTankMasterVO> list) {
		List<HaccpTankMaster> masterList = ModelMapperUtils.mapList(list, HaccpTankMaster.class);
		tankMasterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList(RequestParams<HaccpTankDetailVO> requestParams) {

		List<HaccpTankDetailVO> codes = tankDetailService.getHaccpTankDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpTankController","HaccpTank Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	// 201211 kjm 차트 생성시
	@RequestMapping(value = "/GetCharts", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse GetCharts(RequestParams<HaccpTankDetailVO> requestParams) {
		List<HaccpTankDetailVO> codes = tankDetailService.GetCharts(requestParams);		
		//UserLogUtil.saveUserLog("HaccpTankController","GetCharts","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getHaccpDetailList(RequestParams<HaccpTankDetailVO> requestParams) {

		List<HaccpTankDetailVO> codes = tankDetailService.getHaccpDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpTankController","Tank Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<HaccpTankDetail> list) {
    	//UserLogUtil.saveUserLog("HaccpTankController","HaccpTank Detail","PUT");
    	tankDetailService.saveHaccpTankDetailList(list);
        return ok(); 
    }
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HaccpTankMaster> list) {    	
    	//UserLogUtil.saveUserLog("HaccpTankController","HaccpTank","DELETE");
    	tankDetailService.deleteAll(list);
    	return ok();
    }
}
