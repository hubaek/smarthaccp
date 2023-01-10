package com.ppm.mes.controllers;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.ppm.mes.domain.cd.cd100.BasicCodeDetailVO;
import com.ppm.mes.domain.haccp.check.HaccpCheck;
import com.ppm.mes.domain.haccp.check.HaccpCheckService;
import com.ppm.mes.domain.haccp.check.HaccpCheckVO;
import com.ppm.mes.domain.haccp.code.detail.HaccpCodeDetail;
import com.ppm.mes.domain.haccp.code.detail.HaccpCodeDetailService;
import com.ppm.mes.domain.haccp.code.detail.HaccpCodeDetailVO;
import com.ppm.mes.domain.haccp.code.master.HaccpCodeMaster;
import com.ppm.mes.domain.haccp.code.master.HaccpCodeMasterService;
import com.ppm.mes.domain.haccp.code.master.HaccpCodeMasterVO;
import com.ppm.mes.domain.qc.qc200.QcItemVO;
import com.ppm.mes.utils.BasicCodeUtils;
/*
 * 기초데이터 관리 
 */
@Controller
@RequestMapping(value = "/api/v1/haccp") 
public class HaccpController extends BaseController {
	@Inject
    private HaccpCodeMasterService masterService;
	@Inject    
    private HaccpCodeDetailService detailService;
	@Inject    
    private HaccpCheckService checkService;   
	 
	
	@RequestMapping(value = "/master", method = RequestMethod.GET, produces = APPLICATION_JSON)	
    public Responses.ListResponse getMasterList(RequestParams<HaccpCodeMaster> requestParams) {
		List<HaccpCodeMaster> list = masterService.getList(requestParams);
		//UserLogUtil.saveUserLog("HaccpCodeController","HaccpCode Master","GET");
        return Responses.ListResponse.of(list); 
    }

    @RequestMapping(value = "/master", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveMaster(@RequestBody List<HaccpCodeMasterVO> list) {
        List<HaccpCodeMaster> masterList = ModelMapperUtils.mapList(list, HaccpCodeMaster.class);
        masterService.save(masterList);
        return ok();
    }

    @RequestMapping(value = "/master", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteMaster(@RequestParam(value = "mainCode") String mainCode) {
    	//masterService.deleteByKeys(mainCode);
    //	masterService.delete(mainCode);
        return ok();
    }
    
    
    @RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getBasicDetailList(RequestParams<HaccpCodeDetailVO> requestParams) {
    	List<HaccpCodeDetailVO> codes = detailService.getHaccpDetailList(requestParams);
		//UserLogUtil.saveUserLog("HaccpCodeController","HaccpCode Detail","GET");
        return Responses.ListResponse.of(codes); 
    } 
    
    @RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<HaccpCodeDetail> list) {
      //  List<HaccpCodeDetail> detailList = ModelMapperUtils.mapList(list, HaccpCodeDetail.class);
    	//UserLogUtil.saveUserLog("HaccpCodeController","HaccpCode Detail","PUT");
        detailService.saveCodeDetail(list);
        return ok(); 
    }
    
    
    //HACCP기준서 저장
    @RequestMapping(value = "/docSave", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public HaccpCodeDetail docSave(@RequestBody HaccpCodeDetail d) {
    	//UserLogUtil.saveUserLog("HaccpCodeController","docSave","PUT");
        return detailService.saveDoc(d);
    }    
    
    //HACCP기준서 삭제
    @RequestMapping(value = "/docDelete", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse docDelete(@RequestBody HaccpCodeDetail d) {
    	detailService.deleteByKeys(d);
        return ok();
    }

    //HACCP기준서 KEY (첨부파일용)
    @RequestMapping(value = "/docKey", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDocKey(RequestParams<HaccpCodeDetailVO> vo) {
    	List<HaccpCodeDetailVO> codes = detailService.getDocKey(vo);
    	//UserLogUtil.saveUserLog("HaccpCodeController","getDocKey","GET");
    	return Responses.ListResponse.of(codes); 
    } 
    
    @RequestMapping(value = "/getAllByCodeMap", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Map<String, List<BasicCodeDetailVO>> getAllByCodeMap() {
        return BasicCodeUtils.getAllByCodeMap();
    }
    
    //설비별 점검항목
    @RequestMapping(value="groupItem", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getQcGroupItemList(RequestParams<QcItemVO> vo) {
		List<QcItemVO> list = detailService.getHaccpGroupItem(vo);
        return Responses.ListResponse.of(list); 
    }
    
    @RequestMapping(value = "/hygiene", method = RequestMethod.GET, produces = APPLICATION_JSON)	
    public Responses.ListResponse getHygieneList(RequestParams<HaccpCheck> requestParams) {
		List<HaccpCheckVO> list = checkService.getHygieneList(requestParams);
        return Responses.ListResponse.of(list); 
    }
}
