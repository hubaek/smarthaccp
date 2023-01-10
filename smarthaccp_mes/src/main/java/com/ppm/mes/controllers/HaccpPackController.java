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
import com.ppm.mes.domain.haccp.pack.detail.HaccpPackDetail;
import com.ppm.mes.domain.haccp.pack.detail.HaccpPackDetailService;
import com.ppm.mes.domain.haccp.pack.detail.HaccpPackDetailVO;
import com.ppm.mes.domain.haccp.pack.master.HaccpPackMaster;
import com.ppm.mes.domain.haccp.pack.master.HaccpPackMasterService;
import com.ppm.mes.domain.haccp.pack.master.HaccpPackMasterVO;

@Controller
@RequestMapping(value="/api/v1/haccpPack")
public class HaccpPackController extends BaseController{
	
	@Inject
	private HaccpPackMasterService packMasterService;
	@Inject
	private HaccpPackDetailService packDetailService;
	
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpPackMasterVO> getMasterList(RequestParams<HaccpPackMasterVO> requestParams){
		return packMasterService.getMasterList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HaccpPackMasterVO> list) {
		List<HaccpPackMaster> masterList = ModelMapperUtils.mapList(list, HaccpPackMaster.class);
		packMasterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(value = "/detail1", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList1(RequestParams<HaccpPackDetailVO> requestParams) {

		List<HaccpPackDetailVO> codes = packDetailService.getHaccpPackDetailList1(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpPackController","HaccpPack Detail1","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/detail2", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList2(RequestParams<HaccpPackDetailVO> requestParams) {
		System.out.println("haccpPack Controller!!!!!!!!");
		List<HaccpPackDetailVO> codes = packDetailService.getHaccpPackDetailList2(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpPackController","HaccpPack Detail2","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/detail3", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList3(RequestParams<HaccpPackDetailVO> requestParams) {

		List<HaccpPackDetailVO> codes = packDetailService.getHaccpPackDetailList3(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpPackController","HaccpPack Detail3","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	// 201211 kjm 차트 생성시
	@RequestMapping(value = "/GetCharts1", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse GetCharts1(RequestParams<HaccpPackDetailVO> requestParams) {
		List<HaccpPackDetailVO> codes = packDetailService.GetCharts1(requestParams);		
		//UserLogUtil.saveUserLog("HaccpPackController","GetCharts1","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/GetCharts2", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse GetCharts2(RequestParams<HaccpPackDetailVO> requestParams) {
		List<HaccpPackDetailVO> codes = packDetailService.GetCharts2(requestParams);		
		//UserLogUtil.saveUserLog("HaccpPackController","GetCharts2","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/GetCharts3", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse GetCharts3(RequestParams<HaccpPackDetailVO> requestParams) {
		List<HaccpPackDetailVO> codes = packDetailService.GetCharts3(requestParams);		
		//UserLogUtil.saveUserLog("HaccpPackController","GetCharts3","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getHaccpDetailList(RequestParams<HaccpPackDetailVO> requestParams) {

		List<HaccpPackDetailVO> codes = packDetailService.getHaccpDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpPackController","Pack Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<HaccpPackDetail> list) {
    	//UserLogUtil.saveUserLog("HaccpSterController","HaccpPack Detail","PUT");
    	packDetailService.saveHaccpSterDetailList(list);
        return ok(); 
    }
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HaccpPackMaster> list) {    	
    	//UserLogUtil.saveUserLog("HaccpSterController","HaccpPack","DELETE");
    	packDetailService.deleteAll(list);
    	return ok();
    }
}
