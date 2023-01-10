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
import com.ppm.mes.domain.eq.eq000.EquipMaster;
import com.ppm.mes.domain.eq.eq000.EquipMasterService;
import com.ppm.mes.domain.eq.eq000.EquipMasterVO;
 /*
  * 설비마스터관리
  */
@Controller
@RequestMapping(value = "/api/v1/equip")
public class EquipMasterController extends BaseController {
 
    @Inject private EquipMasterService equipMasterService;
    
   	@RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getEquipList(RequestParams<EquipMasterVO> requestParams) {
   		List<EquipMasterVO> list = equipMasterService.getEquipList(requestParams);
   		//UserLogUtil.saveUserLog("EquipMasterController","Equip List","GET");
        return Responses.ListResponse.of(list); 
    }     
   	
   	@RequestMapping(value = "equipCd" , method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getCheckEquipCd(RequestParams<EquipMaster> requestParams) {
   		List<EquipMaster> list = equipMasterService.getCheckEquipCd(requestParams);
   		//UserLogUtil.saveUserLog("EquipMasterController","getCheckEquipCd","GET");
        return Responses.ListResponse.of(list); 
    }	
   	
   	
    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public EquipMaster saveEquip(@RequestBody EquipMaster eq) {
    	//UserLogUtil.saveUserLog("EquipMasterController","Equip Save","PUT");
    	return equipMasterService.save(eq);
    }    
    
    @RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteEquip(@RequestBody EquipMaster t) {    			
    	//UserLogUtil.saveUserLog("EquipMasterController","Equip Delete","DELETE");
    	equipMasterService.delete(t);
    	return ok();
    }
    
}