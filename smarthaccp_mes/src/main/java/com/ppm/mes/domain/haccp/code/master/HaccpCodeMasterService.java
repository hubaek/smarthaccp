package com.ppm.mes.domain.haccp.code.master;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.querydsl.core.BooleanBuilder;
import com.ppm.mes.domain.BaseService;
 
@Service
public class HaccpCodeMasterService extends BaseService <HaccpCodeMaster,HaccpCodeMaster.HaccpCodeMasterId>{

    private HaccpCodeMasterRepository repository;
    
    @Inject
    public HaccpCodeMasterService(HaccpCodeMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }
 
    public List<HaccpCodeMaster> getList(RequestParams requestParams) {  
        
        String company = requestParams.getString("company", "");        
        String templateInfo = requestParams.getString("templateInfo", "");
        String useYn = requestParams.getString("useYn", "");
        
        
        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(company)) {
            builder.and(qHaccpCodeMaster.company.eq(company));
        }
        if (isNotEmpty(templateInfo)) {
            builder.and(qHaccpCodeMaster.templateId.like("%" + templateInfo +"%").or(qHaccpCodeMaster.templateNm.like("%" + templateInfo +"%")));
        }

        if (isNotEmpty(useYn)) {
            builder.and(qHaccpCodeMaster.useYn.eq(useYn));
        }
        
        return findAll(builder);
    }
  
    
    public Page<HaccpCodeMaster> getCustList(RequestParams requestParams ,Pageable pageable) {
        String templateInfo = requestParams.getString("templateInfo", "");
        String useYn = requestParams.getString("useYn", "");

        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(templateInfo)) {
            builder.and(qHaccpCodeMaster.templateId.like("%" + templateInfo +"%").or(qHaccpCodeMaster.templateNm.like("%" + templateInfo +"%")));
        }

        if (isNotEmpty(useYn)) {
            builder.and(qHaccpCodeMaster.useYn.eq(useYn));
        }
        
        return findAll(builder, pageable);
    }
}