package com.ppm.mes.domain.rt.rt600;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;
 
@Service
public class RoutBadService extends BaseService <RoutBad,RoutBad.RoutBadId>{
	
    private RoutBadRepository repository;
    
    @Inject
    public RoutBadService(RoutBadRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<RoutBad> getList(RequestParams<RoutBad> requestParams) {   
		String routCd = requestParams.getString("routCd", "");
		String useYn = requestParams.getString("useYn", "");		
    	BooleanBuilder builder = new BooleanBuilder();

    	if (isNotEmpty(routCd)) {
           	builder.and(qRoutBad.routCd.eq(routCd));
        }

    	if (isNotEmpty(useYn)) {
           	builder.and(qRoutBad.useYn.eq(useYn));
        }
    	
        return select().from(qRoutBad).where(builder).fetch();
    }
}