package com.ppm.mes.domain.haccp.metal.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.metal.master.HaccpMetalMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpMetalDetailService extends BaseService<HaccpMetalDetail, HaccpMetalDetail.HaccpMetalDetailId>{
	
	private HaccpMetalDetailRepository repository;
	
	@Inject HaccpMetalDetailMapper detailMapper;
	
	@Inject
	public HaccpMetalDetailService(HaccpMetalDetailRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpMetalDetailVO> getHaccpMetalDetailList(RequestParams<HaccpMetalDetailVO> requestParams) {
		return detailMapper.getHaccpMetalDetailList(requestParams);
	}
	
	@Transactional
	public void saveHaccpMetalDetailList(List<HaccpMetalDetail> list) {
		save(list);
		
	}
	
	@Transactional
	public void deleteAll(List<HaccpMetalMaster> list) {
		BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(HaccpMetalMaster t : list){
	    		if (isNotEmpty(t.getInspectionDate())) { 
	    			builderMaster.and(qHaccpMetalMaster.inspectionDate.eq(t.getInspectionDate()));
	    			builderDetail.and(qHaccpMetalDetail.inspectionDate.eq(t.getInspectionDate()));
	            }
	    	}
	    	delete(qHaccpMetalMaster).where(builderMaster).execute();
	    	delete(qHaccpMetalDetail).where(builderDetail).execute();
	    }
		
	}

	public List<HaccpMetalDetailVO> getMetalDetailList(RequestParams<HaccpMetalDetailVO> requestParams) {
		return detailMapper.getMetalDetailList(requestParams);
	}

}
