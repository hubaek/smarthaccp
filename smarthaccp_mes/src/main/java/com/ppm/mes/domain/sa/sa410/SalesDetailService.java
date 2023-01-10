package com.ppm.mes.domain.sa.sa410;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.sa.sa400.Sales;
import com.querydsl.core.BooleanBuilder;

@Service
public class SalesDetailService extends BaseService<SalesDetail, SalesDetail.SalesDetailId> {
   
	private SalesDetailRepository repository;

    @Inject
    public SalesDetailService(SalesDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }  
    

    @Transactional
    public void saveItemDetail(List<SalesDetail> list) {    
    	
    	//deleteDetail(slipCd);		
    	
    	for (SalesDetail c : list) {
    		Long slipSeq = new Long(1);
    		if(null == c.getSlipSeq()){
    			slipSeq = select().select(qSalesDetail.slipSeq.max()).distinct()
				.from(qSalesDetail).where(qSalesDetail.slipCd.eq(c.getSlipCd())).fetchOne();
    			

    			if(null==slipSeq){
    				slipSeq = new Long(1);
    			}else{
    				slipSeq = slipSeq + new Long(1);
    			}    			
    			c.setSlipSeq(slipSeq);
    		}

    		save(c);
    	}
    }

    @Transactional
    public void deleteDetail(String slipCd) {        
    	BooleanBuilder builder = new BooleanBuilder();
    	if (isNotEmpty(slipCd)) { 
           	builder.and(qSalesDetail.slipCd.eq(slipCd));
        }
        delete(qSalesDetail).where(builder).execute();
    }

    //전체삭제
    @Transactional
    public void deleteAll(Sales t) {    	
    	if(isNotEmpty(t.getSlipCd())){
           	delete(qSales).where(qSales.slipCd.eq(t.getSlipCd())).execute();
           	delete(qSalesDetail).where(qSalesDetail.slipCd.eq(t.getSlipCd())).execute();
    	}
    }
    
}