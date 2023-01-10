package com.ppm.mes.domain.haccp.hgPrc.detail;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.hgPrc.master.HgPrcMaster;
import com.querydsl.core.BooleanBuilder;

@Service
public class HgPrcDetailService extends BaseService<HgPrcDetail, HgPrcDetail.HgPrcDetailId>{
	private HgPrcDetailRepository repository;
	
	@Inject private HgPrcDetailMapper hgPrcDetailMapper;
	@Inject
	public HgPrcDetailService(HgPrcDetailRepository repository){
		super(repository);
		this.repository = repository;
	}
	
	//공통코드화면 조회용
		public List<HgPrcDetailVO> getHaccpDetailList(RequestParams<HgPrcDetailVO> vo) {  
	    	return hgPrcDetailMapper.getHaccpDetailList(vo);
	    }
		
	    public List<HgPrcDetailVO> getHgPrcDetailList(RequestParams<HgPrcDetailVO> vo) {  
	    	return hgPrcDetailMapper.getHgPrcDetailList(vo);
	    }
	    @Transactional
	    public void saveHgPrcDetailList(List<HgPrcDetail> itemInfos) {   
	 		save(itemInfos);  
	    }
	    //선택되어진 마스터 항목과 마스터 항목에 종속된 디테일 항목 삭제
	    @Transactional
	    public void deleteAll(List<HgPrcMaster> list) {    	
	    	BooleanBuilder builderMaster = new BooleanBuilder();
	    	BooleanBuilder builderDetail = new BooleanBuilder();
	    	if(isNotEmpty(list)){
		    	for(HgPrcMaster t : list){
		    		if (isNotEmpty(t.getMainCode())) { 
		    			builderMaster.and(qHgPrcMaster.mainCode.eq(t.getMainCode()));
		    			builderDetail.and(qHgPrcDetail.mainCode.eq(t.getMainCode()));
		            }
		    		if (isNotEmpty(t.getInspectionDate())) { 
		    			builderMaster.and(qHgPrcMaster.inspectionDate.eq(t.getInspectionDate()));
		    			builderDetail.and(qHgPrcDetail.inspectionDate.eq(t.getInspectionDate()));
		            }
		    	}
		    	delete(qHgPrcMaster).where(builderMaster).execute();
		    	delete(qHgPrcDetail).where(builderDetail).execute();
		    }
	    }
}
