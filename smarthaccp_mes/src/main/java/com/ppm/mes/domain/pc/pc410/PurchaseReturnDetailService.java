package com.ppm.mes.domain.pc.pc410;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.pc.pc400.PurchaseReturn;
import com.ppm.mes.domain.st.st000.StockMasterService;
import com.querydsl.core.BooleanBuilder;

@Service
public class PurchaseReturnDetailService extends BaseService<PurchaseReturnDetail, PurchaseReturnDetail.PurchaseReturnDetailId> {
    private PurchaseReturnDetailRepository repository;

    @Inject private StockMasterService stockMasterService;
    
    @Inject
    public PurchaseReturnDetailService(PurchaseReturnDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }



    @Transactional
    public void saveItemDetail(List<PurchaseReturnDetail> list) {    

    	for (PurchaseReturnDetail c : list) {

    		Long slipSeq = new Long(1);
    		if(null == c.getSlipSeq()){
    			slipSeq = select().select(qPurchaseReturnDetail.slipSeq.max()).distinct()
				.from(qPurchaseReturnDetail).where(qPurchaseReturnDetail.slipCd.eq(c.getSlipCd())).fetchOne();
    			

    			if(null==slipSeq){
    				slipSeq = new Long(1);
    			}else{
    				slipSeq = slipSeq + new Long(1);
    			}    			
    			c.setSlipSeq(slipSeq);
    		}

    		stockMasterService.purchaseReturnItem(c);
    		save(c);
    	}
    }

    @Transactional
    public void deleteDetail(String slipCd) {        
    	BooleanBuilder builder = new BooleanBuilder();
    	if (isNotEmpty(slipCd)) { 
           	builder.and(qPurchaseReturnDetail.slipCd.eq(slipCd));
        }
        delete(qPurchaseReturnDetail).where(builder).execute();
    }
    

    //전체삭제
    @Transactional
    public void deleteAll(PurchaseReturn t) {    	
    	if(isNotEmpty(t.getSlipCd())){
           	delete(qPurchaseReturn).where(qPurchaseReturn.slipCd.eq(t.getSlipCd())).execute();
           	delete(qPurchaseReturnDetail).where(qPurchaseReturnDetail.slipCd.eq(t.getSlipCd())).execute();
    	}
    }
    
}