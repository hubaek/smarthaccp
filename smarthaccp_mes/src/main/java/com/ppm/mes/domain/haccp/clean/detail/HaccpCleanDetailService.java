package com.ppm.mes.domain.haccp.clean.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.clean.master.HaccpCleanMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpCleanDetailService extends BaseService<HaccpCleanDetail, HaccpCleanDetail.HaccpCleanDetailId>{
	private HaccpCleanDetailRepository repository;
	
	@Inject HaccpCleanDetailMapper detailMapper;
	@Inject
	public HaccpCleanDetailService(HaccpCleanDetailRepository repository){
		super(repository);
		this.repository = repository;
	}
	public List<HaccpCleanDetailVO> getHaccpCleanDetailList(RequestParams<HaccpCleanDetailVO> requestParams) {
		return detailMapper.getHaccpCleanDetailList(requestParams);
	}
	
	
	public List<HaccpCleanDetailVO> getHaccpDetailList(RequestParams<HaccpCleanDetailVO> requestParams) {
		return detailMapper.getHaccpDetailList(requestParams);
	}
	@Transactional
	public void saveHaccpCleanDetailList(List<HaccpCleanDetail> list) {
		save(list);
	}
	@Transactional
	public void deleteAll(List<HaccpCleanMaster> list) {
		BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(HaccpCleanMaster t : list){
	    		if (isNotEmpty(t.getInspectionDate())) { 
	    			builderMaster.and(qHaccpCleanMaster.inspectionDate.eq(t.getInspectionDate()));
	    			builderDetail.and(qHaccpCleanDetail.inspectionDate.eq(t.getInspectionDate()));
	            }
	    	}
	    	delete(qHaccpCleanMaster).where(builderMaster).execute();
	    	delete(qHaccpCleanDetail).where(builderDetail).execute();
	    }
	}
	public List<HaccpCleanDetailVO> GetCharts(RequestParams<HaccpCleanDetailVO> requestParams) {
		return detailMapper.GetCharts(requestParams);
	}
}
