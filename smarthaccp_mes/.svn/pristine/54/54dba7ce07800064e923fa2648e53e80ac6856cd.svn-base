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
import com.ppm.mes.domain.material.MaterialMaster;
import com.ppm.mes.domain.material.MaterialMasterService;
import com.ppm.mes.domain.material.MaterialMasterVO;
import com.ppm.mes.domain.material.Detail.MaterialDetail;
import com.ppm.mes.domain.material.Detail.MaterialDetailService;
import com.ppm.mes.domain.material.Detail.MaterialDetailVO;
import com.ppm.mes.domain.material.Detail.MaterialsDetail;
import com.ppm.mes.domain.material.Detail.MaterialsDetailService;
import com.ppm.mes.domain.material.Detail.MaterialsDetailVO;
/**
 * 0. Project	: 코주부
 * 1. 작성자  		: 박혁준
 * 2. 작성일		: 2020.06.26
 * 3. Comment 	: 부자재/부재료 입고검사대장
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */

/*
 * 
 */
@Controller
@RequestMapping(value = "/api/v1/material")
public class MaterialController extends BaseController {

    @Inject private MaterialMasterService materialMasterService;
    @Inject private MaterialDetailService materialDetailService;
    @Inject private MaterialsDetailService materialsDetailService;

    //마스터 조회
    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getMaterialList(RequestParams<MaterialMasterVO> requestParams) {
   		List<MaterialMasterVO> list = materialMasterService.getMaterialList(requestParams);
   		//UserLogUtil.saveUserLog("MaterialController","getMaterialList","GET");
        return Responses.ListResponse.of(list); 
    }
    //입고일자 중복체크
    @RequestMapping(value = "inDate", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getMaterialCheckInDate(RequestParams<MaterialMaster> requestParams) {
    	 List<MaterialMaster> list = materialMasterService.getMaterialCheckInDate(requestParams);
   		//UserLogUtil.saveUserLog("MaterialController","getMaterialCheckInDate","GET");
   		return Responses.ListResponse.of(list); 
    }
    
    //마스터 저장
    @RequestMapping(value = "master", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveMaster(@RequestBody MaterialMaster m){
    	//UserLogUtil.saveUserLog("MaterialController","saveMaterialMaster","PUT");
    	materialMasterService.saveMaterialMaster(m);
    	return ok();
    }
    
  //삭제
    @RequestMapping(value = "delete", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody MaterialMaster m){
    	materialDetailService.deleteMaterialDetail(m);
    	materialsDetailService.deleteMaterialsDetail(m);
    	materialMasterService.deleteAll(m);
    	return ok();
    }
    
    //부재료 상세 조회
    @RequestMapping(value= "detail" , method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getMaterialDetailList(RequestParams<MaterialDetailVO> requestParams) {
   		List<MaterialDetailVO> list = materialDetailService.getMaterialDetailList(requestParams);
   		//UserLogUtil.saveUserLog("MaterialController","getMaterialDetailList","GET");
        return Responses.ListResponse.of(list); 
    }
    
    //부재료 저장
    @RequestMapping(value = "detail", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveMaterialDetail(@RequestBody List<MaterialDetail> list){
    	//UserLogUtil.saveUserLog("MaterialController","saveMaterialDetail","PUT");
    	materialDetailService.saveMaterialDetail(list);
    	return ok();
    }
    
    
    //부자재 상세 조회
    @RequestMapping(value= "details" , method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getMaterialsDetailList(RequestParams<MaterialsDetailVO> requestParams) {
   		List<MaterialsDetailVO> list = materialsDetailService.getMaterialsDetailList(requestParams);
   		//UserLogUtil.saveUserLog("MaterialController","getMaterialsDetailList","GET");
        return Responses.ListResponse.of(list); 
    }
    
  //부재료 저장
    @RequestMapping(value = "details", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveMaterialsDetail(@RequestBody List<MaterialsDetail> list){
    	//UserLogUtil.saveUserLog("MaterialController","saveMaterialsDetail","PUT");
    	materialsDetailService.saveMaterialsDetail(list);
    	return ok();
    }
    
    
    
    
    
    
    
  
}
