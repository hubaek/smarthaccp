package com.ppm.mes.domain.cp.cp000;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class CompanyManagementService extends BaseService<CompanyManagement, CompanyManagement.CompanyManagementId> {
    private CompanyManagementRepository repository;

    @Inject
    public CompanyManagementService(CompanyManagementRepository repository) {
        super(repository);
        this.repository = repository;
    }
    //단건

    public CompanyManagement get(RequestParams<CompanyManagement> requestParams) {

		String company = requestParams.getString("company", "");
		String useYn = requestParams.getString("useYn", "");

		BooleanBuilder builder = new BooleanBuilder();

		company = company.equals("*") ? "" : company;

		if (isNotEmpty(company)) {
			builder.and(qCompanyManagement.company.eq(company));
		}

		if (isNotEmpty(useYn)) {
			builder.and(qCompanyManagement.useYn.eq(useYn));
		}
		return findOne(builder);
    }
    
	public List<CompanyManagement> getCommonCompany(RequestParams<CompanyManagement> companyManagement) {

		String company = companyManagement.getString("company", "");

		BooleanBuilder builder = new BooleanBuilder();

		if (isNotEmpty(company)) {
			builder.and(qCompanyManagement.company.eq(company));
		}

		return findAll(builder);
	}
    
    //여러건
    public List<CompanyManagement> gets(RequestParams<CompanyManagement> requestParams) {

    	String company  = requestParams.getString("company");
   	 	String useYn = requestParams.getString("useYn", "");

        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(company)) {
         	builder.and(qCompanyManagement.company.eq(company));
        }
        if (isNotEmpty(useYn)) {
         	builder.and(qCompanyManagement.useYn.eq(useYn));
        }
        
        if (isNotEmpty(company)) {
        	builder.and(qCompanyManagement.company.eq(company).or(qCompanyManagement.companyNm.like("%"+company+"%")));
        }
        
        return select().from(qCompanyManagement).where(builder).orderBy(qCompanyManagement.sort.asc()).fetch();
    }

	// json
	public List<CompanyManagement> getAllByMap(RequestParams<CompanyManagement> requestParams) {

		String useYn = requestParams.getString("useYn", "");

		BooleanBuilder builder = new BooleanBuilder();

		return findAll(builder);
	}
    
    //회사 저장
    @Transactional
    public void saveCompanyInfo(CompanyManagement companyInfo) {
 		save(companyInfo);
    }
}