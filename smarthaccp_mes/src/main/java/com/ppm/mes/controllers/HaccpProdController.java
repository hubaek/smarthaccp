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
import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.ppm.mes.domain.haccp.prod.detail.HaccpProdDetail;
import com.ppm.mes.domain.haccp.prod.detail.HaccpProdDetailService;
import com.ppm.mes.domain.haccp.prod.detail.HaccpProdDetailVO;
import com.ppm.mes.domain.haccp.prod.master.HaccpProdMaster;
import com.ppm.mes.domain.haccp.prod.master.HaccpProdMasterService;
import com.ppm.mes.domain.haccp.prod.master.HaccpProdMasterVO;

/*내포장설비*/
@Controller
@RequestMapping(value="/api/v1/haccpProd")
public class HaccpProdController extends BaseController{
	
	@Inject
	private HaccpProdMasterService prodMasterService;
	@Inject
	private HaccpProdDetailService prodDetailService;
	
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpProdMasterVO> getMasterList(RequestParams<HaccpProdMasterVO> requestParams){
		return prodMasterService.getMasterList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HaccpProdMasterVO> list) {
		List<HaccpProdMaster> masterList = ModelMapperUtils.mapList(list, HaccpProdMaster.class);
		prodMasterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList(RequestParams<HaccpProdDetailVO> requestParams) {

		List<HaccpProdDetailVO> codes = prodDetailService.getHaccpProdDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpProdController","HaccpProd Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getHaccpDetailList(RequestParams<HaccpProdDetailVO> requestParams) {

		List<HaccpProdDetailVO> codes = prodDetailService.getHaccpDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpProdController","Prod Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<HaccpProdDetail> list) {
    	//UserLogUtil.saveUserLog("HaccpProdController","HaccpProd Detail","PUT");
    	prodDetailService.saveHaccpProdDetailList(list);
        return ok(); 
    }
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HaccpProdMaster> list) {    	
    	//UserLogUtil.saveUserLog("HaccpProdController","HaccpProd","DELETE");
    	prodDetailService.deleteAll(list);
    	return ok();
    }
}
