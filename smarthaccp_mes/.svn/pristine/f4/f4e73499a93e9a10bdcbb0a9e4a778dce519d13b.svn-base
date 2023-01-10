package com.ppm.mes.domain.rt.rt700;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;
 
@Service
public class RoutQcGbnService extends BaseService <RoutQcGbn,RoutQcGbn.RoutQcGbnId>{
	
    private RoutQcGbnRepository repository;
    
    @Inject
    public RoutQcGbnService(RoutQcGbnRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<RoutQcGbn> getRoutQcGbnList(RequestParams<RoutQcGbn> requestParams) {   
    	
		String routCd = requestParams.getString("routCd", "");
		String useYn = requestParams.getString("useYn", "");		
    	BooleanBuilder builder = new BooleanBuilder();

    	if (isNotEmpty(routCd)) {
           	builder.and(qRoutQcGbn.routCd.eq(routCd));
        }

    	if (isNotEmpty(useYn)) {
           	builder.and(qRoutQcGbn.useYn.eq(useYn));
        }
    	
        return select().from(qRoutQcGbn).where(builder).orderBy(qRoutQcGbn.sort.asc()).fetch();
    }
}