package com.ppm.mes.controllers;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.ppm.mes.domain.cd.cd000.BasicCodeMaster;
import com.ppm.mes.domain.cd.cd000.BasicCodeMasterService;
import com.ppm.mes.domain.cd.cd000.BasicCodeMasterVO;
import com.ppm.mes.domain.cd.cd100.BasicCodeDetail;
import com.ppm.mes.domain.cd.cd100.BasicCodeDetailService;
import com.ppm.mes.domain.cd.cd100.BasicCodeDetailVO;
import com.ppm.mes.utils.BasicCodeUtils;
/*
 * 기초데이터 관리 
 */
@Controller
@RequestMapping(value = "/api/v1/basicCode") 
public class BasicCodeController extends BaseController {
	
	@Inject private BasicCodeMasterService basicCodeMasterService;
	@Inject private BasicCodeDetailService basicCodeDetailService;   
	
	@RequestMapping(value = "/master", method = RequestMethod.GET, produces = APPLICATION_JSON)	
    public Responses.ListResponse getMasterList(RequestParams<BasicCodeMasterVO> requestParams) {
		//UserLogUtil.saveUserLog("-","기초코드","GET");
		List<BasicCodeMasterVO> list = basicCodeMasterService.getBasicMasterList(requestParams);
        return Responses.ListResponse.of(list); 
    }

    @RequestMapping(value = "/master", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveMaster(@RequestBody List<BasicCodeMasterVO> list) {
        List<BasicCodeMaster> masterList = ModelMapperUtils.mapList(list, BasicCodeMaster.class);
        basicCodeMasterService.save(masterList);
        return ok();
    }

    @RequestMapping(value = "/master", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteMaster(@RequestParam(value = "mainCd") String mainCd) {
    	//basicCodeMasterService.deleteByKeys(mainCd);
    //	basicCodeMasterService.delete(mainCd);
        return ok();
    }
    
    
    @RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getBasicDetailList(RequestParams<BasicCodeDetailVO> requestParams) {
		List<BasicCodeDetailVO> codes = basicCodeDetailService.getBasicDetailList(requestParams);
		//UserLogUtil.saveUserLog("BasicCodeController","BasicCode Detail","GET");
        return Responses.ListResponse.of(codes); 
    } 
    
    @RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<BasicCodeDetail> list) {
    	//UserLogUtil.saveUserLog("BasicCodeController","BasicCode Detail","PUT");
        basicCodeDetailService.saveCodeDetail(list);
        return ok(); 
    }    
    
    @RequestMapping(value = "/detail", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse childDelete(@RequestParam(value = "subCd") List<String> subCodes) {
        return ok();
    }

    @RequestMapping(value = "/getAllByCodeMap", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Map<String, List<BasicCodeDetailVO>> getAllByCodeMap() {
        return BasicCodeUtils.getAllByCodeMap();
    }
}
