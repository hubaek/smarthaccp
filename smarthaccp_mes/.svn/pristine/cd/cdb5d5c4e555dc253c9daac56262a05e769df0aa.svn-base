package com.ppm.mes.controllers;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.haccp.in.detail.HaccpInDetail;
import com.ppm.mes.domain.haccp.in.detail.HaccpInDetailService;
import com.ppm.mes.domain.haccp.in.detail.HaccpInDetailVO;
import com.ppm.mes.domain.haccp.in.master.HaccpInMaster;
import com.ppm.mes.domain.haccp.in.master.HaccpInMasterService;
import com.ppm.mes.domain.haccp.in.master.HaccpInMasterVO;
import com.ppm.mes.utils.MailConfig;

@Controller
@RequestMapping(value = "/api/v1/HaccpInMaster")
public class HaccpInMasterConteroller extends BaseController {
	
	@Inject private HaccpInMasterService inMasterService;
	@Inject private HaccpInDetailService inDetailService;
	@Inject private MailConfig mail;
	
	
	
	@RequestMapping(value ="/inmaster", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpInMaster> getHaccpInMasterList(RequestParams<HaccpInMasterVO> requestParams){
		System.out.println("requestParams.getString(toDate) : " + requestParams.getString("toDate"));
		System.out.println("requestParams.getString(fromDate) : " + requestParams.getString("fromDate"));
		return inMasterService.getInMasterList(requestParams); 
	}
	
	@RequestMapping(value ="formview", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse formview(RequestParams<HaccpInMasterVO> requestParams){
		System.out.println("******* \n\n fdjsklfjsdaklfds" + requestParams.getString("writer") + "\n *********");
		List<HaccpInMasterVO> list = inMasterService.formview(requestParams);
		return Responses.ListResponse.of(list); 
	}
	
	@RequestMapping(value = "/inmaster", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse masterSave(@RequestBody List<HaccpInMaster> list) {
		inMasterService.save(list);
    	return ok();
    }
	
//	@RequestMapping(value = "/inmaster", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
//    public ApiResponse masterDel(@RequestBody HaccpInMaster t) {
//		inMasterService.masterDel(t);
//    	return ok();
//    }
	@RequestMapping(value = "/inmaster", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
	public List<HaccpInDetail> masterDel(RequestParams<HaccpInMasterVO> vo) {
		return inMasterService.masterDel(vo);		 
	}
	@RequestMapping(value ="checkMonth", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpInMaster> checkMonth(RequestParams<HaccpInMasterVO> requestParams){
		return inMasterService.getCheckMonth(requestParams); 
	}
	
	@RequestMapping(value="/indetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpInDetail> getHaccpInDetailList(RequestParams<HaccpInDetailVO> requestParams){
		return inDetailService.getInDetailList(requestParams); 
	}
	
	@RequestMapping(value = "/indetail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse detailSave(@RequestBody List<HaccpInDetail> list){
		//UserLogUtil.saveUserLog("HaccpInMasterController", "HaccpInDetail Detail", "PUT");		
		inDetailService.saveDetail(list);
		return ok();
	}
	
	@RequestMapping(value = "/indetail", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
	public List<HaccpInDetail> detailDel(RequestParams<HaccpInDetailVO> vo) {
		return inDetailService.detailDel(vo);		 
	}
	
//	@RequestMapping(value = "/indetail", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
//    public ApiResponse detailDel(@RequestBody HaccpInDetail t) {
//		inDetailService.detailDel(t);
//    	return ok();
//    }
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST, produces = APPLICATION_JSON)
	public ApiResponse sendMail(@RequestBody HaccpInMaster t, @RequestBody HaccpInDetail d) throws MessagingException, IOException{
		inMasterService.sendMail(t,d);
		return ok();
	}
	
	
	@RequestMapping(value = "subDel", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
	public ApiResponse delete(@RequestBody HaccpInDetail t){
		inDetailService.deDel(t);
		return ok();
	}
	
	
	
	
}
