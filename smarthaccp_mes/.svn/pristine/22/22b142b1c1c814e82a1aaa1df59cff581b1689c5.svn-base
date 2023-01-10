package com.ppm.mes.domain.haccp.ther.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.ther.master.HaccpTherMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpTherDetailService extends BaseService<HaccpTherDetail, HaccpTherDetail.HaccpTherDetailId>{
	private HaccpTherDetailRepository repository;
	
	@Inject private HaccpTherDetailMapper detailMapper;
	@Inject
	public HaccpTherDetailService(HaccpTherDetailRepository repository){
		super(repository);
		this.repository = repository;
	}	
	
	public List<HaccpTherDetailVO> getHaccpTherDetailList(RequestParams<HaccpTherDetailVO> requestParams) {
		return detailMapper.getHaccpTherDetailList(requestParams);
	}
	@Transactional
	public void saveHaccpTherDetailList(List<HaccpTherDetail> list) {
		save(list);
	}
	
	@Transactional
	public void deleteAll(List<HaccpTherMaster> list) {
		BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(HaccpTherMaster t : list){
	    		if (isNotEmpty(t.getInspectionDate())) { 
	    			builderMaster.and(qHaccpTherMaster.inspectionDate.eq(t.getInspectionDate()));
	    			builderDetail.and(qHaccpTherDetail.inspectionDate.eq(t.getInspectionDate()));
	            }
	    	}
	    	delete(qHaccpTherMaster).where(builderMaster).execute();
	    	delete(qHaccpTherMaster).where(builderDetail).execute();
	    }
	}
	
	public List<HaccpTherDetailVO> getHaccpDetailList(RequestParams<HaccpTherDetailVO> requestParams) {
		return detailMapper.getHaccpDetailList(requestParams);
	}
	
	public List<HaccpTherDetailVO> GetCharts(RequestParams<HaccpTherDetailVO> requestParams) {
		return detailMapper.GetCharts(requestParams);
	}
}
