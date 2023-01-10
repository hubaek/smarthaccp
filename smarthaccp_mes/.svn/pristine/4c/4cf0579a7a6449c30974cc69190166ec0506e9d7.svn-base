package com.ppm.mes.controllers;


import java.util.HashMap;
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
import com.ppm.mes.domain.haccp.itemCheck.ItemCheckMaster;
import com.ppm.mes.domain.haccp.itemCheck.ItemCheckMasterService;
import com.ppm.mes.domain.haccp.itemCheck.ItemCheckMasterVO;
import com.ppm.mes.domain.haccp.itemCheck.detail.ItemCheckDetail;
import com.ppm.mes.domain.haccp.itemCheck.detail.ItemCheckDetailSerivce;
import com.ppm.mes.domain.haccp.itemCheck.detail.ItemCheckDetailVO;

/**
 * 0. Project	: 코주부
 * 1. 작성자  		: 박혁준
 * 2. 작성일		: 2020.07.03
 * 3. Comment 	: 제품검사대장
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
@Controller
@RequestMapping(value = "/api/v1/itemCheck")
public class ItemCheckController extends BaseController {
	
	@Inject private ItemCheckMasterService itemCheckMasterService;
	@Inject private ItemCheckDetailSerivce itemCheckDetailSerivce;
	
	// 조회
    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getItemCheckList(RequestParams<ItemCheckMasterVO> requestParams) {
   		List<ItemCheckMaster> list = itemCheckMasterService.getItemCheckList(requestParams);
   		//UserLogUtil.saveUserLog("ItemCheckController","getItemCheckList","GET");
        return Responses.ListResponse.of(list); 
    }
	//점검월 중복체크
    @RequestMapping(value = "inspectionYm", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getItemCheckMonth(RequestParams<ItemCheckMaster> requestParams) {
    	List<ItemCheckMaster> list = itemCheckMasterService.getItemCheckMonth(requestParams);
   		//UserLogUtil.saveUserLog("ItemCheckController","getItemCheckMonth","GET");
        return Responses.ListResponse.of(list);
    }
    
  //프린터
    @RequestMapping(value = "print" , method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.MapResponse getItemCheckListPrint(RequestParams<ItemCheckMaster> requestParams) {
    	ItemCheckMaster master = itemCheckMasterService.getItemCheckPrint(requestParams);
    	List<ItemCheckDetail> detail = itemCheckDetailSerivce.getItemCheckPrintDetailList(requestParams);
    	Map<String,Object> map = new HashMap<>();
    	map.put("master", master);
    	map.put("detail", detail);
    	return Responses.MapResponse.of(map);
    }
    
    
    //마스터 저장
    @RequestMapping(value = "master", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveMaster(@RequestBody ItemCheckMaster m){
    	//UserLogUtil.saveUserLog("ItemCheckController","saveItemCheckMaster","PUT");
    	itemCheckMasterService.saveItemCheckMaster(m);
    	return ok();
    }
    
    //삭제
    @RequestMapping(value = "delete", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody ItemCheckMaster m){
    	itemCheckDetailSerivce.deleteDetailAll(m);
    	itemCheckMasterService.deleteAll(m);
    	return ok();
    }
    
    // 디테일조회
    @RequestMapping(value = "detail" , method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getItemCheckDetailList(RequestParams<ItemCheckDetailVO> requestParams) {
   		List<ItemCheckDetailVO> list = itemCheckDetailSerivce.getItemCheckDetailList(requestParams);
   		//UserLogUtil.saveUserLog("ItemCheckController","getItemCheckList","GET");
        return Responses.ListResponse.of(list); 
    }
    
    
    //디테일 저장
    @RequestMapping(value = "detail", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveDetail(@RequestBody List<ItemCheckDetail> list){
    	//UserLogUtil.saveUserLog("ItemCheckController","saveItemCheckDetail","PUT");
    	itemCheckDetailSerivce.saveItemCheckDetail(list);
    	return ok();
    }
    
    
}
