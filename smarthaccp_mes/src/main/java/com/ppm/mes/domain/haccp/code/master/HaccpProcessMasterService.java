package com.ppm.mes.domain.haccp.code.master;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpProcessMasterService extends BaseService<HaccpProcessMaster, HaccpProcessMaster.HaccpProcessMasterId> {
	private HaccpProcessMasterRepository repository;
	
	@Inject private HaccpProcessMasterMapper haccpProcessMasterMapper;
	
	@Inject
	public HaccpProcessMasterService(HaccpProcessMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpProcessMasterVO> getList(RequestParams<HaccpProcessMasterVO> vo){
		System.out.println("haccp service!@#!@#!@#!@#");
		return haccpProcessMasterMapper.getList(vo);
	}
	//점검일자 중복 체크 
	public List<HaccpProcessMaster> getHaccpProessMasterInDate(RequestParams<HaccpProcessMaster> requestParams){
		 String inDateCheck = requestParams.getString("inspectionDate", "");
		 BooleanBuilder builder = new BooleanBuilder();
		 if (isNotEmpty(inDateCheck)) {  
            builder.and(qHaccpProcessMaster.inspectionDate.eq(inDateCheck));
        }
		 return findAll(builder);
	}
}
