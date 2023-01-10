package com.ppm.mes.domain.haccp.all.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpAllMasterService extends BaseService<HaccpAllMaster, HaccpAllMaster.HaccpAllMasterId>{
	private HaccpAllMasterRepository repository;
	@Inject HaccpAllMasterMapper masterMapper;
	
	@Inject
	public HaccpAllMasterService(HaccpAllMasterRepository repository){
		super(repository);
		this.repository = repository;
	}

	public List<HaccpAllMaster> getList(RequestParams<HaccpAllMasterVO> requestParams) {
		return masterMapper.getList(requestParams);
	}
	
	@Transactional
	public void deleteAll(List<HaccpAllMaster> list) {
		BooleanBuilder builderMaster = new BooleanBuilder();
		BooleanBuilder builderWork = new BooleanBuilder();
		BooleanBuilder builderRaw = new BooleanBuilder();
		
		if(isNotEmpty(list)){
			for(HaccpAllMaster t : list){
				if(isNotEmpty(t.getInspectionDate())){
					builderMaster.and(qHaccpAllMaster.inspectionDate.eq(t.getInspectionDate()));
					builderWork.and(qHaccpAllWork.inspectionDate.eq(t.getInspectionDate()));
					builderRaw.and(qHaccpAllRaw.inspectionDate.eq(t.getInspectionDate()));
				}
			}
			delete(qHaccpAllMaster).where(builderMaster).execute();
			delete(qHaccpAllWork).where(builderWork).execute();
			delete(qHaccpAllRaw).where(builderRaw).execute();
		}
		
	}
}
