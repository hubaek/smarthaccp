package com.ppm.mes.controllers;

import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.appr.appr000.Approval;
import com.ppm.mes.domain.appr.appr000.ApprovalService;
import com.ppm.mes.domain.report.DailyReport000;
import com.ppm.mes.domain.report.DailyReport000Service;
import com.ppm.mes.domain.report.DailyReport010;
import com.ppm.mes.domain.report.DailyReport010Service;
import com.ppm.mes.domain.report.DailyReport020;
import com.ppm.mes.domain.report.DailyReport020Service;
import com.ppm.mes.domain.report.DailyReport030;
import com.ppm.mes.domain.report.DailyReport030Service;

@Controller
@RequestMapping(value = "/api/v1/dailyreport")
public class DailyReportController extends BaseController {

	private Approval approval;
	
    @Inject
    private DailyReport000Service dailyReport000Service;
    
    @Inject
    private DailyReport010Service dailyReport010Service;
    
    @Inject
    private DailyReport020Service dailyReport020Service;
    
    @Inject
    private DailyReport030Service dailyReport030Service;
    
    @Inject
    private ApprovalService approvalService;
    
    public DailyReportController(Approval approval){
    	this.approval = approval;
    }
    
    @RequestMapping(value="recentlyTemplate", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.MapResponse recentlyTemplate(RequestParams<DailyReport000> requestParams){
    	DailyReport000 recentlyTemplate = dailyReport000Service.recentlyTemplate(requestParams);
    	
    	Map<String,Object> retMap = new HashMap<String,Object>();
    	retMap.put("recentlyTemplate",recentlyTemplate);
    	return Responses.MapResponse.of(retMap);
    }
    
    @RequestMapping(value="duplicateReportDt", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.MapResponse duplicateReportDt(RequestParams<DailyReport010> requestParams){
    	boolean dup = dailyReport010Service.duplicateReportDt(requestParams);
    	
    	Map<String,Object> retMap = new HashMap<String,Object>();
    	retMap.put("isDup", dup);
    	return Responses.MapResponse.of(retMap);
    }

    @RequestMapping(value="template", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse template(RequestParams<DailyReport000> requestParams) {
        List<DailyReport000> list = dailyReport000Service.gets(requestParams);
        return Responses.ListResponse.of(list);
    }
    
    @RequestMapping(value="masterList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse masterList(RequestParams<DailyReport010> requestParams) {
        List<DailyReport010> list = dailyReport010Service.gets(requestParams);
        return Responses.ListResponse.of(list);
    }
    
    @RequestMapping(value="master", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.MapResponse master(RequestParams<DailyReport010> requestParams) {
        DailyReport010 dailyReport010 = dailyReport010Service.getOne(requestParams);
        
        Map<String,Object> retMap = new HashMap<String,Object>();
    	retMap.put("master", dailyReport010);
        return Responses.MapResponse.of(retMap);
    }
    
    @RequestMapping(value="detail",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse list(RequestParams<DailyReport020> requestParams) {
        List<DailyReport020> list = dailyReport020Service.gets(requestParams);
        return Responses.ListResponse.of(list);
    }
    
    @RequestMapping(value="ccpDetail",method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse ccpList(RequestParams<DailyReport030> requestParams) {
        List<DailyReport030> list = dailyReport030Service.gets(requestParams);
        return Responses.ListResponse.of(list);
    }

    @RequestMapping(value="saveMaster", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveMaster(@RequestBody List<DailyReport010> request) {
        dailyReport010Service.saveReport010(request);
        
        //결재상신
        List<Approval> apprList = new ArrayList<>();
        for(DailyReport010 c: request){
    		//결재ID 체크
        	if(!StringUtils.isEmpty(c.getApprovalId())){    			
    			approval.setCompany(c.getCompany());
    			approval.setApprovalId(c.getApprovalId());
    			approval.setDocumentClassifyCd(c.getTemplateId());
    			approval.setApprovalStateCd(c.getStatus());
    			if("20".equals(c.getStatus())){
    				approval.setDrafterId(c.getWriter());
    				approval.setDraftDtm(Instant.now(Clock.systemUTC()));
    			}else if("40".equals(c.getStatus()) || "50".equals(c.getStatus())){
    				approval.setApproverId(c.getApprover());
    				approval.setApprovalDtm(Instant.now(Clock.systemUTC()));
    			}
    			apprList.add(approval);
    		}
    	}
        //결재 데이터가 있을때만  결재 테이블에 저장한다
        if(apprList.size() > 0){        	
        	approvalService.saveApproval(apprList);
        }
        
        return ok();
    }
    
    @RequestMapping(value="saveDetail", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveDetail(@RequestBody List<DailyReport020> request) {
        dailyReport020Service.saveReport020(request);
        return ok();
    }
    
    @RequestMapping(value="saveCcpDetail", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveCcpDetail(@RequestBody List<DailyReport030> request) {
        dailyReport030Service.saveReport030(request);
        return ok();
    }
    
    @RequestMapping(value="saveTemplate", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveTemplate(@RequestBody List<DailyReport000> request) {
        dailyReport000Service.saveReport000(request);
        return ok();
    }
    
    @RequestMapping(value="deleteMaster", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse deleteMaster(@RequestBody List<DailyReport010> request) {
        dailyReport010Service.delete(request);
        return ok();
    }
    
    @RequestMapping(value="deleteDetail", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse deleteDetail(@RequestBody List<DailyReport020> request) {
        dailyReport020Service.delete(request);
        return ok();
    }
    
    @RequestMapping(value="deleteCcpDetail", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse deleteCcpDetail(@RequestBody List<DailyReport030> request) {
        dailyReport030Service.delete(request);
        return ok();
    }
    
}