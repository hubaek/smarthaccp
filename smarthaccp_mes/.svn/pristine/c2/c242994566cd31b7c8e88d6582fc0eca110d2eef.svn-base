package com.ppm.mes.domain.pc.pc510;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.pc.pc500.PurchaseEnd;
import com.querydsl.core.BooleanBuilder;

@Service
public class PurchaseEndDetailService extends BaseService<PurchaseEndDetail, PurchaseEndDetail.PurchaseEndItemDetailId> {
  
	private PurchaseEndDetailRepository repository;

    @Inject
    public PurchaseEndDetailService(PurchaseEndDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Transactional
    public void saveItemDetail(List<PurchaseEndDetail> list) {    
    	
    	for (PurchaseEndDetail c : list) {
    		Long slipSeq = new Long(1);
    		if(null == c.getSlipSeq()){
    			slipSeq = select().select(qPurchaseEndDetail.slipSeq.max()).distinct()
				.from(qPurchaseEndDetail).where(qPurchaseEndDetail.slipCd.eq(c.getSlipCd())).fetchOne();
    			

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
           	builder.and(qPurchaseEndDetail.slipCd.eq(slipCd));
        }
        delete(qPurchaseEndDetail).where(builder).execute();
    }
    

    //전체삭제
    @Transactional
    public void deleteAll(PurchaseEnd t) {    	
    	if(isNotEmpty(t.getSlipCd())){
           	delete(qPurchaseEnd).where(qPurchaseEnd.slipCd.eq(t.getSlipCd())).execute();
           	delete(qPurchaseEndDetail).where(qPurchaseEndDetail.slipCd.eq(t.getSlipCd())).execute();
    	}
    }
}