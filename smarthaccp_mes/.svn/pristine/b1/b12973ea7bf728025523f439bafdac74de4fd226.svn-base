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
import com.ppm.mes.domain.appr.appr000.Approval;
import com.ppm.mes.domain.appr.appr000.ApprovalService;
import com.ppm.mes.domain.appr.appr000.ApprovalVO;

@Controller
@RequestMapping(value = "/api/v1/appr")
public class ApprovalController extends BaseController {
    @Inject private ApprovalService approvalService;

   	// 조회
   	@RequestMapping(value="/master", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getList(RequestParams<ApprovalVO> requestParams) {   
        List<ApprovalVO> list = approvalService.getApprovalList(requestParams);
        return Responses.ListResponse.of(list);
   	}

   	//저장
   	@RequestMapping(value="saveApproval", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveApproval(@RequestBody List<Approval>  m) {    	
    	approvalService.saveApproval(m);
    	return ok();
    }
   	
}