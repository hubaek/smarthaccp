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
import com.ppm.mes.domain.haccp.filter.detail.HaccpFilterDetail;
import com.ppm.mes.domain.haccp.filter.detail.HaccpFilterDetailService;
import com.ppm.mes.domain.haccp.filter.detail.HaccpFilterDetailVO;
import com.ppm.mes.domain.haccp.filter.master.HaccpFilterMaster;
import com.ppm.mes.domain.haccp.filter.master.HaccpFilterMasterService;
import com.ppm.mes.domain.haccp.filter.master.HaccpFilterMasterVO;


@Controller
@RequestMapping(value="/api/v1/haccpFilter")
public class HaccpFilterController extends BaseController{
	
	@Inject private HaccpFilterMasterService FilterMasterService;
	@Inject private HaccpFilterDetailService FilterDetailService;
	
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpFilterMasterVO> getMasterList(RequestParams<HaccpFilterMasterVO> requestParams){
		//UserLogUtil.saveUserLog("HaccpFilterController","getMasterList","GET");
		return FilterMasterService.getMasterList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HaccpFilterMasterVO> list) {
		List<HaccpFilterMaster> masterList = ModelMapperUtils.mapList(list, HaccpFilterMaster.class);
		FilterMasterService.save(masterList);
		//UserLogUtil.saveUserLog("HaccpFilterController","saveMaster","PUT");
		return ok();
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList(RequestParams<HaccpFilterDetailVO> requestParams) {
		List<HaccpFilterDetailVO> codes = FilterDetailService.getFilterDetailList(requestParams);
		//UserLogUtil.saveUserLog("HaccpFilterController","getDetailList","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getFilterDetailList(RequestParams<HaccpFilterDetailVO> requestParams) {
		List<HaccpFilterDetailVO> codes = FilterDetailService.getFilterDetailList(requestParams);
		//UserLogUtil.saveUserLog("HaccpFilterController","getFilterDetailList","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveDetail(@RequestBody List<HaccpFilterDetail> list) {
    	//UserLogUtil.saveUserLog("HaccpFilterController","saveDetail","PUT");
    	FilterDetailService.saveHaccpFilterDetailList(list);
        return ok(); 
    }
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HaccpFilterMaster> list) {    	
    	//UserLogUtil.saveUserLog("HaccpFilterController","deleteAll","DELETE");
    	FilterDetailService.deleteAll(list);
    	return ok();
    } 
}
