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
import com.ppm.mes.domain.sa.sa400.Sales;
import com.ppm.mes.domain.sa.sa400.SalesListVO;
import com.ppm.mes.domain.sa.sa400.SalesService;
import com.ppm.mes.domain.sa.sa400.SalesVO;
import com.ppm.mes.domain.sa.sa410.SalesDetailService;

/*
 * 판매관리
 */
@Controller
@RequestMapping(value = "/api/v1/sales")	//판매서
public class SalesController extends BaseController {

    @Inject private SalesService salesService;    
    @Inject private SalesDetailService salesDetailService;    

   	// vo
   	@RequestMapping(value = "header", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse vo(RequestParams<SalesVO> vo) {   		
   		List<SalesVO> list = salesService.header(vo);
   		//UserLogUtil.saveUserLog("SalesController","Sales","GET");
   		return Responses.ListResponse.of(list);
   	}
   	
	// 품목별 견적현황
	@RequestMapping(value = "itemList", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse itemList(RequestParams<SalesVO> vo) {
		List<SalesVO> list = salesService.itemDetail(vo);
		return Responses.ListResponse.of(list);
	}
	
    //임시저장,확정
    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public Sales save(@RequestBody Sales request) {
    	//UserLogUtil.saveUserLog("SalesController","Sales","PUT");
    	return salesService.saveForm(request);
    }
    
    //삭제
    @RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody Sales t) {    
    	//UserLogUtil.saveUserLog("SalesController","Sales","DELETE");
    	salesDetailService.deleteAll(t);
    	return ok();
    }    
    
    

	// 기간별_연별_월
	@RequestMapping(value = "itemDetailGroupByYearMon", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse itemDetailGroupByYearMon(RequestParams<SalesListVO> request) {
    	//UserLogUtil.saveUserLog("SalesOrderController","수주현황-기간별_연별_월","");
		List<SalesListVO> list = salesService.itemDetailGroupByYearMon(request);
		return Responses.ListResponse.of(list);
	}
    
	// 기간별_연별_분기
	@RequestMapping(value = "itemDetailGroupByYearQuater", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse itemDetailGroupByYearQuater(RequestParams<SalesListVO> request) {
    	//UserLogUtil.saveUserLog("SalesOrderController","수주현황-기간별_연별_분기","");
		List<SalesListVO> list = salesService.itemDetailGroupByYearQuater(request);
		return Responses.ListResponse.of(list);
	}

    
	// 기간별_연별_월
	@RequestMapping(value = "itemDetailGroupByYearCust", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse itemDetailGroupByYearCust(RequestParams<SalesListVO> request) {
    	//UserLogUtil.saveUserLog("SalesOrderController","수주현황-기간별_연별_월","");
		List<SalesListVO> list = salesService.itemDetailGroupByYearCust(request);
		return Responses.ListResponse.of(list);
	}


    //기간별_지역별_연월별
	@RequestMapping(value = "itemDetailGroupByMonthCust", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse itemDetailGroupByMonthCust(RequestParams<SalesListVO> request) {
    	//UserLogUtil.saveUserLog("SalesOrderController","수주현황-기간별_지역별_연월별","");
		List<SalesListVO> list = salesService.itemDetailGroupByMonthCust(request);
		return Responses.ListResponse.of(list);
	}
    //기간별_지역별_연월별
	@RequestMapping(value = "itemDetailGroupByYearCust20", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse itemDetailGroupByYearCust20(RequestParams<SalesListVO> request) {
    	//UserLogUtil.saveUserLog("SalesOrderController","수주현황-기간별_지역별_연월별_TOP20","");
		List<SalesListVO> list = salesService.itemDetailGroupByYearCust20(request);
		return Responses.ListResponse.of(list);
	}
    
}