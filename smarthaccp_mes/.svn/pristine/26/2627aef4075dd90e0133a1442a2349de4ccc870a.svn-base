package com.ppm.mes.controllers;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.st.st000.SalesOutVO;
import com.ppm.mes.domain.st.st000.StockMasterService;
import com.ppm.mes.domain.st.st000.StockMasterVO;
import com.ppm.mes.domain.st.st200.StockOut;
import com.ppm.mes.domain.st.st200.StockOutService;
import com.ppm.mes.domain.st.st500.StockBox;
import com.ppm.mes.domain.st.st500.StockBoxService;
import com.ppm.mes.domain.st.st500.StockBoxVO;
/*
 * 재고관리
 */
@Controller
@RequestMapping(value = "/api/v1/stock")	//재고
public class StockController extends BaseController {
	
	@Inject private StockBoxService stockBoxService;
    @Inject private StockMasterService stockMasterService;
    @Inject private StockOutService stockOutService;

    //현재고
   	@RequestMapping(value ="getStockMaster",method = RequestMethod.GET, produces = APPLICATION_JSON)   	
   	public Responses.ListResponse getStockMaster(RequestParams<StockMasterVO> requestParams) {
   		List<StockMasterVO> stocks = stockMasterService.getStockMaster(requestParams);
        return Responses.ListResponse.of(stocks);
   	}  
   	
    //통합-창고,품목별
   	@RequestMapping(value ="stockGroupByAll",method = RequestMethod.GET, produces = APPLICATION_JSON)   	
   	public Responses.ListResponse stockGroupByAll(RequestParams<StockMasterVO> requestParams) {
   		List<StockMasterVO> stocks = stockMasterService.stockGroupByAll(requestParams);
        return Responses.ListResponse.of(stocks);
   	}
   	
    //2020-09-23 바코드 서치
   	@RequestMapping(value ="stockBarcodeSearch",method = RequestMethod.GET, produces = APPLICATION_JSON)   	
   	public Responses.ListResponse stockBarcodeSearch(RequestParams<StockMasterVO> requestParams) {
   		List<StockMasterVO> stocks = stockMasterService.stockBarcodeSearch(requestParams);
        return Responses.ListResponse.of(stocks);
   	}
  //2020-10-12 출고여부 서치
   	@RequestMapping(value ="outYNSearch",method = RequestMethod.GET, produces = APPLICATION_JSON)   	
   	public Responses.ListResponse outYNSearch(RequestParams<StockMasterVO> requestParams) {
   		List<StockMasterVO> stocks = stockMasterService.outYNSearch(requestParams);
        return Responses.ListResponse.of(stocks);
   	}
   	
   	//수불원장
   	@RequestMapping(value ="getStockHistory",method = RequestMethod.GET, produces = APPLICATION_JSON)   	
   	public Responses.ListResponse getStockHistory(RequestParams<StockMasterVO> requestParams) {
   		List<StockMasterVO> stocks = stockMasterService.getStockHistory(requestParams);
        return Responses.ListResponse.of(stocks);
   	}     	
   	
   	//제품출고등록
   	@RequestMapping(value ="stockOutItem",method = RequestMethod.PUT, produces = APPLICATION_JSON)   	
   	public ApiResponse stockOutItem(@RequestBody List<StockOut> list) {
   		stockOutService.stockOutItem(list);
   		return ok();
   	}  

   	//제품출고등록-취소
   	@RequestMapping(value ="stockOutCancelItem",method = RequestMethod.PUT, produces = APPLICATION_JSON)   	
   	public ApiResponse stockOutCancelItem(@RequestBody List<StockOut> list) {
   		stockOutService.stockOutCancelItem(list);
   		return ok();
   	}  
   	
   	//출하창고입고등록
   	@RequestMapping(value ="salesInItem",method = RequestMethod.PUT, produces = APPLICATION_JSON)   	
   	public ApiResponse salesInItem(@RequestBody List<SalesOutVO> list) {
   		stockMasterService.salesInItem(list);
   		return ok();
   	} 
   	
   	//제품출고현황
   	@RequestMapping(value ="getStockOutList",method = RequestMethod.GET, produces = APPLICATION_JSON)   	
   	public Responses.ListResponse getStockOutList(RequestParams<StockMasterVO> requestParams) {
   		List<StockMasterVO> stocks = stockMasterService.getStockOutList(requestParams);
        return Responses.ListResponse.of(stocks);
   	}
   	
   	//바코드발행
   	@RequestMapping(value ="stockBox",method = RequestMethod.PUT, produces = APPLICATION_JSON)   	
   	public ApiResponse saveStockBox(@RequestBody List<StockBox> list) {
   		stockBoxService.saveStockBox(list);
   		return ok();
   	}  

    //바코드발행현황
   	@RequestMapping(value ="stockBox",method = RequestMethod.GET, produces = APPLICATION_JSON)   	
   	public Responses.ListResponse getStockBoxList(RequestParams<StockBoxVO> requestParams) {
   		List<StockBoxVO> stocks = stockBoxService.getStockBoxList(requestParams);
        return Responses.ListResponse.of(stocks);
   	}
   	
    //안전재고 체크 및 메일전송
   	@RequestMapping(value ="chksafetyQtyandsendMail", method = {RequestMethod.POST}, produces = APPLICATION_JSON)   	
   	public void chksafetyQtyandsendMail(@RequestBody Map<String, Object> paramMap) {
   		stockOutService.chksafetyQtyandsendMail(paramMap);
   	}
   	
   	//QR코드 인쇄 처리
   	/* 낭만연구소
   	@RequestMapping(value ="getQRcode", method = {RequestMethod.GET}, produces = APPLICATION_JSON)   	
   	public Map<String, Map<String, Object>> getQRcode() {
   		return stockOutService.getQRcode();
   	}
   	*/
   	
}