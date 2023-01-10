package com.ppm.mes.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.ppm.mes.domain.plan.Plan;
import com.ppm.mes.domain.plan.PlanService;
import com.ppm.mes.domain.plan.PlanVO;

@Controller
@RequestMapping(value="/api/v1/plan")
public class PlanController extends BaseController{
	
	@Inject private PlanService plService;
	
	@RequestMapping(value="/getPlanList", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<Plan> getPlanList(RequestParams<PlanVO> params){
		return plService.getPlanList(params);
	}
	@RequestMapping(value="/maxYear", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<PlanVO> maxYear(){
		return plService.maxYear();
	}
	@RequestMapping(value="/PlanList", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<Plan> PlanList(String params){
		return plService.PlanList(params);
	}
	
	@RequestMapping(value = "/putPlan", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse putPlan(@RequestBody List<PlanVO> list) {
		System.out.println("fdsfdsafa service dfadfafadsf");
	   List<Plan> PlanList = ModelMapperUtils.mapList(list, Plan.class);
	   plService.save(PlanList);
	   return ok();
	}
}
