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
import com.ppm.mes.domain.qc.qc000.QcMaster;
import com.ppm.mes.domain.qc.qc000.QcMasterService;
import com.ppm.mes.domain.qc.qc100.QcGroup;
import com.ppm.mes.domain.qc.qc100.QcGroupService;
import com.ppm.mes.domain.qc.qc100.QcGroupVO;
import com.ppm.mes.domain.qc.qc110.QcGroupItem;
import com.ppm.mes.domain.qc.qc110.QcGroupItemService;
import com.ppm.mes.domain.qc.qc200.QcItem;
import com.ppm.mes.domain.qc.qc200.QcItemService;
import com.ppm.mes.domain.qc.qc200.QcItemTargetVO;
import com.ppm.mes.domain.qc.qc200.QcItemVO;
import com.ppm.mes.domain.qc.qc300.QcResultDetailVO;
import com.ppm.mes.domain.qc.qc300.QcResultMaster;
import com.ppm.mes.domain.qc.qc300.QcResultMasterService;
import com.ppm.mes.domain.qc.qc300.QcResultMasterVO;
import com.ppm.mes.domain.qc.qc350.QcResultDetail;
import com.ppm.mes.domain.qc.qc350.QcResultDetailService;
import com.ppm.mes.domain.qc.qc400.QcResultBadRequestVO;
import com.ppm.mes.domain.qc.qc400.QcResultBadService;
import com.ppm.mes.domain.qc.qc400.QcResultBadVO;
/*
 * QC 관리
 */
@Controller
@RequestMapping(value = "/api/v1/qcManage")
public class QcManageController extends BaseController {
	
	@Inject private QcMasterService qcMasterService;
	@Inject private QcGroupService qcGroupService;   
	@Inject private QcGroupItemService qcGroupItemService;
	@Inject private QcItemService qcItemService;
	@Inject private QcResultMasterService qcResultMasterService;   
	@Inject private QcResultDetailService qcResultDetailService;
	@Inject private QcResultBadService qcResultBadService;  

	//검사항목 마스터조회
    @RequestMapping(value="master", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getQcMaster(RequestParams<QcMaster> requestParams) {
		List<QcMaster> list = qcMasterService.getQcMaster(requestParams);
		//UserLogUtil.saveUserLog("QcManageController","QC Master","GET");
        return Responses.ListResponse.of(list); 
    }
    
    //검사항목 마스터 저장
    @RequestMapping(value="master",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveQcMaster(@RequestBody List<QcMaster> request) {
    	//UserLogUtil.saveUserLog("QcManageController","QC Master","PUT");
    	qcMasterService.saveQcMaster(request);
        return ok(); 
    }    
    
	//검사그룹조회
    @RequestMapping(value="group", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getQcGroupList(RequestParams<QcGroupVO> requestParams) {
		List<QcGroupVO> list = qcGroupService.getQcGroupList(requestParams);
		//UserLogUtil.saveUserLog("QcManageController","QC Group","GET");
        return Responses.ListResponse.of(list); 
    }
    
    //검사그룹저장
    @RequestMapping(value="group",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public QcGroup saveQcGroup(@RequestBody QcGroup m) {
    	//UserLogUtil.saveUserLog("QcManageController","QC Group","PUT");
        return qcGroupService.saveQcGroup(m);
    }

	//검사그룹별 검사항목
    @RequestMapping(value="groupItem", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getQcGroupItemList(RequestParams<QcItemVO> vo) {
    	//UserLogUtil.saveUserLog("QcManageController","QC Group Item","GET");
		List<QcItemVO> list = qcItemService.getQcGroupItem(vo);
        return Responses.ListResponse.of(list); 
    }
    
    //검사그룹별 항목저장
    @RequestMapping(value="groupItem",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveQcGroupItem(@RequestBody List<QcGroupItem> request) {
    	//UserLogUtil.saveUserLog("QcManageController","QC Group Item","PUT");
    	qcGroupItemService.saveQcGroupItem(request);
        return ok(); 
    }

    //품목별 검사항목 조회 (검사유형별)
    @RequestMapping(value="item", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getQcItem(RequestParams<QcItemVO> vo) {
    	//UserLogUtil.saveUserLog("QcManageController","QC Item","GET");
		List<QcItemVO> list = qcItemService.getQcItem(vo);
        return Responses.ListResponse.of(list); 
    }

    //품목별 검사항목 등록 (검사유형별)
    @RequestMapping(value="item", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveQcItem(@RequestBody List<QcItem> list) {
    	//UserLogUtil.saveUserLog("QcManageController","QC Item","PUT");
    	qcItemService.saveQcItem(list);
        return ok(); 
    } 

	//검사대상 품목리스트 - 수입/출하검사
    @RequestMapping(value="getQcItemTargetList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getQcItemTargetList(RequestParams<QcItemTargetVO> requestParams) {
    	//UserLogUtil.saveUserLog("QcManageController","QC Item Target","GET");
		List<QcItemTargetVO> list = qcItemService.getQcItemTargetList(requestParams);
        return Responses.ListResponse.of(list); 
    }

	//검사대상 품목리스트 - 공정검사
    @RequestMapping(value="getQcRoutItemTargetList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getQcRoutItemTargetList(RequestParams<QcItemTargetVO> requestParams) {
		List<QcItemTargetVO> list = qcItemService.getQcRoutItemTargetList(requestParams);
        return Responses.ListResponse.of(list); 
    }

    //그룹별 검사항목마스터 - 공정검사 그룹별 검사항목 전체 - SETUP 용
    @RequestMapping(value="getQcRoutItemSetupList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getQcRoutItemSetupList(RequestParams<QcItemVO> requestParams) {
		List<QcItemVO> list = qcItemService.getQcRoutItemSetupList(requestParams);
        return Responses.ListResponse.of(list); 
    }

	//검사 대상 조회
    @RequestMapping(value="getQcMasterList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getQcMasterList(RequestParams<QcResultMasterVO> requestParams) {
		List<QcResultMasterVO> list = qcResultMasterService.getQcMasterList(requestParams);
        return Responses.ListResponse.of(list); 
    }
    
	//검사 대상 조회 (공정검사)
    @RequestMapping(value="getRoutQcMaster", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getRoutQcMaster(RequestParams<QcResultMasterVO> requestParams) {
		List<QcResultMasterVO> list = qcResultMasterService.getRoutQcMaster(requestParams);
        return Responses.ListResponse.of(list); 
    }
	 

    //검사 대상 검사등록
    @RequestMapping(value="saveQcResultMaster", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveQcResultMaster(@RequestBody List<QcResultMaster> request) {
    	qcResultMasterService.saveQcResultMaster(request);
        return ok(); 
    }
    
    //검사 대상 검사항목 결과조회
    @RequestMapping(value="getQcDetailList",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getQcResultDetail(RequestParams<QcResultDetailVO> requestParams) {
    	//UserLogUtil.saveUserLog("QcManageController","QC Detail List","GET");
		List<QcResultDetailVO> list = qcResultMasterService.getQcResultDetail(requestParams);
        return Responses.ListResponse.of(list); 
    }
    
    //검사대상 불량등록
    @RequestMapping(value="badDetail",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse save(@RequestBody QcResultBadRequestVO request) {
    	//UserLogUtil.saveUserLog("QcManageController","QC Bad Detail","PUT");
    	qcResultBadService.saveInspectionBadDetail(request);
        return ok(); 
    }
    
    //검사대상 불량등록현황
    @RequestMapping(value="getQcBadList",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getQcBadList(RequestParams<QcResultBadVO> requestParams) {
		List<QcResultBadVO> list = qcResultBadService.getQcBadList(requestParams);
		//UserLogUtil.saveUserLog("QcManageController","QC Bad List","GET");
        return Responses.ListResponse.of(list); 
    }
      
    //부적합현황
    @RequestMapping(value="getQcBadDetailList",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getQcBadDetailList(RequestParams<QcResultBadVO> requestParams) {
		List<QcResultBadVO> list = qcResultBadService.getQcBadDetailList(requestParams);
		//UserLogUtil.saveUserLog("QcManageController","QC Bad Detail List","GET");
        return Responses.ListResponse.of(list); 
    }

    //검사항목 상세 결과 수정 (공정검사측정치수정)
    @RequestMapping(value="resultDetail",method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveQcResultDetail(@RequestBody List<QcResultDetail> list) {
    	//UserLogUtil.saveUserLog("QcManageController","QC Master","PUT");
    	qcResultDetailService.save(list);
        return ok(); 
    }    
    

    //공정검사확정    
    @RequestMapping(value = "saveConfirmQc", method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public void saveConfirmQc(@RequestBody List<QcResultMaster> list) {    
		if(null != list){
        	for (QcResultMaster i : list) {
        		i.setConfirmYn("Y");
        	}	        	
		}
		qcResultMasterService.save(list);      
    	//UserLogUtil.saveUserLog("WorkOrderManageController","Rout Confirm Insp","PUT");
    }
}
