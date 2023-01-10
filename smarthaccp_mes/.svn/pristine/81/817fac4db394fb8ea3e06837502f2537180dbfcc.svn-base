package com.ppm.mes.domain.haccp.car.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.chequer.axboot.core.parameter.RequestParams;
import com.querydsl.core.BooleanBuilder;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpCarMasterService extends BaseService <HaccpCarMaster, HaccpCarMaster.HaccpCarMasterId>{

	private HaccpCarMasterRepository repository;
	
	
	@Inject
	public HaccpCarMasterService(HaccpCarMasterRepository repository) {
		super(repository);
        this.repository = repository;
	}
	public List<HaccpCarMaster> getList(RequestParams requestParams){
		
		String company = requestParams.getString("company", "");
		String inspectionYm = requestParams.getString("inspectionYm", "");
		String fromDate = requestParams.getString("fromDate",""); 
		String toDate = requestParams.getString("toDate","");
		String writer = requestParams.getString("writer", "");
		String reviewer = requestParams.getString("reviewer","");
		String approver = requestParams.getString("approver","");
		BooleanBuilder builder = new BooleanBuilder();
		
		//조건절 추가를 위한 코드 삽입 자리
		if(isNotEmpty(company)){	
			builder.and(qHaccpCarMaster.company.eq(company));
		}
		if(isNotEmpty(inspectionYm)){	
			builder.and(qHaccpCarMaster.inspectionYm.eq(inspectionYm));
		}
		if(isNotEmpty(fromDate)&&isNotEmpty(toDate)){
			builder.and(qHaccpCarMaster.inspectionYm.between(fromDate.substring(0,7),toDate.substring(0,7)));
		}
		if(isNotEmpty(writer)){	
			builder.and(qHaccpCarMaster.writer.like("%" + writer +"%").or(qHaccpCarMaster.writer.like("%" + writer +"%")));
		}
		if(isNotEmpty(reviewer)){	
			builder.and(qHaccpCarMaster.reviewer.like("%" + reviewer+"%").or(qHaccpCarMaster.reviewer.like("%" + reviewer+"%")));
		}
		if(isNotEmpty(approver)){	
			builder.and(qHaccpCarMaster.approver.like("%" + approver+"%").or(qHaccpCarMaster.approver.like("%" + approver+"%")));
		}
		return findAll(builder);
		
	}
	
}
