package com.ppm.mes.domain.selfHygine.code;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;


@Service
public class SelfHygineMasterService extends BaseService <SelfHygineMaster,SelfHygineMaster.SelfHygineMasterId> {
	private SelfHygineMasterRepository repository;
	
	@Inject private SelfHygineMasterMapper selfHygineMasterMapper;
    @Inject private SelfHygineMasterService selfHygineMasterService;
    
    @Inject
    public SelfHygineMasterService(SelfHygineMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }

	public List<SelfHygineMaster> getList(RequestParams<SelfHygineMasterVO> requestParams) {
		String company = requestParams.getString("company", "");
		String inspectionDate = requestParams.getString("inspectionDate", "");
		String mainCode = requestParams.getString("mainCode", "");
		String fromDate = requestParams.getString("fromDate",""); 
		String toDate = requestParams.getString("toDate","");
		BooleanBuilder builder = new BooleanBuilder();
		
		if(isNotEmpty(company)){	
			builder.and(qSelfHygineMaster.company.eq(company));
		}
		if(isNotEmpty(mainCode)){	
			builder.and(qSelfHygineMaster.mainCode.eq(mainCode));
		}
		if(isNotEmpty(inspectionDate)){	
			builder.and(qSelfHygineMaster.inspectionDate.eq(inspectionDate));
		}
		if(isNotEmpty(fromDate)&&isNotEmpty(toDate)){
			builder.and(qSelfHygineMaster.inspectionDate.between(fromDate,toDate));
		}
		
		return findAll(builder);
	}
    
	//전체삭제
    @Transactional
    public List<SelfHygineMasterVO> deleteAll(RequestParams<SelfHygineMasterVO> vo) {    	
    	return selfHygineMasterMapper.deleteAll(vo);
    }
	
//    public List<SelfHygineMasterVO> getMasterList(RequestParams<SelfHygineMasterVO> vo){
//    	return selfHygineMasterMapper.getMasterList(vo);
//    }
}
