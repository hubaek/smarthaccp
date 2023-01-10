package com.ppm.mes.domain.key.work;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class WorkKeyManagementService extends BaseService<WorkKeyManagement, WorkKeyManagement.WorkKeyManagementId> {
   
	private WorkKeyManagementRepository repository;

    @Inject
    public WorkKeyManagementService(WorkKeyManagementRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Long setWorkSeqKey(String codeType){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        String codeDt = sdf.format(cal.getTime());
        
		BooleanBuilder builder = new BooleanBuilder();
     	builder.and(qWorkKeyManagement.codeType.eq(codeType));
     	builder.and(qWorkKeyManagement.codeDt.eq(codeDt));    	 
     	
     	Long nowWorkSeq = select().select(qWorkKeyManagement.seq).distinct().from(qWorkKeyManagement).where(builder).fetchOne();    				
     	Long setWorkSeq = new Long(1);
		
		if(null!=nowWorkSeq){
			setWorkSeq = nowWorkSeq + 1;
         update(qWorkKeyManagement).set(qWorkKeyManagement.seq, setWorkSeq).where(builder).execute();
         
		}else{
			
			WorkKeyManagement key = new WorkKeyManagement();    					
			key.setCodeType(codeType);
			key.setCodeDt(codeDt);   	
			key.setSeq(setWorkSeq); 
			save(key);
		}
			
		return setWorkSeq;
	}
    

    public String getYymmCode(String codeType,String keyName, int digit){

		SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
        Calendar cal = Calendar.getInstance();
        String codeDt = sdf.format(cal.getTime());
        
        
		BooleanBuilder builder = new BooleanBuilder();
     	builder.and(qWorkKeyManagement.codeType.eq(codeType));
     	builder.and(qWorkKeyManagement.codeDt.eq(codeDt));    	 
     	
		Long nowWorkSeq = select().select(qWorkKeyManagement.seq).distinct().from(qWorkKeyManagement).where(builder).fetchOne();    				
		Long setWorkSeq = new Long(1);
		
		if(null!=nowWorkSeq){
			setWorkSeq = nowWorkSeq + 1;
         update(qWorkKeyManagement).set(qWorkKeyManagement.seq, setWorkSeq).where(builder).execute();
         
		}else{
			
			WorkKeyManagement key = new WorkKeyManagement();    					
			key.setCodeType(codeType);
			key.setCodeDt(codeDt);   
	
			key.setSeq(setWorkSeq); 
			save(key);
		}
		
		
		return keyName + codeDt + String.format("%0"+digit+"d", setWorkSeq);
	}
    

    @Transactional
    public String getTranYymmCode(String codeType,String keyName, int digit){

		SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
        Calendar cal = Calendar.getInstance();
        String codeDt = sdf.format(cal.getTime());
        
        
		BooleanBuilder builder = new BooleanBuilder();
     	builder.and(qWorkKeyManagement.codeType.eq(codeType));
     	builder.and(qWorkKeyManagement.codeDt.eq(codeDt));    	 
     	
		Long nowWorkSeq = select().select(qWorkKeyManagement.seq).distinct().from(qWorkKeyManagement).where(builder).fetchOne();    				
		Long setWorkSeq = new Long(1);
		
		if(null!=nowWorkSeq){
			setWorkSeq = nowWorkSeq + 1;
         update(qWorkKeyManagement).set(qWorkKeyManagement.seq, setWorkSeq).where(builder).execute();
         
		}else{
			
			WorkKeyManagement key = new WorkKeyManagement();    					
			key.setCodeType(codeType);
			key.setCodeDt(codeDt);   
	
			key.setSeq(setWorkSeq); 
			save(key);
		}
		
		
		return keyName + codeDt + String.format("%0"+digit+"d", setWorkSeq);
	}
    
    
    public List<WorkKeyManagement> gets(RequestParams<WorkKeyManagement> requestParams) {
        return findAll();
    }
}