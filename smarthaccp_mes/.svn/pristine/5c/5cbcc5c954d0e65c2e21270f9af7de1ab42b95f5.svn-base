package com.ppm.mes.domain.rt.rt500;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;
 
@Service
public class RoutNwrkService extends BaseService <RoutNwrk,RoutNwrk.RoutNwrkId>{
	
    private RoutNwrkRepository repository;
    
    @Inject
    public RoutNwrkService(RoutNwrkRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    public List<RoutNwrk> getList(RequestParams<RoutNwrk> requestParams) {   
		String routCd = requestParams.getString("routCd", "");
		String useYn = requestParams.getString("useYn", "");		
    	BooleanBuilder builder = new BooleanBuilder();

    	if (isNotEmpty(routCd)) {
           	builder.and(qRoutNwrk.routCd.eq(routCd));
        }

    	if (isNotEmpty(useYn)) {
           	builder.and(qRoutNwrk.useYn.eq(useYn));
        }    	
        return select().from(qRoutNwrk).where(builder).fetch();
    }
}