package com.ppm.mes.domain.haccp.heat.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.heat.master.HaccpHeatMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpHeatDetailService extends BaseService<HaccpHeatDetail, HaccpHeatDetail.HaccpHeatDetailId>{
	private HaccpHeatDetailRepository repository;
	
	@Inject HaccpHeatDetailMapper detailMapper;
	@Inject
	public HaccpHeatDetailService(HaccpHeatDetailRepository repository){
		super(repository);
		this.repository = repository;
	}
	public List<HaccpHeatDetailVO> getHaccpHeatDetailList(RequestParams<HaccpHeatDetailVO> requestParams) {
		return detailMapper.getHaccpHeatDetailList(requestParams);
	}
	@Transactional
	public void saveHaccpHeatDetailList(List<HaccpHeatDetail> list) {
		save(list);
	}
	
	@Transactional
	public void deleteAll(List<HaccpHeatMaster> list) {
		BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(HaccpHeatMaster t : list){
	    		if (isNotEmpty(t.getInspectionDate())) { 
	    			builderMaster.and(qHaccpHeatMaster.inspectionDate.eq(t.getInspectionDate()));
	    			builderDetail.and(qHaccpHeatDetail.inspectionDate.eq(t.getInspectionDate()));
	            }
	    		if (isNotEmpty(t.getHeatClean())) { 
	    			builderMaster.and(qHaccpHeatMaster.heatClean.eq(t.getHeatClean()));
	    			builderDetail.and(qHaccpHeatDetail.heatClean.eq(t.getHeatClean()));
	            }
	    	}
	    	delete(qHaccpHeatMaster).where(builderMaster).execute();
	    	delete(qHaccpHeatDetail).where(builderDetail).execute();
	    }
	}
	
	public List<HaccpHeatDetailVO> getHaccpDetailList(RequestParams<HaccpHeatDetailVO> requestParams) {
		return detailMapper.getHaccpDetailList(requestParams);
	}
	
	public List<HaccpHeatDetailVO> GetCharts(RequestParams<HaccpHeatDetailVO> requestParams) {
		return detailMapper.GetCharts(requestParams);
	}
}
