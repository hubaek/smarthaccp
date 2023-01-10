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
import com.ppm.mes.domain.prd.prd100.WorkPlan;
import com.ppm.mes.domain.prd.prd100.WorkPlanService;
import com.ppm.mes.domain.prd.prd100.WorkPlanVO;

@Controller
@RequestMapping(value = "/api/v1/workPlan")
public class WorkPlanManageController extends BaseController {

    @Inject private WorkPlanService workPlanService;

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getPlanList(RequestParams<WorkPlanVO> requestParams) {
        List<WorkPlanVO> list = workPlanService.getPlanList(requestParams);
        //UserLogUtil.saveUserLog("WorkPlanManageController","Work getPlanList","GET");
        return Responses.ListResponse.of(list);     
    }
    
    @RequestMapping(value="month", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getMonthPlanList(RequestParams<WorkPlanVO> requestParams) {
        List<WorkPlanVO> list = workPlanService.getMonthPlanList(requestParams);
        //UserLogUtil.saveUserLog("WorkPlanManageController","Work Month Plan","GET");
        return Responses.ListResponse.of(list);     
    }

    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse savePlan(@RequestBody List<WorkPlan> request) {
    	//UserLogUtil.saveUserLog("WorkPlanManageController","Work Plan","PUT");
    	workPlanService.save(request);
    	return ok();
    }
}
