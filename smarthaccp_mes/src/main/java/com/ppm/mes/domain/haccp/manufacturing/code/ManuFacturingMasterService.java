package com.ppm.mes.domain.haccp.manufacturing.code;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;


@Service
public class ManuFacturingMasterService extends BaseService <ManuFacturingMaster,ManuFacturingMaster.ManuFacturingMasterId> {
	private ManuFacturingMasterRepository repository;
	
	@Inject private ManuFacturingMasterMapper manufacturingMasterMapper;
    @Inject private ManuFacturingMasterService manufacturingMasterService;
    
    @Inject
    public ManuFacturingMasterService(ManuFacturingMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }

	public List<ManuFacturingMaster> getList(RequestParams<ManuFacturingMasterVO> requestParams) {
		String company = requestParams.getString("company", "");
		String inspectionDate = requestParams.getString("inspectionDate", "");
		String mainCode = requestParams.getString("mainCode", "");
		String fromDate = requestParams.getString("fromDate",""); 
		String toDate = requestParams.getString("toDate","");
		BooleanBuilder builder = new BooleanBuilder();
		
		if(isNotEmpty(company)){	
			builder.and(qManuFacturingMaster.company.eq(company));
		}
		if(isNotEmpty(mainCode)){	
			builder.and(qManuFacturingMaster.mainCode.eq(mainCode));
		}
		if(isNotEmpty(inspectionDate)){	
			builder.and(qManuFacturingMaster.inspectionDate.eq(inspectionDate));
		}
		if(isNotEmpty(fromDate)&&isNotEmpty(toDate)){
			builder.and(qManuFacturingMaster.inspectionDate.between(fromDate,toDate));
		}
		
		return findAll(builder);
	}
    
	//전체삭제
    @Transactional
    public List<ManuFacturingMasterVO> deleteAll(RequestParams<ManuFacturingMasterVO> vo) {    	
    	return manufacturingMasterMapper.deleteAll(vo);
    }
	
//    public List<SelfHygineMasterVO> getMasterList(RequestParams<SelfHygineMasterVO> vo){
//    	return selfHygineMasterMapper.getMasterList(vo);
//    }
}
