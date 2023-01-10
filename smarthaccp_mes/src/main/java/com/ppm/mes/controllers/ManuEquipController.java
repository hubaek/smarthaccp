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
import com.ppm.mes.domain.eq.manu.ManuEquip;
import com.ppm.mes.domain.eq.manu.ManuEquipService;
import com.ppm.mes.domain.eq.manu.ManuEquipVO;
import com.ppm.mes.domain.eq.manu.detail.ManuDetailEquip;
import com.ppm.mes.domain.eq.manu.detail.ManuDetailEquipService;
import com.ppm.mes.domain.eq.manu.detail.ManuDetailEquipVO;
/**
 * 0. Project	: 코주부
 * 1. 작성자  		: 박혁준
 * 2. 작성일		: 2020.06.23
 * 3. Comment 	: 설비이력카드
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */


/*
 * 설비이력카드 관리
 */
@Controller
@RequestMapping(value = "/api/v1/manuEquip")
public class ManuEquipController extends BaseController {
	
    @Inject private ManuEquipService manuEquipService;
    @Inject private ManuDetailEquipService manuDetailEquipService;

   	// 조회
    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getEquipList(RequestParams<ManuEquipVO> requestParams) {
   		List<ManuEquipVO> list = manuEquipService.getEquipList(requestParams);
   		//UserLogUtil.saveUserLog("ManuEquipController","Equip List","GET");
        return Responses.ListResponse.of(list); 
    }
    
    // 상세조회
    @RequestMapping(value= "detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getEquipDetailList(RequestParams<ManuDetailEquipVO> requestParams) {
   		List<ManuDetailEquipVO> list = manuDetailEquipService.getEquipDetailList(requestParams);
   		//UserLogUtil.saveUserLog("ManuEquipController","EquipDetail List","GET");
        return Responses.ListResponse.of(list); 
    }
    
    //마스터 저장
    @RequestMapping(value = "master", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveMaster(@RequestBody ManuEquip list){
    	//UserLogUtil.saveUserLog("ManuEquipController","saveManuEquip","PUT");
    	manuEquipService.saveManuEquip(list);
    	return ok();
    }
    //삭제
    @RequestMapping(value = "delete", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody ManuEquip m){
    	manuDetailEquipService.deleteDetail(m);
    	manuEquipService.deleteAll(m);
    	return ok();
    }
  //디테일 저장
    @RequestMapping(value = "detail", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<ManuDetailEquip> list){
    	//UserLogUtil.saveUserLog("ManuEquipController","childSave","PUT");
    	manuDetailEquipService.saveEquipDetail(list);
    	return ok();
    }
  //입고일자 중복체크
    @RequestMapping(value = "manageNoCheck", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getManageCheck(RequestParams<ManuEquip> requestParams) {
    	 List<ManuEquip> list = manuEquipService.getManageCheck(requestParams);
   		//UserLogUtil.saveUserLog("MaterialController","getMaterialCheckInDate","GET");
   		return Responses.ListResponse.of(list); 
    }
    
   	 	
}