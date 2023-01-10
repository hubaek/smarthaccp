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
import com.ppm.mes.domain.wh.wh000.WarehouseMaster;
import com.ppm.mes.domain.wh.wh000.WarehouseMasterService;
import com.ppm.mes.domain.wh.wh000.WarehouseMasterVO;
/*
 * 창고 관리
 */
@Controller
@RequestMapping(value = "/api/v1/whCd")
public class WarehouseController extends BaseController {
	@Inject    
    private WarehouseMasterService warehouseMasterService;   
    
	
	//조회
    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailListsY(RequestParams<WarehouseMasterVO> requestParams) {
		List<WarehouseMasterVO> list = warehouseMasterService.getWarehouseList(requestParams);
		//UserLogUtil.saveUserLog("WarehouseController","WH Master","GET");
        return Responses.ListResponse.of(list); 
    }
    
    //저장
    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse save(@RequestBody WarehouseMaster w) {
    	//UserLogUtil.saveUserLog("WarehouseController","WH Master","PUT");
        warehouseMasterService.saveWarehouse(w);
        return ok(); 
    } 
}
