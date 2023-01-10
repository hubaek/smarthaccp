package com.ppm.mes.domain.haccp.tank.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.tank.master.HaccpTankMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpTankDetailService extends BaseService<HaccpTankDetail, HaccpTankDetail.HaccpTankDetailId>{
	private HaccpTankDetailRepository repository;
	
	@Inject HaccpTankDetailMapper detailMapper;
	@Inject
	public HaccpTankDetailService(HaccpTankDetailRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpTankDetailVO> getHaccpTankDetailList(RequestParams<HaccpTankDetailVO> requestParams) {
		return detailMapper.getHaccpTankDetailList(requestParams);
	}
	@Transactional
	public void saveHaccpTankDetailList(List<HaccpTankDetail> list) {
		save(list);
	}
	
	@Transactional
	public void deleteAll(List<HaccpTankMaster> list) {
		BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(HaccpTankMaster t : list){
	    		if (isNotEmpty(t.getInspectionDate())) { 
	    			builderMaster.and(qHaccpTankMaster.inspectionDate.eq(t.getInspectionDate()));
	    			builderDetail.and(qHaccpTankDetail.inspectionDate.eq(t.getInspectionDate()));
	            }
	    		if (isNotEmpty(t.getPlcIp())) { 
	    			builderMaster.and(qHaccpTankMaster.plcIp.eq(t.getPlcIp()));
	    			builderDetail.and(qHaccpTankDetail.plcIp.eq(t.getPlcIp()));
	            }
	    	}
	    	delete(qHaccpTankMaster).where(builderMaster).execute();
	    	delete(qHaccpTankDetail).where(builderDetail).execute();
	    }
	}
	
	public List<HaccpTankDetailVO> getHaccpDetailList(RequestParams<HaccpTankDetailVO> requestParams) {
		return detailMapper.getHaccpDetailList(requestParams);
	}
	
	public List<HaccpTankDetailVO> GetCharts(RequestParams<HaccpTankDetailVO> requestParams) {
		return detailMapper.GetCharts(requestParams);
	}
}
