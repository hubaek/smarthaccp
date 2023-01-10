package com.ppm.mes.domain.haccp.lamp.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.querydsl.core.BooleanBuilder;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpLampMasterService extends BaseService <HaccpLampMaster,HaccpLampMaster.HaccpLampMasterId>{
	private HaccpLampMasterRepository repository;
	@Inject HaccpLampMasterMapper masterMapper;
	@Inject
	public HaccpLampMasterService(HaccpLampMasterRepository repository){
		super(repository);
		this.repository = repository;
	}
	public List<HaccpLampMaster> getList(RequestParams<HaccpLampMasterVO> requestParams) {
		return masterMapper.getList(requestParams);
	}
	@Transactional
	public void deleteAll(List<HaccpLampMaster> list) {
		BooleanBuilder builderMaster = new BooleanBuilder();
		BooleanBuilder builderInsect = new BooleanBuilder();
		
		if(isNotEmpty(list)){
			for(HaccpLampMaster t : list){
				if(isNotEmpty(t.getInspectionDate())){
					builderMaster.and(qHaccpLampMaster.inspectionDate.eq(t.getInspectionDate()));
					builderInsect.and(qHaccpLampInsect.inspectionDate.eq(t.getInspectionDate()));
				}
			}
			delete(qHaccpLampMaster).where(builderMaster).execute();
			delete(qHaccpLampInsect).where(builderInsect).execute();
		}
		
	}
}
