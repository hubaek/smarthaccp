package com.ppm.mes.domain.haccp.prod.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.prod.master.HaccpProdMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpProdDetailService extends BaseService<HaccpProdDetail, HaccpProdDetail.HaccpProdDetailId>{
	private HaccpProdDetailRepository repository;
	
	@Inject HaccpProdDetailMapper detailMapper;
	@Inject
	public HaccpProdDetailService(HaccpProdDetailRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpProdDetailVO> getHaccpProdDetailList(RequestParams<HaccpProdDetailVO> requestParams) {
		return detailMapper.getHaccpProdDetailList(requestParams);
	}
	@Transactional
	public void saveHaccpProdDetailList(List<HaccpProdDetail> list) {
		save(list);
	}
	
	@Transactional
	public void deleteAll(List<HaccpProdMaster> list) {
		BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(HaccpProdMaster t : list){
	    		if (isNotEmpty(t.getInspectionDate())) { 
	    			builderMaster.and(qHaccpProdMaster.inspectionDate.eq(t.getInspectionDate()));
	    			builderDetail.and(qHaccpProdDetail.inspectionDate.eq(t.getInspectionDate()));
	            }
	    	}
	    	delete(qHaccpProdMaster).where(builderMaster).execute();
	    	delete(qHaccpProdDetail).where(builderDetail).execute();
	    }
	}
	
	public List<HaccpProdDetailVO> getHaccpDetailList(RequestParams<HaccpProdDetailVO> requestParams) {
		return detailMapper.getHaccpDetailList(requestParams);
	}
	
}
