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
import com.ppm.mes.domain.haccp.manufacturing.code.ManuFacturingMaster;
import com.ppm.mes.domain.haccp.manufacturing.code.ManuFacturingMasterService;
import com.ppm.mes.domain.haccp.manufacturing.code.ManuFacturingMasterVO;
import com.ppm.mes.domain.haccp.manufacturing.detail.ManuFacturingDetail;
import com.ppm.mes.domain.haccp.manufacturing.detail.ManuFacturingDetailService;
import com.ppm.mes.domain.haccp.manufacturing.detail.ManuFacturingDetailVO;
/*
 * 자체위생점검 
 */
@Controller
@RequestMapping(value="/api/v1/manufacturing")
public class ManuFacturingController extends BaseController{
	
	@Inject 
	private ManuFacturingMasterService manufacturingMasterService;
	@Inject 
	private ManuFacturingDetailService manufacturingDetailService;
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<ManuFacturingMaster> getMasterList(RequestParams<ManuFacturingMasterVO> requestParams){
		return manufacturingMasterService.getList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<ManuFacturingMasterVO> list) {
		List<ManuFacturingMaster> masterList = ModelMapperUtils.mapList(list, ManuFacturingMaster.class);
		manufacturingMasterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList(RequestParams<ManuFacturingDetailVO> requestParams) {

		List<ManuFacturingDetailVO> codes = manufacturingDetailService.getManuFacturingDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("ManuFacturingController","ManuFacturing Detail","GET");
        return Responses.ListResponse.of(codes); 
    } 
		
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<ManuFacturingDetail> list) {
    	//UserLogUtil.saveUserLog("SelfHygineController","SelfHygine Detail","PUT");
    	manufacturingDetailService.saveManuFacturingDetailList(list);
        return ok(); 
    }
	//위생점검 공통코드목록 불러오기
	@RequestMapping(value="/originalDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse getOrigianlDetailList(RequestParams<ManuFacturingDetailVO> requestParams) {
		List<ManuFacturingDetailVO> codes = manufacturingDetailService.getHaccpDetailList(requestParams);
		return Responses.ListResponse.of(codes);
	}
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<ManuFacturingMaster> list) {    	
    	//UserLogUtil.saveUserLog("ManuFacturingController","ManuFacturing","DELETE");
    	manufacturingDetailService.deleteAll(list);
    	return ok();
    }  
}
