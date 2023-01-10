package com.ppm.mes.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;

import com.ppm.mes.domain.haccp.waste.master.HaccpWasteMaster;
import com.ppm.mes.domain.haccp.waste.master.HaccpWasteMasterService;
import com.ppm.mes.domain.haccp.waste.master.HaccpWasteMasterVO;

@Controller
@RequestMapping(value="/api/v1/haccpWaste")
public class HaccpWasteController extends BaseController{
	
	@Inject
	private HaccpWasteMasterService haccpWasteMasterService;
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpWasteMasterVO> getMasterList(RequestParams<HaccpWasteMasterVO> requestParams){
		return haccpWasteMasterService.getMasterList(requestParams);
	}
	
	//마스터 저장
	@RequestMapping(value = "/master", method = { RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveHaccpWasteMaster(@RequestBody List<HaccpWasteMaster> list) {
		
        //List<HaccpWasteMaster> masterWasteList = ModelMapperUtils.mapList(list, HaccpWasteMaster.class);
        haccpWasteMasterService.saveHaccpWasteMaster(list);
        return ok();
    }
	
	//삭제 
	@RequestMapping(value = "/master" ,method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
	public ApiResponse deleteAll(@RequestBody List<HaccpWasteMaster> list){
		//UserLogUtil.saveUserLog("HaccpWasteController","HaccpWaste","DELETE");
		haccpWasteMasterService.deleteHaccpWasteMaster(list);
		return ok();
	}
}
