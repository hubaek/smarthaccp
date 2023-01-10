package com.ppm.mes.domain.haccp.pack.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.pack.master.HaccpPackMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpPackDetailService extends BaseService<HaccpPackDetail, HaccpPackDetail.HaccpPackDetailId>{
	private HaccpPackDetailRepository repository;
	
	@Inject private HaccpPackDetailMapper detailMapper;
	
	@Inject
	public HaccpPackDetailService(HaccpPackDetailRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpPackDetailVO> getHaccpPackDetailList1(RequestParams<HaccpPackDetailVO> requestParams) {
		return detailMapper.getHaccpPackDetailList1(requestParams);
	}
	public List<HaccpPackDetailVO> getHaccpPackDetailList2(RequestParams<HaccpPackDetailVO> requestParams) {
		return detailMapper.getHaccpPackDetailList2(requestParams);
	}	
	public List<HaccpPackDetailVO> getHaccpPackDetailList3(RequestParams<HaccpPackDetailVO> requestParams) {
		return detailMapper.getHaccpPackDetailList3(requestParams);
	}
	@Transactional
	public void saveHaccpSterDetailList(List<HaccpPackDetail> list) {
		save(list);
	}
	
	@Transactional
	public void deleteAll(List<HaccpPackMaster> list) {
		BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(HaccpPackMaster t : list){
	    		if (isNotEmpty(t.getInspectionDate())) { 
	    			builderMaster.and(qHaccpPackMaster.inspectionDate.eq(t.getInspectionDate()));
	    			builderDetail.and(qHaccpPackDetail.inspectionDate.eq(t.getInspectionDate()));
	            }
	    		if (isNotEmpty(t.getVersion())) { 
	    			builderMaster.and(qHaccpPackMaster.version.eq(t.getVersion()));
	    			builderDetail.and(qHaccpPackDetail.version.eq(t.getVersion()));
	            }
	    	}
	    	delete(qHaccpPackMaster).where(builderMaster).execute();
	    	delete(qHaccpPackDetail).where(builderDetail).execute();
	    }
	}
	
	public List<HaccpPackDetailVO> getHaccpDetailList(RequestParams<HaccpPackDetailVO> requestParams) {
		return detailMapper.getHaccpDetailList(requestParams);
	}
	
	public List<HaccpPackDetailVO> GetCharts1(RequestParams<HaccpPackDetailVO> requestParams) {
		return detailMapper.GetCharts1(requestParams);
	}
	public List<HaccpPackDetailVO> GetCharts2(RequestParams<HaccpPackDetailVO> requestParams) {
		return detailMapper.GetCharts2(requestParams);
	}
	public List<HaccpPackDetailVO> GetCharts3(RequestParams<HaccpPackDetailVO> requestParams) {
		return detailMapper.GetCharts3(requestParams);
	}
}
