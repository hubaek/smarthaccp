package com.ppm.mes.domain.plan;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class PlanService extends BaseService<Plan, String>{
	
	private PlanRepository plRepository;
	@Inject private PlanMapper plMapper;
	
	@Inject
	public PlanService(PlanRepository plRepository){
		super(plRepository);
		this.plRepository = plRepository;
	}
	
	public List<Plan> getPlanList(RequestParams<PlanVO> params) {
		String year = params.getString("qcYyyy", "");
		String qcNm = params.getString("qcNm", "");
		
		BooleanBuilder builder = new BooleanBuilder();
		
		if(isNotEmpty(year)){
			builder.and(qPlan.qcYyyy.eq(year));
		}
		if(isNotEmpty(qcNm)){
			builder.and(qPlan.qcNm.like("%"+qcNm+"%"));
		}
		return findAll(builder);
	}

	public List<Plan> PlanList(String params) {
		
		BooleanBuilder builder = new BooleanBuilder();
		
		if(isNotEmpty(params)){
			builder.and(qPlan.qcYyyy.eq(params));
		}
		return findAll(builder);
	}

	public List<PlanVO> maxYear() {
		return plMapper.maxYear();
	}
}
