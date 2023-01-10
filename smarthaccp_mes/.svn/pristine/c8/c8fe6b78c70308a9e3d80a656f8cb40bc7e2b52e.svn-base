package com.ppm.mes.domain.haccp.hgPrc.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class HgPrcMasterService extends BaseService <HgPrcMaster, HgPrcMaster.HgPrcMasterId>{
	private HgPrcMasterRepository repository;
	
	@Inject private HgPrcMasterMapper hgPrcMasterMapper;
	@Inject private HgPrcMasterService hgPrcMasterService;
	
	@Inject
	public HgPrcMasterService (HgPrcMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HgPrcMaster> getList(RequestParams<HgPrcMasterVO> requestParams) {
		String company = requestParams.getString("company", "");
		String inspectionDate = requestParams.getString("inspectionDate", "");
		String mainCode = requestParams.getString("mainCode", "");
		String fromDate = requestParams.getString("fromDate",""); 
		String toDate = requestParams.getString("toDate","");
		BooleanBuilder builder = new BooleanBuilder();
		
		if(isNotEmpty(company)){	
			builder.and(qHgPrcMaster.company.eq(company));
		}
		if(isNotEmpty(mainCode)){	
			builder.and(qHgPrcMaster.mainCode.eq(mainCode));
		}
		if(isNotEmpty(inspectionDate)){	
			builder.and(qHgPrcMaster.inspectionDate.eq(inspectionDate));
		}
		if(isNotEmpty(fromDate)&&isNotEmpty(toDate)){
			builder.and(qHgPrcMaster.inspectionDate.between(fromDate,toDate));
		}
		
		return findAll(builder);
	}
    
	//전체삭제
    @Transactional
    public List<HgPrcMasterVO> deleteAll(RequestParams<HgPrcMasterVO> vo) {    	
    	return hgPrcMasterMapper.deleteAll(vo);
    }
    
    public List<HgPrcMasterVO> getMasterList(RequestParams<HgPrcMasterVO> vo){
    	return hgPrcMasterMapper.getMasterList(vo);
    }
	

}
