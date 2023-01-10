package com.ppm.mes.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.prd.pop.BadTypeListVO;
import com.ppm.mes.domain.prd.pop.DiscardTypeListVO;
import com.ppm.mes.domain.prd.pop.NwrkTypeListVO;
import com.ppm.mes.domain.prd.pop.PopService;
import com.ppm.mes.domain.prd.pop.PopVO;
import com.ppm.mes.domain.prd.pop.StockListVO;
import com.ppm.mes.domain.prd.pop.WorkBadListVO;
import com.ppm.mes.domain.prd.pop.WorkManListVO;
import com.ppm.mes.domain.prd.pop.WorkOrderListVO;
import com.ppm.mes.domain.prd.pop.WorkOutgoingListVO;
import com.ppm.mes.domain.prd.pop.WorkRequestVO;
import com.ppm.mes.domain.qc.qc300.QcResultMaster;
import com.ppm.mes.domain.qc.qc300.QcResultMasterService;
import com.ppm.mes.domain.rt.rt000.RoutManManagementVO;
import com.ppm.mes.domain.rt.rt000.RoutManagementService;
import com.ppm.mes.domain.sys.sys300.PopManage;
import com.ppm.mes.domain.sys.sys300.PopManageService;
import com.ppm.mes.domain.wo.wo100.WorkOrderMaster;
import com.ppm.mes.domain.wo.wo100.WorkOrderMasterService;
import com.ppm.mes.domain.wo.wo110.WorkManManage;
import com.ppm.mes.domain.wo.wo110.WorkManManageService;
import com.ppm.mes.domain.wo.wo120.WorkOrderBad;
import com.ppm.mes.domain.wo.wo120.WorkOrderBadService;
import com.ppm.mes.domain.wo.wo130.WorkNwrkManageService;
import com.ppm.mes.domain.wo.wo150.WorkOrderOutgoingItemService;
import com.ppm.mes.domain.wo.wo160.WorkOrderIncoming;
import com.ppm.mes.domain.wo.wo160.WorkOrderIncomingService;

//현장 API  
@RestController
public class PopController extends BaseController {
	
	@Inject private PopService popService;
	@Inject private WorkOrderMasterService workOrderMasterService;
	@Inject private WorkNwrkManageService workNwrkManageService;
	@Inject private WorkOrderOutgoingItemService workOrderOutgoingItemService;
	@Inject private WorkManManageService workManManageService;
	@Inject private WorkOrderIncomingService workOrderIncomingService;
	@Inject private WorkOrderBadService workOrderBadService;
	@Inject private RoutManagementService routManagementService;   
    @Inject private QcResultMasterService qcResultMasterService;	
	@Inject private PopManageService popManageService;
	//작업지시목록
    @RequestMapping(value = "/api/v1/pop2/getWorkOrderList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<WorkOrderListVO> getWorkOrderList(RequestParams<WorkOrderListVO> requestParams) {
        return popService.getWorkOrderList(requestParams);
    }
    
	//작업지시목록 생산실적 모니터링용 2021-01-18 cju
    @RequestMapping(value = "/api/v1/pop2/getWorkOrderList02", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<WorkOrderListVO> getWorkOrderList02(RequestParams<WorkOrderListVO> requestParams) {
        return popService.getWorkOrderList02(requestParams);
    }
    
    //지시 상태변경
    @RequestMapping(value = "/api/v1/pop2/updateWorkStatus", method = RequestMethod.POST, produces = APPLICATION_JSON)
    public void updateWorkStatus(@RequestBody WorkOrderMaster requestParams) {    	
        workOrderMasterService.updateWorkStatus(requestParams);
    }

    //작업시작
    @RequestMapping(value = "/api/v1/pop2/updateWorkStart", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void updateWorkStart(@RequestBody WorkRequestVO request) {           
    	
    	WorkOrderMaster master = request.getWorkMaster();
    	//지시상태변경
        if(null != master){	
        	workOrderMasterService.updateWorkStart(master);
        }        
        
        //작업자
        if(null != request.getWorkMan()){            
        	List<WorkManManage> mans = request.getWorkMan();
        	for (WorkManManage m : mans) {
        		m.setWlotNo(master.getWlotNo());
        	}
        	workManManageService.saveWorkMan(mans);      
        }                
    }
    
    //작업종료
    @RequestMapping(value = "/api/v1/pop2/updateWorkEnd", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void updateWorkEnd(@RequestBody WorkOrderMaster master) {  
    	//지시 상태변경
        if(null != master){
        	workOrderMasterService.updateWorkEnd(master);			// 	작업종료
        	workManManageService.updateEndWorkMan(master);			//	작업자종료
        	workOrderMasterService.updateNextWork(master);			//	다음오더 갱신 (연속생산)
	    	//실적번호가 있을경우, 작업종료시 해당 로뜨 사용여부 항목 N 처리.
        	workOrderOutgoingItemService.saveWorkOrderItem(master);
        }
    }
    //작업종료 추가
    @RequestMapping(value = "/api/v1/pop2/newupdateWorkEnd", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void newupdateWorkEnd(@RequestBody WorkOrderMaster master) {  
    	//지시 상태변경
        if(null != master){
        	workOrderMasterService.updateWorkEnd(master);
        	workManManageService.updateEndWorkMan(master);			//	작업자종료
        }   
    }   
    
    //작업취소
    @RequestMapping(value = "/api/v1/pop2/updateWorkCancel", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void updateWorkCancel(@RequestBody WorkOrderMaster master) {  
    	//작업취소
        if(null != master){
        	workOrderMasterService.updateWorkCancel(master);
        }
    }
    

    //작업취소(삭제)
    @RequestMapping(value = "/api/v1/pop2/updateWorkCancelAll", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void updateWorkCancelAll(@RequestBody List<WorkOrderMaster> list) {  
    	//작업취소
        if(null != list){
        	workOrderMasterService.updateWorkCancelAll(list);
        }
    }
    
    //비가동-작업시작
    @RequestMapping(value = "/api/v1/pop2/updateWorkNwrk", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void updateNwrk(@RequestBody WorkOrderMaster master) {
    	workNwrkManageService.updateWorkNwrk(master);	//비가동>가동
        workOrderMasterService.updateWorkStatus(master);	//작업지시:비가동>가동
    }

    //양품등록
    @RequestMapping(value = "/api/v1/pop2/updateWorkProdQty", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void updateWorkProdQty(@RequestBody WorkOrderIncoming m) {    	

        workOrderIncomingService.saveIncomingItem(m.getWlotNo() , m.getItemQty());    
        
		//오더마스터 생산수량 업데이트
    	BigDecimal prodQty = workOrderMasterService.updateWorkProdQty(m.getWlotNo());
    	
    	//작업자별 생산수량
        workManManageService.updateManProdQty(m.getWlotNo(), m.getItemQty()); 	
        
		//자동선출자재 
		workOrderOutgoingItemService.saveAutoFifoItem(m.getWlotNo() , m.getItemQty()) ;
    }

    //양품등록취소
    @RequestMapping(value = "/api/v1/pop2/cancelWorkProdQty", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void cancelWorkProdQty(@RequestBody WorkOrderIncoming m) {    	
    	workOrderIncomingService.cancelIncomingItem(m); 
        
		//오더마스터 생산수량 업데이트
    	BigDecimal prodQty = workOrderMasterService.updateWorkProdQty(m.getWlotNo());
    	
    	//작업자별 생산수량
        workManManageService.updateManProdQty(m.getWlotNo(), m.getItemQty()); 	
    }

    //자재출고 저장
    @RequestMapping(value ="/api/v1/pop2/saveOutgoing",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveOutgoing(@RequestBody WorkRequestVO request) {    

    	if (null != request.getWorkMaster()) {  
        	if (null != request.getWorkOutgoingItem()) {  
        		workOrderOutgoingItemService.saveWorkOrderOutgoingItem(request.getWorkOutgoingItem());
        	}
    	}
    	return ok();
    }

    //자재출고 취소
    @RequestMapping(value ="/api/v1/pop2/cancelOutgoing",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse cancelOutgoing(@RequestBody WorkRequestVO m) {    
    	if (null != m.getWorkMaster()) {  
        	if (null != m.getWorkOutgoingItem()) {  
        		workOrderOutgoingItemService.saveWorkOrderCancelOutgoingItem(m.getWorkOutgoingItem());
        	}
    	}
    	return ok();
    }

    //자재환입
    @RequestMapping(value ="/api/v1/pop2/updateOutgoing",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse updateOutgoing(@RequestBody WorkRequestVO m) {    
    	
    	if (null != m.getWorkMaster()) {  
        	if (null != m.getWorkOutgoingItem()) {  
        		workOrderOutgoingItemService.saveWorkOrderReturnItem(m.getWorkOutgoingItem());
        	}
    	}
    	return ok();
    }

	//작업자정보
    @RequestMapping(value = "/api/v1/pop2/getWorkManList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<RoutManManagementVO> getWorkManList(RequestParams<RoutManManagementVO> requestParams) {
    	return routManagementService.getRoutManList(requestParams);
    }

	//지시별 - 작업자정보
    @RequestMapping(value = "/api/v1/pop2/getWorkOrderManList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<WorkManListVO> getWorkOrderManList(RequestParams<WorkManListVO> requestParams) {
    	return popService.getWorkOrderManList(requestParams);
    } 
        

	//자재출고대상 - bom
    @RequestMapping(value = "/api/v1/pop2/getStockBomList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<StockListVO> getStockBomList(RequestParams<StockListVO> requestParams) {
    	return popService.getStockBomList(requestParams);
    }         
    
    //자재출고 리스트
    @RequestMapping(value = "/api/v1/pop2/getOutgoingList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<WorkOutgoingListVO> getOutgoingList(RequestParams<WorkOrderListVO> requestParams) {
        return popService.getOutgoingList(requestParams);
    }
    
    //불량유형
    @RequestMapping(value = "/api/v1/pop2/getBadTypeList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<BadTypeListVO> getBadTypeList(RequestParams<BadTypeListVO> requestParams) {
        return popService.getBadTypeList(requestParams);
    }
    
    //불량등록내역
    @RequestMapping(value = "/api/v1/pop2/getWorkBadList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<WorkBadListVO> getWorkBadList(RequestParams<WorkBadListVO> requestParams) {
        return popService.getWorkBadList(requestParams);
    }


    //비가동유형
    @RequestMapping(value = "/api/v1/pop2/getNwrkTypeList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<NwrkTypeListVO> getNwrkTypeList(RequestParams<NwrkTypeListVO> requestParams) {
        return popService.getNwrkTypeList(requestParams);
    }    

    //폐기유형
    @RequestMapping(value = "/api/v1/pop2/getDiscardTypeList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<DiscardTypeListVO> getDiscardTypeList(RequestParams<DiscardTypeListVO> requestParams) {
        return popService.getDiscardTypeList(requestParams);
    }    

    //불량등록
    @RequestMapping(value ="/api/v1/pop2/saveWorkBad",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveWorkBad(@RequestBody WorkOrderBad request) {  
    	if(null!=request){
    		//불량저장       	
        	workOrderBadService.saveWorkBad(request);	   
    	}
    	return ok();
    }   

    //불량취소
    @RequestMapping(value ="/api/v1/pop2/cancelWorkBad",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse cancelWorkBad(@RequestBody WorkOrderBad request) {    	
    	if(null!=request){
    		//불량취소
        	workOrderBadService.cancelWorkBad(request);	          	
    	}
    	return ok();
    }        
    
    //비가동등록
    @RequestMapping(value ="/api/v1/pop2/saveWorkNwrk",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveWorkNwrk(@RequestBody WorkRequestVO request) {    
    	if(null!=request.getWorkNwrk()){
    		workNwrkManageService.saveWorkNwrk(request.getWorkNwrk());
        	workOrderMasterService.updateWorkStatus(request.getWorkMaster());
    	}
    	return ok();
    }   

    //설비등록
    @RequestMapping(value ="/api/v1/pop2/updateEquip",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse updateEquip(@RequestBody WorkOrderMaster workMaster) {    
    	if(null!=workMaster){
        	workOrderMasterService.updateEquip(workMaster);
    	}
    	return ok();
    }   

    //작업자추가
    @RequestMapping(value = "/api/v1/pop2/addWorkMan", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void updateWorkStart(@RequestBody List<WorkManManage> workMans) {       
    	workManManageService.saveWorkMan(workMans);      
    }

    //작업자종료
    @RequestMapping(value = "/api/v1/pop2/endWorkMan", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void updateWorkStart(@RequestBody WorkManManage workMan) {       
    	workManManageService.endWorkMan(workMan);      
    }    


    //설정가져오기
    @RequestMapping(value = "/api/v1/pop2/getSetup", method = RequestMethod.GET)
    public PopManage getSetup(RequestParams<PopManage> requestParam) {  
    	return popManageService.getSetup(requestParam);
    }
    
    //설정저장
    @RequestMapping(value = "/api/v1/pop2/saveSetup", method = RequestMethod.PUT)
    public ApiResponse saveSetup(@RequestBody PopManage m) {  
    	popManageService.savePopSetup(m);
    	return ok();    	
    }
    
    //공정검사저장    
    @RequestMapping(value = "/api/v1/pop2/saveRoutInsp", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void saveRoutInsp(@RequestBody QcResultMaster m) {    
    	qcResultMasterService.saveQcResultRoutMaster(m);      
    }
    
    //작업표준서 리스트
    @RequestMapping(value = "/api/v1/pop2/getWoDocFileList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<Long> getWoDocFileList(RequestParams<WorkOrderListVO> requestParam) {  
    	return popService.getWoDocFileList(requestParam);      
    }
    

    //액빼기등록
    @RequestMapping(value = "/api/v1/pop2/updateLiquid", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void updateLiquid(@RequestBody WorkOrderMaster requestParams) {
        workOrderMasterService.updateLiquid(requestParams);	//작업지시:비가동>가동
    }
    
    //분할바코드갯수조회
    @RequestMapping(value ="/api/v1/pop2/getDividedBarcodeCnt", method=RequestMethod.GET, produces = APPLICATION_JSON)
    public List<PopVO> getDividedBarcodeCnt(RequestParams<PopVO> requestParam){
        return popService.getDividedBarcodeCnt(requestParam);
    }
}