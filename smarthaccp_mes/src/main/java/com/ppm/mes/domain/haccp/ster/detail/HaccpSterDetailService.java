package com.ppm.mes.domain.haccp.ster.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.ster.master.HaccpSterMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpSterDetailService extends BaseService<HaccpSterDetail, HaccpSterDetail.HaccpSterDetailId>{
	private HaccpSterDetailRepository repository;
	
	@Inject HaccpSterDetailMapper detailMapper;
	
	@Inject
	public HaccpSterDetailService(HaccpSterDetailRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpSterDetailVO> getHaccpSterDetailList(RequestParams<HaccpSterDetailVO> requestParams) {
		return detailMapper.getHaccpSterDetailList(requestParams);
	}
	@Transactional
	public void saveHaccpSterDetailList(List<HaccpSterDetail> list) {
		save(list);
	}
	
	@Transactional
	public void deleteAll(List<HaccpSterMaster> list) {
		BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(HaccpSterMaster t : list){
	    		if (isNotEmpty(t.getInspectionDate())) { 
	    			builderMaster.and(qHaccpSterMaster.inspectionDate.eq(t.getInspectionDate()));
	    			builderDetail.and(qHaccpSterDetail.inspectionDate.eq(t.getInspectionDate()));
	            }
	    		if (isNotEmpty(t.getVersion())) { 
	    			builderMaster.and(qHaccpSterMaster.version.eq(t.getVersion()));
	    			builderDetail.and(qHaccpSterDetail.version.eq(t.getVersion()));
	            }
	    	}
	    	delete(qHaccpSterMaster).where(builderMaster).execute();
	    	delete(qHaccpSterDetail).where(builderDetail).execute();
	    }
	}
	
	public List<HaccpSterDetailVO> getHaccpDetailList(RequestParams<HaccpSterDetailVO> requestParams) {
		return detailMapper.getHaccpDetailList(requestParams);
	}
	
	public List<HaccpSterDetailVO> GetCharts1(RequestParams<HaccpSterDetailVO> requestParams) {
		return detailMapper.GetCharts1(requestParams);
	}
	public List<HaccpSterDetailVO> GetCharts2(RequestParams<HaccpSterDetailVO> requestParams) {
		return detailMapper.GetCharts2(requestParams);
	}
	public List<HaccpSterDetailVO> GetCharts3(RequestParams<HaccpSterDetailVO> requestParams) {
		return detailMapper.GetCharts3(requestParams);
	}
	
}
