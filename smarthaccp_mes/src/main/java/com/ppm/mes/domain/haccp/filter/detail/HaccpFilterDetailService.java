package com.ppm.mes.domain.haccp.filter.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.filter.master.HaccpFilterMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpFilterDetailService extends BaseService<HaccpFilterDetail, HaccpFilterDetail.HaccpFilterDetailId>{
	
	private HaccpFilterDetailRepository repository;
	
	@Inject HaccpFilterDetailMapper detailMapper;
	
	@Inject
	public HaccpFilterDetailService(HaccpFilterDetailRepository repository){
		super(repository);
		this.repository = repository;
	}
		
	
	@Transactional
	public void saveHaccpFilterDetailList(List<HaccpFilterDetail> list) {
		save(list);
		
	}
	
	@Transactional
	public void deleteAll(List<HaccpFilterMaster> list) {
		BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(HaccpFilterMaster t : list){
	    		if (isNotEmpty(t.getInspectionDate())) { 
	    			builderMaster.and(qHaccpFilterMaster.inspectionDate.eq(t.getInspectionDate()));
	    			builderDetail.and(qHaccpFilterDetail.inspectionDate.eq(t.getInspectionDate()));
	            }
	    	}
	    	delete(qHaccpFilterMaster).where(builderMaster).execute();
	    	delete(qHaccpFilterDetail).where(builderDetail).execute();
	    }
		
	}

	public List<HaccpFilterDetailVO> getFilterDetailList(RequestParams<HaccpFilterDetailVO> requestParams) {
		return detailMapper.getFilterDetailList(requestParams);
	}

}
