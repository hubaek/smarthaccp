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
import com.ppm.mes.domain.rt.rt000.RoutBadVO;
import com.ppm.mes.domain.rt.rt000.RoutEquipManagementVO;
import com.ppm.mes.domain.rt.rt000.RoutItemInfoVO;
import com.ppm.mes.domain.rt.rt000.RoutManManagementVO;
import com.ppm.mes.domain.rt.rt000.RoutManagement;
import com.ppm.mes.domain.rt.rt000.RoutManagementService;
import com.ppm.mes.domain.rt.rt000.RoutManagementVO;
import com.ppm.mes.domain.rt.rt000.RoutingItemDetailVO;
import com.ppm.mes.domain.rt.rt000.RoutingItemVO;
import com.ppm.mes.domain.rt.rt100.RoutingMaster;
import com.ppm.mes.domain.rt.rt100.RoutingMasterService;
import com.ppm.mes.domain.rt.rt110.RoutingDetail;
import com.ppm.mes.domain.rt.rt110.RoutingDetailService;
import com.ppm.mes.domain.rt.rt120.RoutingItem;
import com.ppm.mes.domain.rt.rt120.RoutingItemService;
import com.ppm.mes.domain.rt.rt200.RoutMan;
import com.ppm.mes.domain.rt.rt200.RoutManService;
import com.ppm.mes.domain.rt.rt300.RoutEquip;
import com.ppm.mes.domain.rt.rt300.RoutEquipService;
import com.ppm.mes.domain.rt.rt400.RoutItemInfo;
import com.ppm.mes.domain.rt.rt400.RoutItemInfoService;
import com.ppm.mes.domain.rt.rt500.RoutNwrk;
import com.ppm.mes.domain.rt.rt500.RoutNwrkService;
import com.ppm.mes.domain.rt.rt600.RoutBad;
import com.ppm.mes.domain.rt.rt600.RoutBadService;
import com.ppm.mes.domain.rt.rt700.RoutQcGbn;
import com.ppm.mes.domain.rt.rt700.RoutQcGbnService;
/*
 * rout 관리
 */
@Controller
@RequestMapping(value = "/api/v1/rout")
public class RoutManageController extends BaseController {

	@Inject private RoutingMasterService routingMasterService;
	@Inject private RoutingDetailService routingDetailService;
	@Inject private RoutingItemService routingItemService;
	@Inject private RoutManagementService routManagementService;   
	@Inject private RoutManService routManManagementService;   
	@Inject private RoutEquipService routEquipManagementService;
	@Inject private RoutItemInfoService routItemInfoService;
	@Inject private RoutNwrkService routNwrkService;
	@Inject private RoutBadService routBadService;
	@Inject private RoutQcGbnService routQcGbnService;
	

    ///라우팅
   	// 조회 (마스터)
   	@RequestMapping(value="routingMaster",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRoutingList(RequestParams<RoutingMaster> master) {    
        List<RoutingMaster> list = routingMasterService.getRoutingList(master);
        //UserLogUtil.saveUserLog("RoutManageController","Routing Master","GET");
        return Responses.ListResponse.of(list);
   	}
   	
    //저장 (마스터)
   	@RequestMapping(value="routingMaster",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveRouting(@RequestBody RoutingMaster master) {    	
   		//UserLogUtil.saveUserLog("RoutManageController","Routing Master","PUT");
   		routingMasterService.saveRouting(master);
    	return ok();
    }   

   	//조회 (공정절차)
   	@RequestMapping(value="routingDetail",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRoutingDetailList(RequestParams<RoutingDetail> detail) {    
        List<RoutingDetail> list = routingDetailService.getRoutingDetailList(detail);
        //UserLogUtil.saveUserLog("RoutManageController","Routing Detail","GET");
        return Responses.ListResponse.of(list);
   	}
   	
    //저장 (공정절차)
   	@RequestMapping(value="routingDetail",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveRoutingDetail(@RequestBody List<RoutingDetail> list) {    	
   		//UserLogUtil.saveUserLog("RoutManageController","Routing Detail","PUT");
   		routingDetailService.saveRoutingDetail(list);
    	return ok();
    }   

   	// 조회 (라우팅-품목)
   	@RequestMapping(value="routingItem",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRoutingItemList(RequestParams<RoutingItemVO> detail) {    
        List<RoutingItemVO> list = routManagementService.getRoutingItemList(detail);
        //UserLogUtil.saveUserLog("RoutManageController","Routing Item","GET");
        return Responses.ListResponse.of(list);
   	}
   	
    //저장 (라우팅-품목)
   	@RequestMapping(value="routingItem",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveRoutingItem(@RequestBody List<RoutingItem> list) {    
   		//UserLogUtil.saveUserLog("RoutManageController","Routing Item","PUT");
   		routingItemService.saveRoutingItem(list);
    	return ok();
    }   

    //라우팅 - 공정절차 조회
    @RequestMapping(value="step",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRoutStepList(RequestParams<RoutingItemDetailVO> requestParams) {
    	//UserLogUtil.saveUserLog("RoutManageController","Rout Step","GET");
		List<RoutingItemDetailVO> list = routManagementService.getRoutingItemDetailList(requestParams);
        return Responses.ListResponse.of(list); 
    }

    //품목별 생산정보 (작업표준)
    @RequestMapping(value="routItemInfo",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRoutItemInfo(RequestParams<RoutItemInfoVO> requestParams) {
    	//UserLogUtil.saveUserLog("RoutManageController","Rout Item Info","GET");
		List<RoutItemInfoVO> list = routManagementService.getRoutItemInfo(requestParams);
        return Responses.ListResponse.of(list); 
    }

   	
    //저장 (라우팅-품목)
   	@RequestMapping(value="routItemInfo",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveRoutItemInfo(@RequestBody List<RoutItemInfo> list) {    	
   		//UserLogUtil.saveUserLog("RoutManageController","Rout Item Info","PUT");
   		routItemInfoService.save(list);
    	return ok();
    }
   	
   	//공정
	//조회
    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRout(RequestParams<RoutManagementVO> requestParams) {
		List<RoutManagementVO> lists = routManagementService.get(requestParams);
		//UserLogUtil.saveUserLog("RoutManageController","Rout","GET");
        return Responses.ListResponse.of(lists); 
    }
    
    //저장
    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public RoutManagement save(@RequestBody RoutManagement m) {
    	//UserLogUtil.saveUserLog("RoutManageController","Rout","PUT");
    	return routManagementService.saveRout(m);
    }     

    //공정별 인원 조회
    @RequestMapping(value="man",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRoutManList(RequestParams<RoutManManagementVO> requestParams) {
    	//UserLogUtil.saveUserLog("RoutManageController","Rout Man","GET");
		List<RoutManManagementVO> list = routManagementService.getRoutManList(requestParams);
        return Responses.ListResponse.of(list); 
    }
    
    //공정별 인원 저장
    @RequestMapping(value="man",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveRoutMan(@RequestBody List<RoutMan> list) {
    	//UserLogUtil.saveUserLog("RoutManageController","Rout Man","PUT");
    	routManManagementService.save(list);
        return ok(); 
    } 

    //공정별 설비 조회
    @RequestMapping(value="equip",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRoutEquipList(RequestParams<RoutEquipManagementVO> requestParams) {
		List<RoutEquipManagementVO> lists = routManagementService.getRoutEquipList(requestParams);
		//UserLogUtil.saveUserLog("RoutManageController","Rout Equip","GET");
        return Responses.ListResponse.of(lists); 
    }

    //공정별 설비 저장
    @RequestMapping(value="equip",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveRoutEquip(@RequestBody List<RoutEquip> list) {
    	//UserLogUtil.saveUserLog("RoutManageController","Rout Equip","PUT");
    	routEquipManagementService.save(list);
        return ok(); 
    } 


    //공정별 비가동 조회
    @RequestMapping(value="nwrk",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRoutNwrk(RequestParams<RoutNwrk> requestParams) {
		List<RoutNwrk> lists = routNwrkService.getList(requestParams);
		//UserLogUtil.saveUserLog("RoutManageController","Rout NWRK","GET");
        return Responses.ListResponse.of(lists); 
    }

    //공정별 비가동 저장
    @RequestMapping(value="nwrk",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveRoutNwrk(@RequestBody List<RoutNwrk> list) {
    	//UserLogUtil.saveUserLog("RoutManageController","Rout NWRK","PUT");
    	routNwrkService.save(list);
        return ok(); 
    }     

    //공정별 불량 조회
    @RequestMapping(value="bad",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRoutBad(RequestParams<RoutBadVO> requestParams) {
		List<RoutBadVO> lists = routManagementService.getRoutBadList(requestParams);
		//UserLogUtil.saveUserLog("RoutManageController","Rout Bad","GET");
        return Responses.ListResponse.of(lists); 
    }

    //공정별 불량 저장
    @RequestMapping(value="bad",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveRoutBad(@RequestBody List<RoutBad> list) {
    	//UserLogUtil.saveUserLog("RoutManageController","Rout Bad","PUT");
    	routBadService.save(list);
        return ok(); 
    } 

    //공정별 검사종류조회
    @RequestMapping(value="qcGbn",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRoutQcGbnList(RequestParams<RoutQcGbn> requestParams) {
		List<RoutQcGbn> lists = routQcGbnService.getRoutQcGbnList(requestParams);
        return Responses.ListResponse.of(lists); 
    }

    //공정별 검사종류저장
    @RequestMapping(value="qcGbn",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveRoutQcGbn(@RequestBody List<RoutQcGbn> list) {
    	routQcGbnService.save(list);
        return ok(); 
    } 
}
