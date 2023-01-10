package com.ppm.mes.domain.haccp.temp.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

import com.ppm.mes.domain.haccp.temp.master.HaccpTempMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpTempDetailService extends BaseService<HaccpTempDetail, HaccpTempDetail.HaccpTempDetailId>{
	private HaccpTempDetailRepository repository;
	
	@Inject HaccpTempDetailMapper detailMapper;
	@Inject
	public HaccpTempDetailService(HaccpTempDetailRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpSensingDataVO> getHaccpSensingData(RequestParams<HaccpSensingDataVO> requestParams) {
		return detailMapper.getHaccpSensingData(requestParams);
	}
	public List<HaccpSensingDataVO> getHaccpReportData(RequestParams<HaccpSensingDataVO> requestParams) {
		return detailMapper.getHaccpReportData(requestParams);
	}

	public List<HaccpTempDetailVO> getHaccpTempDetailList1(RequestParams<HaccpTempDetailVO> requestParams) {
		return detailMapper.getHaccpTempDetailList1(requestParams);
	}
	public List<HaccpTempDetailVO> getHaccpTempDetailList2(RequestParams<HaccpTempDetailVO> requestParams) {
		return detailMapper.getHaccpTempDetailList2(requestParams);
	}
	@Transactional
	public void saveHaccpTempDetailList(List<HaccpTempDetail> list) {
		save(list);
	}
	
	@Transactional
	public void deleteAll(List<HaccpTempMaster> list) {
		BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(HaccpTempMaster t : list){
	    		if (isNotEmpty(t.getInspectionDate())) { 
	    			builderMaster.and(qHaccpTempMaster.inspectionDate.eq(t.getInspectionDate()));
	    			builderDetail.and(qHaccpTempDetail.inspectionDate.eq(t.getInspectionDate()));
	            }
	    		if (isNotEmpty(t.getVersion())) { 
	    			builderMaster.and(qHaccpTempMaster.version.eq(t.getVersion()));
	    			builderDetail.and(qHaccpTempDetail.version.eq(t.getVersion()));
	            }
	    		if (isNotEmpty(t.getPlcIp())) { 
	    			builderMaster.and(qHaccpTempMaster.plcIp.eq(t.getPlcIp()));
	    			builderDetail.and(qHaccpTempDetail.plcIp.eq(t.getPlcIp()));
	            }	    		
	    	}
	    	delete(qHaccpTempMaster).where(builderMaster).execute();
	    	delete(qHaccpTempDetail).where(builderDetail).execute();
	    }
	}
	
	public List<HaccpTempDetailVO> getHaccpDetailList(RequestParams<HaccpTempDetailVO> requestParams) {
		return detailMapper.getHaccpDetailList(requestParams);
	}
	
	public List<HaccpTempDetailVO> GetCharts1(RequestParams<HaccpTempDetailVO> requestParams) {
		return detailMapper.GetCharts1(requestParams);
	}
	public List<HaccpTempDetailVO> GetCharts2(RequestParams<HaccpTempDetailVO> requestParams) {
		return detailMapper.GetCharts2(requestParams);
	}
}


