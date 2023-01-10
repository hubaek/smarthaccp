package com.ppm.mes.domain.prd.prd100;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class WorkPlanService extends BaseService<WorkPlan, WorkPlan.WorkPlanId> {
    private WorkPlanRepository repository;

    @Inject private WorkPlanMapper workPlanMapper;
    
    @Inject
    public WorkPlanService(WorkPlanRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<WorkPlanVO> getPlanList(RequestParams<WorkPlanVO> vo){
    	return workPlanMapper.getPlanList(vo);
    }  
    

    public List<WorkPlanVO> getMonthPlanList(RequestParams<WorkPlanVO> vo){
    	return workPlanMapper.getMonthPlanList(vo);
    }  
    
    
}