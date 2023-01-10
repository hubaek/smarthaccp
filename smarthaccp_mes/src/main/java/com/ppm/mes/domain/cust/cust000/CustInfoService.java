package com.ppm.mes.domain.cust.cust000;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.company.CompanyKeyManagementService;
import com.querydsl.core.BooleanBuilder;
 
@Service
public class CustInfoService extends BaseService<CustInfo, CustInfo.CustInfoId> {
  
	private CustInfoRepository repository;
    

    @Inject
    private CompanyKeyManagementService companyKeyManagementService;  
    
    @Inject
    public CustInfoService(CustInfoRepository repository) {
        super(repository);
        this.repository = repository;
    }    
    
    //조회
    public List<CustInfo> getCustInfoList(RequestParams<CustInfo> requestParams) {

         String company = requestParams.getString("company", "");
         String custType = requestParams.getString("custType", "");
         String custCd = requestParams.getString("custCd", "");
         String custNm = requestParams.getString("custNm", "");
         String useYn = requestParams.getString("useYn", "");
         String exceptCustType = requestParams.getString("exceptCustType", "");
         String custCdCheck = requestParams.getString("custCdCheck", "");

         BooleanBuilder builder = new BooleanBuilder();

         if (isNotEmpty(company)) { 
             builder.and(qCustInfo.company.eq(company));
         }
         
         if (isNotEmpty(custType)) {  
             builder.and(qCustInfo.custType.eq(custType));
         }
         
         if (isNotEmpty(exceptCustType)) {  
             builder.and(qCustInfo.custType.ne(exceptCustType));
         }
         
         if (isNotEmpty(custCd)) { 
             builder.and(qCustInfo.custCd.like("%"+custCd+"%"));
         }
         
         if (isNotEmpty(custNm)) { 
             builder.and(qCustInfo.custNm.like("%"+custNm+"%"));
         }
         
         if (isNotEmpty(useYn)) { 
             builder.and(qCustInfo.useYn.eq(useYn));
         }   
         
         if (isNotEmpty(custCdCheck)) {  
             builder.and(qCustInfo.custCd.eq(custCdCheck));
         }
         
         return findAll(builder);
    } 
    
    //저장
    @Transactional
    public void saveCustInfo(CustInfo m) {    	
    	if (null != m) {  
			if(isEmpty(m.getCustCd())){
				m.setCustCd(companyKeyManagementService.getCommonCode("CUST","C",m.getCompany(),5));
			}    			

			if(isNotEmpty(m.getTempFileCd())){
				update(qCommonFile)
		        .set(qCommonFile.targetId , m.getCustCd())
	        		.where(qCommonFile.targetId.eq(m.getTempFileCd())
		        			.and(qCommonFile.targetType.eq("CUST_CD"))
		        			.and(qCommonFile.tempYn.eq("Y"))).execute();		
			}
     		save(m);  
    	}
    } 
}