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
import com.ppm.mes.domain.wo.wo100.WorkOrderMaster;
import com.ppm.mes.domain.wo.wo100.WorkOrderMasterRequestVO;
import com.ppm.mes.domain.wo.wo100.WorkOrderMasterService;
import com.ppm.mes.domain.wo.wo100.WorkOrderMasterVO;
import com.ppm.mes.domain.wo.wo110.WorkManManage;
import com.ppm.mes.domain.wo.wo110.WorkManManageService;
import com.ppm.mes.domain.wo.wo120.WorkOrderBadRequestVO;
import com.ppm.mes.domain.wo.wo120.WorkOrderBadService;
import com.ppm.mes.domain.wo.wo130.WorkNwrkManage;
import com.ppm.mes.domain.wo.wo130.WorkNwrkManageService;
import com.ppm.mes.domain.wo.wo150.WorkOrderOutgoingItem;
import com.ppm.mes.domain.wo.wo150.WorkOrderOutgoingItemService;
import com.ppm.mes.domain.wo.wo160.WorkOrderIncoming;
import com.ppm.mes.domain.wo.wo160.WorkOrderIncomingVO;
import com.ppm.mes.domain.wo.wo160.WorkOrderIncomingService;

/*
 * 작업지시 마스터 종결되어 WO 발행 후 
 */
@Controller
@RequestMapping(value = "/api/v1/worderMaster")
public class WorkOrderManageController extends BaseController {

    @Inject private WorkOrderMasterService workOrderMasterService;
    @Inject private WorkManManageService workManManageService;
    @Inject private WorkOrderOutgoingItemService workOrderOutgoingItemService;
    @Inject private WorkOrderBadService workOrderBadService;
    @Inject private WorkNwrkManageService workNwrkManageService;
    @Inject private WorkOrderIncomingService workOrderIncomingService;
    //@Inject private WorkOrderInspService workOrderInspService;
        

    //작업자 저장
    @RequestMapping(value="master",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveWorkMaster(@RequestBody List<WorkOrderMaster> request) {
    	workOrderMasterService.saveWorkOrderMaster(request);
    	//UserLogUtil.saveUserLog("WorkOrderManageController","Work Order Master","PUT");
    	return ok();
    }

    @RequestMapping(value = "master",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getWorkMaster(RequestParams<WorkOrderMasterVO> requestParams) {
        List<WorkOrderMasterVO> list = workOrderMasterService.getWorkOrderMasterList(requestParams);
        //UserLogUtil.saveUserLog("WorkOrderManageController","Work Order Master","GET");
        return Responses.ListResponse.of(list);     
    }
    
    //작업자 조회
    @RequestMapping(value = "getWorkMan",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getWorkMan(RequestParams<WorkManManage> requestParams) {
        List<WorkManManage> list = workManManageService.get(requestParams);
        //UserLogUtil.saveUserLog("WorkOrderManageController","Work Man","GET");
        return Responses.ListResponse.of(list);     
    }

    //작업자 저장
    @RequestMapping(value="saveWorkMan",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveWorkMan(@RequestBody List<WorkManManage> request) {
    	//UserLogUtil.saveUserLog("WorkOrderManageController","Work Man","PUT");
    	workManManageService.savePrdWorkMan(request);
    	return ok();
    }
    
    //작업지시>생산출고
    @RequestMapping(value ="savePrdItem",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse savePrdItem(@RequestBody List<WorkOrderOutgoingItem> list) {
    	//UserLogUtil.saveUserLog("WorkOrderManageController","saveWorkOrderOutgoingItems","PUT");
    	workOrderOutgoingItemService.saveWorkOrderOutgoingItems(list);
    	return ok();
    }

    @RequestMapping(value ="cancelPrdItem",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse cancelPrdItem(@RequestBody List<WorkOrderOutgoingItem> list) {
    	//UserLogUtil.saveUserLog("WorkOrderManageController","saveWorkOrderReturnItems","PUT");
    	workOrderOutgoingItemService.saveWorkOrderReturnItems(list);
    	return ok();
    }
    
    //자재사용 저장
    @RequestMapping(value ="saveConsum",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveConsum(@RequestBody List<WorkOrderOutgoingItem> request) {
    	//UserLogUtil.saveUserLog("WorkOrderManageController","SaveConsumUseItem","PUT");
    	workOrderOutgoingItemService.saveWorkOrderConsumUseItem(request);
    	return ok();
    }
    
    //자재사용 > 환입 저장
    @RequestMapping(value ="saveReturnConsum",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveReturnConsum(@RequestBody List<WorkOrderOutgoingItem> request) {
    	//UserLogUtil.saveUserLog("WorkOrderManageController","SaveReturnConsumUseItem","PUT");
    	workOrderOutgoingItemService.saveWorkOrderReturnConsumUseItem(request);
    	return ok();
    }
    
    //자재폐기 저장
    @RequestMapping(value ="saveDiscard",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveDiscard(@RequestBody List<WorkOrderOutgoingItem> request) {
    	//UserLogUtil.saveUserLog("WorkOrderManageController","SaveDiscard","PUT");
    	workOrderOutgoingItemService.saveWorkOrderOutgoingItemList(request);
    	return ok();
    }
    
    //불량 저장
    @RequestMapping(value="saveWorkBad",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveWorkBad(@RequestBody WorkOrderBadRequestVO request) {
    	//UserLogUtil.saveUserLog("WorkOrderManageController","SaveWorkBad","PUT");
    	workOrderBadService.savePrdWorkBad(request);
    	return ok();
    }
    
    //불량 취소
    @RequestMapping(value="cancelWorkBad",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse cancelWorkBad(@RequestBody WorkOrderBadRequestVO request) {
    	//UserLogUtil.saveUserLog("WorkOrderManageController","CancelWorkBad","PUT");
    	workOrderBadService.cancelPrdWorkBad(request);
    	return ok();
    }
    
    //비가동 저장
    @RequestMapping(value="saveWorkNwrk",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse savePrdWorkNwrk(@RequestBody List<WorkNwrkManage> request) {
    	//UserLogUtil.saveUserLog("WorkOrderManageController","SaveWorkNwrk","PUT");
    	workNwrkManageService.savePrdWorkNwrk(request);
    	return ok();
    }

    //생산실적수정
    @RequestMapping(value = "updateWorkMaster", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void updateWorkMaster(@RequestBody WorkOrderMasterRequestVO request) {    
    	if (null != request) {  
    		//생산실적수정
        	workOrderMasterService.updatePrdWorkMaster(request);         
        	//UserLogUtil.saveUserLog("WorkOrderManageController","Update Work Master","PUT");
    	}
    }

    //생산실적삭제
    @RequestMapping(value = "deleteWorkMaster", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void deleteWorkMaster(@RequestBody List<WorkOrderIncoming> list) {    
    	if (null != list) {  
    		//생산실적삭제
        	workOrderMasterService.deletePrdWorkMaster(list);     
        	//UserLogUtil.saveUserLog("WorkOrderManageController","Delete Work Master","DELETE");
    	}
    }
    //생산품 입고 이력 추가
    @RequestMapping(value="insertWorkOrderRecord",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public ApiResponse insertWorkOrderRecord(RequestParams<WorkOrderIncomingVO> request) {
    	//workOrderIncomingService.insertIncomingRecord(request);
    	return ok(); 
    	//Method modification needed - ERROR com.chequer.axboot.core.controllers.BaseController:errorLogging:97 Request method 'GET' not supported   
    }
}
