package com.ppm.mes.domain.haccp.code.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.code.master.HaccpProcessMaster;
import com.querydsl.core.BooleanBuilder;


@Service
public class HaccpProcessDetailService extends BaseService <HaccpProcessDetail,HaccpProcessDetail.HaccpProcessDetailId> {
	
	private HaccpProcessDetailRepository repository;

    @Inject private HaccpProcessDetailMapper haccpProcessDetailMapper;
    
    @Inject
    public HaccpProcessDetailService(HaccpProcessDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }
	
    @Transactional
    public void saveHaccpProcessDetail(List<HaccpProcessDetail> itemInfos) {   
 		save(itemInfos);  
    }
    
    

    
    //상세코드 조회
    public List<HaccpProcessDetailVO> getHaccpProcessDetailList(RequestParams<HaccpProcessDetailVO> vo) {  
    	return haccpProcessDetailMapper.getHaccpProcessDetailList(vo);
    }
    //공통코드 화면 조회
    public List<HaccpProcessCodeDetailVO> getHaccpProcessCodeDetailList(RequestParams<HaccpProcessCodeDetailVO> vo){
    		return haccpProcessDetailMapper.getHaccpProcessCodeDetailList(vo);
	}
    
  //전체삭제
    @Transactional
    public void deleteAll(List<HaccpProcessMaster> list) {    	
    	BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(HaccpProcessMaster t : list){
	    		if (isNotEmpty(t.getMainCode())) { 
	    			builderMaster.and(qHaccpProcessMaster.mainCode.eq(t.getMainCode()));
	    			builderDetail.and(qHaccpProcessDetail.mainCode.eq(t.getMainCode()));
	            }
	    		if (isNotEmpty(t.getInspectionDate())) { 
	    			builderMaster.and(qHaccpProcessMaster.inspectionDate.eq(t.getInspectionDate()));
	    			builderDetail.and(qHaccpProcessDetail.inspectionDate.eq(t.getInspectionDate()));
	            }
	    	}
	    	delete(qHaccpProcessMaster).where(builderMaster).execute();
	    	delete(qHaccpProcessDetail).where(builderDetail).execute();
	    }
    }

	


}
