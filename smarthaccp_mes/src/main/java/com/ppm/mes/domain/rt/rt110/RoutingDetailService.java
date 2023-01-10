package com.ppm.mes.domain.rt.rt110;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;
 
@Service
public class RoutingDetailService extends BaseService <RoutingDetail,RoutingDetail.RoutingDetailId>{
	private RoutingDetailRepository repository;
    @Inject
    public RoutingDetailService(RoutingDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<RoutingDetail> getRoutingDetailList(RequestParams<RoutingDetail> requestParams) {   
		String routingCd = requestParams.getString("routingCd", "");
		String useYn = requestParams.getString("useYn", "");
		
    	BooleanBuilder builder = new BooleanBuilder();

    	if (isNotEmpty(routingCd)) {
           	builder.and(qRoutingDetail.routingCd.eq(routingCd));
        }
 

    	if (isNotEmpty(useYn)) {
           	builder.and(qRoutingDetail.useYn.eq(useYn));
        }
    	
        return select().from(qRoutingDetail).where(builder).fetch();
    }
    
    //라우팅 저장
    @Transactional
    public void saveRoutingDetail(List<RoutingDetail> list) {
    	
    	if (isNotEmpty(list)) {  
    		for (RoutingDetail item : list) {
        		if(null==item.getRegSeq()){
        			Long regSeq = select().select(qRoutingDetail.regSeq.max()).distinct()
        					.from(qRoutingDetail)
        					.where(qRoutingDetail.routingCd.eq(item.getRoutingCd())).fetchOne();
        					
        			if(null==regSeq){
        				regSeq = new Long(1);  
        			}else{
        				regSeq = regSeq + new Long(1);
        			}
        			item.setRegSeq(regSeq);
        		}
            	save(item);
            }
    	}
    }    
}