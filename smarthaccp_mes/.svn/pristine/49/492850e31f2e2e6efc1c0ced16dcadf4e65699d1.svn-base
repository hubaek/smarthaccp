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
import com.ppm.mes.domain.haccp.hgPrc.detail.HgPrcDetail;
import com.ppm.mes.domain.haccp.hgPrc.detail.HgPrcDetailService;
import com.ppm.mes.domain.haccp.hgPrc.detail.HgPrcDetailVO;
import com.ppm.mes.domain.haccp.hgPrc.master.HgPrcMaster;
import com.ppm.mes.domain.haccp.hgPrc.master.HgPrcMasterService;
import com.ppm.mes.domain.haccp.hgPrc.master.HgPrcMasterVO;


@Controller
@RequestMapping(value="/api/v1/haccpHgPrc")
public class HaccpHgPrcController extends BaseController {
	
	@Inject
	private HgPrcMasterService hgPrcMasterService;
	@Inject
	private HgPrcDetailService hgPrcDetailService;
	
	/*
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HgPrcMaster> getMasterList(RequestParams<HgPrcMasterVO> requestParams){
		return hgPrcMasterService.getList(requestParams);
	}
	*/
	
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HgPrcMasterVO> getMasterList(RequestParams<HgPrcMasterVO> requestParams){
		return hgPrcMasterService.getMasterList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HgPrcMasterVO> list) {
		List<HgPrcMaster> masterList = ModelMapperUtils.mapList(list, HgPrcMaster.class);
		hgPrcMasterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList(RequestParams<HgPrcDetailVO> requestParams) {
		List<HgPrcDetailVO> codes = hgPrcDetailService.getHgPrcDetailList(requestParams);	
		//UserLogUtil.saveUserLog("SelfHygineController","SelfHygine Detail","GET");
        return Responses.ListResponse.of(codes); 
    } 
		
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<HgPrcDetail> list) {
    	//UserLogUtil.saveUserLog("SelfHygineController","SelfHygine Detail","PUT");
    	hgPrcDetailService.saveHgPrcDetailList(list);
        return ok(); 
    }
	//위생점검 공통코드목록 불러오기
	@RequestMapping(value="/originalDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse getOrigianlDetailList(RequestParams<HgPrcDetailVO> requestParams) {
		List<HgPrcDetailVO> codes = hgPrcDetailService.getHaccpDetailList(requestParams);
		return Responses.ListResponse.of(codes);
	}
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HgPrcMaster> list) {    	
    	//UserLogUtil.saveUserLog("SelfHygineController","SelfHygine","DELETE");
    	hgPrcDetailService.deleteAll(list);
    	return ok();
    }
}
