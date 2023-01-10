package com.ppm.mes.domain.cp.cp100;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;
 
@Service
public class TbCmmsCp100Service extends BaseService <TbCmmsCp100,TbCmmsCp100.TbCmmsCp100Id>{

    private TbCmmsCp100Repository repository;    
    
    @Inject
    public TbCmmsCp100Service(TbCmmsCp100Repository repository) {
        super(repository);
        this.repository = repository;
    }  

    public List<TbCmmsCp100> getCp100List(RequestParams<TbCmmsCp100> requestParams) {

    	String company  = requestParams.getString("company");
    	String deptCd  = requestParams.getString("deptCd");
    	String deptNm  = requestParams.getString("deptNm");
   	 	String useYn = requestParams.getString("useYn", "");

        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(company)) {
         	builder.and(qTbCmmsCp100.company.eq(company));
        }
        if (isNotEmpty(deptCd)) {
         	builder.and(qTbCmmsCp100.deptCd.eq(deptCd));
        }
        if (isNotEmpty(deptNm)) {
         	builder.and(qTbCmmsCp100.deptNm.like("%"+deptNm+"%"));
        }
        if (isNotEmpty(useYn)) {
         	builder.and(qTbCmmsCp100.useYn.eq(useYn));
        }


        List<TbCmmsCp100> list = 
        		select()
        		.from(qTbCmmsCp100)
        		.where(builder)
        		.orderBy(qTbCmmsCp100.sort.asc()).fetch();
        
        return list;
    }

}