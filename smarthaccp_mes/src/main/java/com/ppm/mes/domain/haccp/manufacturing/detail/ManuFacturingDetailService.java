package com.ppm.mes.domain.haccp.manufacturing.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.manufacturing.code.ManuFacturingMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class ManuFacturingDetailService extends BaseService <ManuFacturingDetail, ManuFacturingDetail.ManuFacturingDetailId>{
	private ManuFacturingDetailRepository repository;
	
	@Inject private ManuFacturingDetailMapper manufacturingDetailMapper;
	@Inject
	public ManuFacturingDetailService(ManuFacturingDetailRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	//공통코드화면 조회용
	public List<ManuFacturingDetailVO> getHaccpDetailList(RequestParams<ManuFacturingDetailVO> vo) {  
    	return manufacturingDetailMapper.getHaccpDetailList(vo);
    }
	
    public List<ManuFacturingDetailVO> getManuFacturingDetailList(RequestParams<ManuFacturingDetailVO> vo) {  
    	return manufacturingDetailMapper.getManuFacturingDetailList(vo);
    }
    @Transactional
    public void saveManuFacturingDetailList(List<ManuFacturingDetail> itemInfos) {   
 		save(itemInfos);  
    }
    //선택되어진 마스터 항목과 마스터 항목에 종속된 디테일 항목 삭제
    @Transactional
    public void deleteAll(List<ManuFacturingMaster> list) {    	
    	BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(ManuFacturingMaster t : list){
	    		if (isNotEmpty(t.getMainCode())) { 
	    			builderMaster.and(qManuFacturingMaster.mainCode.eq(t.getMainCode()));
	    			builderDetail.and(qManuFacturingDetail.mainCode.eq(t.getMainCode()));
	            }
	    		if (isNotEmpty(t.getInspectionDate())) { 
	    			builderMaster.and(qManuFacturingMaster.inspectionDate.eq(t.getInspectionDate()));
	    			builderDetail.and(qManuFacturingDetail.inspectionDate.eq(t.getInspectionDate()));
	            }
	    	}
	    	delete(qManuFacturingMaster).where(builderMaster).execute();
	    	delete(qManuFacturingDetail).where(builderDetail).execute();
	    }
    }

}
