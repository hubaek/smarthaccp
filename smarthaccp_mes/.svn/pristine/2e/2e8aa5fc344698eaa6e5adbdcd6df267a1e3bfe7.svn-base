package com.ppm.mes.domain.pc.pc210;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.pc.pc200.PurchaseOrder;
import com.querydsl.core.BooleanBuilder;

@Service
public class PurchaseOrderDetailService extends BaseService<PurchaseOrderDetail, PurchaseOrderDetail.PurchaseOrderDetailId> {
    private PurchaseOrderDetailRepository repository;
    
    @Inject
    public PurchaseOrderDetailService(PurchaseOrderDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }


    @Transactional
    public void saveItemDetail(List<PurchaseOrderDetail> list) {    
    	
    	for (PurchaseOrderDetail c : list) {
    		Long slipSeq = new Long(1);
    		if(null == c.getSlipSeq()){
    			slipSeq = select().select(qPurchaseOrderDetail.slipSeq.max()).distinct()
				.from(qPurchaseOrderDetail).where(qPurchaseOrderDetail.slipCd.eq(c.getSlipCd())).fetchOne();
    			

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
           	builder.and(qPurchaseOrderDetail.slipCd.eq(slipCd));
        }
        delete(qPurchaseOrderDetail).where(builder).execute();
    }    

    //전체삭제
    @Transactional
    public void deleteAll(PurchaseOrder t) {    	
    	if(isNotEmpty(t.getSlipCd())){
           	delete(qPurchaseOrder).where(qPurchaseOrder.slipCd.eq(t.getSlipCd())).execute();
           	delete(qPurchaseOrderDetail).where(qPurchaseOrderDetail.slipCd.eq(t.getSlipCd())).execute();
    	}
    }
}