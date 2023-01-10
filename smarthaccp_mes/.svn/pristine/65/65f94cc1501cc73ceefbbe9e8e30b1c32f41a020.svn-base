package com.ppm.mes.domain.selfHygine.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.selfHygine.code.SelfHygineMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class SelfHygineDetailService extends BaseService <SelfHygineDetail, SelfHygineDetail.SelfHygineDetailId>{
	private SelfHygineDetailRepository repository;
	
	@Inject private SelfHygineDetailMapper selfHygineDetailMapper;
	@Inject
	public SelfHygineDetailService(SelfHygineDetailRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	//공통코드화면 조회용
	public List<SelfHygineDetailVO> getHaccpDetailList(RequestParams<SelfHygineDetailVO> vo) {  
    	return selfHygineDetailMapper.getHaccpDetailList(vo);
    }
	
    public List<SelfHygineDetailVO> getSelfHygineDetailList(RequestParams<SelfHygineDetailVO> vo) {  
    	return selfHygineDetailMapper.getSelfHygineDetailList(vo);
    }
    @Transactional
    public void saveSelfHygineDetailList(List<SelfHygineDetail> itemInfos) {   
 		save(itemInfos);  
    }
    //선택되어진 마스터 항목과 마스터 항목에 종속된 디테일 항목 삭제
    @Transactional
    public void deleteAll(List<SelfHygineMaster> list) {    	
    	BooleanBuilder builderMaster = new BooleanBuilder();
    	BooleanBuilder builderDetail = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(SelfHygineMaster t : list){
	    		if (isNotEmpty(t.getMainCode())) { 
	    			builderMaster.and(qSelfHygineMaster.mainCode.eq(t.getMainCode()));
	    			builderDetail.and(qSelfHygineDetail.mainCode.eq(t.getMainCode()));
	            }
	    		if (isNotEmpty(t.getInspectionDate())) { 
	    			builderMaster.and(qSelfHygineMaster.inspectionDate.eq(t.getInspectionDate()));
	    			builderDetail.and(qSelfHygineDetail.inspectionDate.eq(t.getInspectionDate()));
	            }
	    	}
	    	delete(qSelfHygineMaster).where(builderMaster).execute();
	    	delete(qSelfHygineDetail).where(builderDetail).execute();
	    }
    }

}
