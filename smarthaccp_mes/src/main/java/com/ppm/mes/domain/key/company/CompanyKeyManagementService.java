package com.ppm.mes.domain.key.company;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.cp.cp000.CompanyManagement;
import com.ppm.mes.domain.cp.cp000.CompanyManagementService;
import com.querydsl.core.BooleanBuilder;

@Service
public class CompanyKeyManagementService extends BaseService<CompanyKeyManagement, CompanyKeyManagement.CompanyKeyManagementId> {
    private CompanyKeyManagementRepository repository;

    @Inject private CompanyManagementService companyManagementService;
    
    @Inject
    public CompanyKeyManagementService(CompanyKeyManagementRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    //법인코드+결과코드
    @Transactional
    public String getCommonCode(String company,String codeType,String code,int digit){
    	
		RequestParams<CompanyManagement> p = new RequestParams<>(CompanyManagement.class);
		p.put("company",company);
		CompanyManagement c = companyManagementService.get(p);
		
		String companyType = c.getCompanyType() == null ? "" : c.getCompanyType() ;
		
    	String resultCd = "";
		BooleanBuilder builder = new BooleanBuilder();
     	builder.and(qCompanyKeyManagement.codeType.eq(codeType));  	
     	builder.and(qCompanyKeyManagement.company.eq(company));     	
		Long nowSeq = select().select(qCompanyKeyManagement.seq).distinct().from(qCompanyKeyManagement).where(builder).fetchOne();    				
		Long setWorkSeq = new Long(1);
		 
		if(null!=nowSeq){
			setWorkSeq = nowSeq + 1;
			resultCd = companyType+code+String.format("%0"+digit+"d", setWorkSeq);
			update(qCompanyKeyManagement).set(qCompanyKeyManagement.seq, setWorkSeq).set(qCompanyKeyManagement.resultCd, resultCd).where(builder).execute();
		}else{
			resultCd = companyType+code+String.format("%0"+digit+"d", setWorkSeq);			
			CompanyKeyManagement key = new CompanyKeyManagement();   
			key.setCompany(company);
			key.setCodeType(codeType);
			key.setSeq(setWorkSeq);   
			key.setResultCd(resultCd);
			save(key);
		}
		return resultCd;
	}

    //법인코드+결과코드
    public String getCode(String company,String codeType,String code,int digit){
    	
    	String resultCd = "";
		BooleanBuilder builder = new BooleanBuilder();
     	builder.and(qCompanyKeyManagement.codeType.eq(codeType));  	
     	builder.and(qCompanyKeyManagement.company.eq(company));     	
		Long nowSeq = select().select(qCompanyKeyManagement.seq).distinct().from(qCompanyKeyManagement).where(builder).fetchOne();    				
		Long setWorkSeq = new Long(1);
		 
		if(null!=nowSeq){
			setWorkSeq = nowSeq + 1;
			resultCd = code+String.format("%0"+digit+"d", setWorkSeq);
			update(qCompanyKeyManagement).set(qCompanyKeyManagement.seq, setWorkSeq).set(qCompanyKeyManagement.resultCd, resultCd).where(builder).execute();
		}else{
			resultCd = code+String.format("%0"+digit+"d", setWorkSeq);			
			CompanyKeyManagement key = new CompanyKeyManagement();   
			key.setCompany(company);
			key.setCodeType(codeType);
			key.setSeq(setWorkSeq);   
			key.setResultCd(resultCd);
			save(key);
		}
		return resultCd;
	}

    //월별 코드
    public String getYymmCode(String company,String codeType,String code,int digit){

		SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
        Calendar cal = Calendar.getInstance();
        String codeDt = sdf.format(cal.getTime());
        
        codeType = codeType + "_"+ codeDt;

    	String resultCd = "";
    	
		BooleanBuilder builder = new BooleanBuilder();
		
     	builder.and(qCompanyKeyManagement.company.eq(company));     
     	builder.and(qCompanyKeyManagement.codeType.eq(codeType));  		
     	
		Long nowSeq = select()
							.select(qCompanyKeyManagement.seq).distinct().
							from(qCompanyKeyManagement)
							.where(builder).fetchOne();    		
		
		Long setWorkSeq = new Long(1);

		if(null!=nowSeq){
			setWorkSeq = nowSeq + 1;
			resultCd = code + codeDt + String.format("%0"+digit+"d", setWorkSeq);
			
			update(qCompanyKeyManagement)
			.set(qCompanyKeyManagement.seq, setWorkSeq)
			.set(qCompanyKeyManagement.resultCd, resultCd)
			.where(builder).execute();
         
		}else{
			resultCd = code + codeDt + String.format("%0"+digit+"d", setWorkSeq);			
			
			CompanyKeyManagement key = new CompanyKeyManagement();   
			key.setCompany(company);
			key.setCodeType(codeType);
			key.setSeq(setWorkSeq);   
			key.setResultCd(resultCd);
			
			save(key);
		}
		return resultCd;
	}
    
    public List<CompanyKeyManagement> gets(RequestParams<CompanyKeyManagement> requestParams) {
        return findAll();
    }
}