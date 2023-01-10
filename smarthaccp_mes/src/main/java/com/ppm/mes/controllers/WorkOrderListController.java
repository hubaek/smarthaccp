package com.ppm.mes.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.prd.list.PrdEquipMonitListVO;
import com.ppm.mes.domain.prd.list.PrdIncomingListVO;
import com.ppm.mes.domain.prd.list.PrdListService;
import com.ppm.mes.domain.prd.list.PrdOrderBadVO;
import com.ppm.mes.domain.prd.list.PrdOrderListVO;
import com.ppm.mes.domain.prd.list.PrdOrderNwrkVO;
import com.ppm.mes.domain.prd.list.PrdOrderOutgoingListVO;
import com.ppm.mes.domain.prd.list.PrdWorkManListVO;
import com.ppm.mes.domain.prd.list.PrdWorkOrderListVO;
import com.ppm.mes.domain.prd.pop.BadTypeListVO;
import com.ppm.mes.domain.prd.pop.NwrkTypeListVO;
import com.ppm.mes.domain.prd.pop.PopService;

/*
 * 생산 각종현황
 */
@Controller
@RequestMapping(value = "/api/v1/worderList")
public class WorkOrderListController extends BaseController {

	@Inject private PrdListService prdListService;    
    @Inject private PopService popService;

	// 작업지시현황
	@RequestMapping(value = "workOrderList", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse workOrderList(RequestParams<PrdWorkOrderListVO> request) {
		List<PrdWorkOrderListVO> list = prdListService.workOrderList(request);
		//UserLogUtil.saveUserLog("WorkOrderListController","Work Order List","GET");
		return Responses.ListResponse.of(list);
	}
	// 생산일보
	@RequestMapping(value = "orderList1", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse orderList1(RequestParams<PrdOrderListVO> request) {
		List<PrdOrderListVO> list = prdListService.orderList1(request);
		//UserLogUtil.saveUserLog("WorkOrderListController","Work List(day)","GET");
		return Responses.ListResponse.of(list);
	}
	
	// 비가동현황
	@RequestMapping(value = "nwrkList", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse nwrkList(RequestParams<PrdOrderNwrkVO> request) {
		List<PrdOrderNwrkVO> list = prdListService.nwrkList(request);
		//UserLogUtil.saveUserLog("WorkOrderListController","Work NWRK List","GET");
		return Responses.ListResponse.of(list);
	}
	
	// 불량현황
	@RequestMapping(value = "badList", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse badList(RequestParams<PrdOrderBadVO> request) {
		List<PrdOrderBadVO> list = prdListService.badList(request);
		//UserLogUtil.saveUserLog("WorkOrderListController","Work Bad List","GET");
		return Responses.ListResponse.of(list);
	}
	
	//lot 추적 생산현황
	@RequestMapping(value = "orderListForLot", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse orderListForLot(RequestParams<PrdOrderListVO> request) {
		List<PrdOrderListVO> list = prdListService.orderListForLot(request);   
		return Responses.ListResponse.of(list);
	}
	
	//lot 추적 - 사용 자재
	@RequestMapping(value = "outItemListForLot", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse outItemListForLot(RequestParams<PrdOrderListVO> request) {
		List<PrdOrderListVO> list = prdListService.outItemListForLot(request);   
		return Responses.ListResponse.of(list);
	}
    
    //생산자재출고
    @RequestMapping(value="outgoingList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse outgoingList(RequestParams<PrdOrderOutgoingListVO> requestParams) {
    	List<PrdOrderOutgoingListVO> list = prdListService.outgoingList(requestParams);
        return Responses.ListResponse.of(list); 
    }

    //생산입고 
    @RequestMapping(value="incomingList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse incomingList(RequestParams<PrdIncomingListVO> requestParams) {
    	List<PrdIncomingListVO> list = prdListService.incomingList(requestParams);
        return Responses.ListResponse.of(list); 
    }   
    
    //생산작업자 작업현황 
    @RequestMapping(value="workManList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse workManList(RequestParams<PrdWorkManListVO> requestParams) {
    	List<PrdWorkManListVO> list = prdListService.workManList(requestParams);
        return Responses.ListResponse.of(list); 
    }
    
    //불량유형
    @RequestMapping(value = "getBadTypeList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<BadTypeListVO> getBadTypeList(RequestParams<BadTypeListVO> requestParams) {
    	//UserLogUtil.saveUserLog("WorkOrderListController","BadTypeList","GET");
        return popService.getBadTypeList(requestParams);
    }

    //비가동유형
    @RequestMapping(value = "getNwrkTypeList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<NwrkTypeListVO> getNwrkTypeList(RequestParams<NwrkTypeListVO> requestParams) {
    	//UserLogUtil.saveUserLog("WorkOrderListController","NwrkTypeList","GET");
        return popService.getNwrkTypeList(requestParams);
    }    

    //설비모니터링_TV
    @RequestMapping(value = "equipMonitList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<PrdEquipMonitListVO> equipMonitList(RequestParams<PrdEquipMonitListVO> requestParams) {
        return prdListService.equipMonitList(requestParams);
    }    
    
}