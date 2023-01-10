package com.ppm.mes.domain.key.system;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class SystemKeyManagementService extends BaseService<SystemKeyManagement, SystemKeyManagement.SystemKeyManagementId> {
    private SystemKeyManagementRepository repository;

    @Inject
    public SystemKeyManagementService(SystemKeyManagementRepository repository) {
        super(repository);
        this.repository = repository;
    } 
  
    
    
    public String setCommonCode(String typeNm,String keyword,int digits){
		BooleanBuilder builder = new BooleanBuilder();
     	builder.and(qSystemKeyManagement.typeNm.eq(typeNm));  	 
     	
		Long nowSeq = select().select(qSystemKeyManagement.seq).distinct().from(qSystemKeyManagement).where(builder).fetchOne();    				
		Long setWorkSeq = new Long(1);
		 
		if(null!=nowSeq){
			setWorkSeq = nowSeq + 1;
			update(qSystemKeyManagement).set(qSystemKeyManagement.seq, setWorkSeq).where(builder).execute();
          
		}else{
			
			SystemKeyManagement key = new SystemKeyManagement();    	
			key.setTypeNm(typeNm);
			key.setSeq(setWorkSeq); 
			save(key);
		}
		
		return keyword+String.format("%0"+digits+"d", setWorkSeq);
	}
    
    
    public List<SystemKeyManagement> gets(RequestParams<SystemKeyManagement> requestParams) {
        return findAll();
    }
    
    public String getCommonCode(String typeNm,String keyword,int digits){
		BooleanBuilder builder = new BooleanBuilder();
     	builder.and(qSystemKeyManagement.typeNm.eq(typeNm));  	 
     	
		Long nowSeq = select().select(qSystemKeyManagement.seq).distinct().from(qSystemKeyManagement).where(builder).fetchOne();    				
		Long setWorkSeq = new Long(1);
		 
		if(null!=nowSeq){
			setWorkSeq = nowSeq + 1;
			update(qSystemKeyManagement).set(qSystemKeyManagement.seq, setWorkSeq).where(builder).execute();
          
		}else{
			
			SystemKeyManagement key = new SystemKeyManagement();    	
			key.setTypeNm(typeNm);
			key.setSeq(setWorkSeq); 
			save(key);
		}
		
		return keyword+String.format("%0"+digits+"d", setWorkSeq);
	}
}