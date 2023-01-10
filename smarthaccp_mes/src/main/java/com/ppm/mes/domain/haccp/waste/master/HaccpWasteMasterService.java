package com.ppm.mes.domain.haccp.waste.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.haccp.waste.master.HaccpWasteMaster;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;



@Service
public class HaccpWasteMasterService extends BaseService <HaccpWasteMaster,HaccpWasteMaster.HaccpWasteMasterId> {
	private HaccpWasteMasterRepository repository;
	
	@Inject private HaccpWasteMasterMapper HaccpWasteMasterMapper;
        
    @Inject
    public HaccpWasteMasterService(HaccpWasteMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<HaccpWasteMasterVO> getMasterList(RequestParams<HaccpWasteMasterVO> vo){
    	return HaccpWasteMasterMapper.getMasterList(vo);
    }
	
    @Transactional
    public void saveHaccpWasteMaster(List<HaccpWasteMaster> list) {   
			
					save(list);

		}  
    
    
	//전체삭제
    @Transactional
    public void deleteHaccpWasteMaster(List<HaccpWasteMaster> list) {    	
		BooleanBuilder builderMaster = new BooleanBuilder();
    	if(isNotEmpty(list)){
	    	for(HaccpWasteMaster t : list){
	    		if (isNotEmpty(t.getSeq())) { 
	    			builderMaster.and(qHaccpWasteMaster.seq.eq(t.getSeq()));
	            }
	    	}
	    	delete(qHaccpWasteMaster).where(builderMaster).execute();
	    }
    }


	
}
