package com.ppm.mes.domain.haccp.car.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.car.master.HaccpCarMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpCarDetailService extends BaseService<HaccpCarDetail, HaccpCarDetail.HaccpCarDetailId>{
	private HaccpCarDetailRepository repository;
	
	@Inject private HaccpCarDetailMapper haccpCarDetailMapper;
	@Inject
	public HaccpCarDetailService(HaccpCarDetailRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	public List<HaccpCarDetailVO> getHaccpCarDetailList(RequestParams<HaccpCarDetailVO> vo){
		return haccpCarDetailMapper.getHaccpCarDetailList(vo);
	}
	@Transactional
	public void saveCarDetail(List<HaccpCarDetail> itemInfos){
		save(itemInfos);
	}
	@Transactional
	public void deleteAll(List<HaccpCarMaster> list){
		BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(HaccpCarMaster t : list){
	    		if (isNotEmpty(t.getInspectionYm())) { 
	    			builderMaster.and(qHaccpCarMaster.inspectionYm.eq(t.getInspectionYm()));
	    			builderDetail.and(qHaccpCarDetail.inspectionYm.eq(t.getInspectionYm()));
	            }
	    	}
	    	delete(qHaccpCarMaster).where(builderMaster).execute();
	    	delete(qHaccpCarDetail).where(builderDetail).execute();
	    }
	}
	
	public void deleteDetail(HaccpCarDetail list) {
		haccpCarDetailMapper.deleteDetail(list);
		
	}
}
