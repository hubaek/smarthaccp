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
import com.ppm.mes.domain.item.item000.ItemMaster;
import com.ppm.mes.domain.item.item000.ItemMasterService;
import com.ppm.mes.domain.item.item000.ItemMasterVO;
import com.ppm.mes.domain.item.item000.ItemPnMasterVO;
import com.ppm.mes.domain.item.item100.ItemGroupMain;
import com.ppm.mes.domain.item.item100.ItemGroupMainService;
import com.ppm.mes.domain.item.item100.ItemGroupMainVO;
import com.ppm.mes.domain.item.item150.ItemGroupSub;
import com.ppm.mes.domain.item.item150.ItemGroupSubService;

/*
 * 품목마스터 관리
 */
@Controller
@RequestMapping(value = "/api/v1/item")
public class ItemMasterController extends BaseController {

    @Inject private ItemMasterService itemMasterService;
    @Inject private ItemGroupMainService itemGroupMainService;
    @Inject private ItemGroupSubService itemGroupSubService;

   	// 조회
   	@RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse list(RequestParams<ItemMasterVO> requestParams) {
        List<ItemMasterVO> list = itemMasterService.getList(requestParams);
        //UserLogUtil.saveUserLog("ItemMasterController","Item List","GET");
        return Responses.ListResponse.of(list);
   	}  	
   	
    //저장
   	@RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ItemMaster save(@RequestBody ItemMaster header) {
   		//UserLogUtil.saveUserLog("ItemMasterController","Item Save","PUT");
    	return itemMasterService.saveItem(header);
    }   	

    @RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteItem(@RequestBody ItemMaster t) {    			
    	//UserLogUtil.saveUserLog("ItemMasterController","Item Delete","DELETE");
    	itemMasterService.delete(t);
    	return ok();
    }    
    
   	// pop 품목조회
   	@RequestMapping( value ="popItemList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse popList(RequestParams<ItemMasterVO> requestParams) {
        List<ItemMasterVO> list = itemMasterService.getPopList(requestParams);
        //UserLogUtil.saveUserLog("ItemMasterController","POP Item List","GET");
        return Responses.ListResponse.of(list);
   	}

    //구매/판매단가 저장
   	@RequestMapping(value ="saveItemOptions", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveItemOptions(@RequestBody List<ItemMaster> list) {
   		//UserLogUtil.saveUserLog("ItemMasterController","Item Options","PUT");
    	itemMasterService.saveItemOptions(list);
    	return ok();
    }

   	// 조회
   	@RequestMapping(value="getRoutingItemList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRoutingItemList(RequestParams<ItemMasterVO> requestParams) {
        List<ItemMasterVO> list = itemMasterService.getRoutingItemList(requestParams);
        //UserLogUtil.saveUserLog("ItemMasterController","Routing-item List","GET");
        return Responses.ListResponse.of(list);
   	}  	

   	// 조회
   	@RequestMapping(value="getRoutItemList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRoutItemList(RequestParams<ItemMasterVO> requestParams) {
        List<ItemMasterVO> list = itemMasterService.getRoutItemList(requestParams);
        //UserLogUtil.saveUserLog("ItemMasterController","Rout-item List","GET");
        return Responses.ListResponse.of(list);
   	}  	

   	// 조회 - PN으로 품목조회
   	@RequestMapping(value="getItemMasterInfo", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public Responses.ListResponse getItemMasterInfo(@RequestBody List<ItemPnMasterVO> lists) {
        List<ItemPnMasterVO> list = itemMasterService.getItemMasterInfo(lists);
        return Responses.ListResponse.of(list);
   	}  	

   	// 품목대분류 조회
   	@RequestMapping(value="itemMain",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getItemMainList(RequestParams<ItemGroupMainVO> requestParams) {   
		//UserLogUtil.saveUserLog("-","품목대분류","GET");  
        List<ItemGroupMainVO> list = itemGroupMainService.getItemMainList(requestParams);
        return Responses.ListResponse.of(list);
   	}

   	// 품목소분류 조회
   	@RequestMapping(value="itemSub",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getItemSubList(RequestParams<ItemGroupMainVO> requestParams) {   
		//UserLogUtil.saveUserLog("-","품목소분류","GET");  
        List<ItemGroupMainVO> list = itemGroupMainService.getItemSubList(requestParams);
        return Responses.ListResponse.of(list);
   	}

   	/*                  
	20.07.13 김재민 
	신규 formView 와 gridView02가 함께 저장 되게끔 수정
    */
   	// 품목대분류 저장
   	@RequestMapping(value="itemMain", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ItemGroupMain saveItemMain(@RequestBody ItemGroupMain m) {    	
   		return itemGroupMainService.saveItemMain(m);
   		//return ok();
    }

   	// 품목대분류 삭제
   	@RequestMapping(value="itemMain", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteItemMain(@RequestBody ItemGroupMain m) {    	
   		itemGroupMainService.deleteItemMain(m);
   		return ok();
    }

   	// 품목소분류 저장
   	@RequestMapping(value="itemSub", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveItemSub(@RequestBody List<ItemGroupSub> list) {    	
   		itemGroupSubService.saveItemSub(list);
   		return ok();
    }
}