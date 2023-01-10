package com.ppm.mes.domain.pc.pc310;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.pc.pc300.Purchase;
import com.ppm.mes.domain.st.st000.StockMasterService;
import com.querydsl.core.BooleanBuilder;

@Service
public class PurchaseDetailService extends BaseService<PurchaseDetail, PurchaseDetail.PurchaseDetailId> {
    private PurchaseDetailRepository repository;

    @Inject private StockMasterService stockMasterService;
    
    @Inject
    public PurchaseDetailService(PurchaseDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    @Transactional
    public void saveItemDetail(List<PurchaseDetail> list, Purchase m) {    
    	
    	for (PurchaseDetail c : list) {

    		Long slipSeq = new Long(1);
    		if(null == c.getSlipSeq()){
    			slipSeq = select().select(qPurchaseDetail.slipSeq.max()).distinct()
				.from(qPurchaseDetail).where(qPurchaseDetail.slipCd.eq(m.getSlipCd())).fetchOne();
    			
    			if(null==slipSeq){
    				slipSeq = new Long(1);
    			}else{
    				slipSeq = slipSeq + new Long(1);
    			}    			
    			c.setSlipSeq(slipSeq);
    		}
    		
    		
    		//입고
    		BigDecimal barcodeQty = c.getBarcodeQty();		//롯트 수량
	    	BigDecimal itemInQty = c.getItemQty();	//입고 수량
	    	BigDecimal itemQty = c.getItemQty();	//입고 수량 * 매입단위 환산량
	    	
	    	//롯트수량이 입고수량과 같거나 크다면 그냥 입고
	    	if(barcodeQty.compareTo(new BigDecimal(0)) == 0 || barcodeQty.compareTo(c.getItemQty()) == 0 || barcodeQty.compareTo(c.getItemQty()) == 1){
	    		c = stockMasterService.purchaseItem(c,m.getCustCd(),m.getWhCd(),m.getSlipDt());      
	    	}else{   	    		
	    		while (true){    	    			
	    			//입고수량이 로트 수량과 같거나, 크다면
	    			if(itemQty.compareTo(barcodeQty) == 0 || itemQty.compareTo(barcodeQty) == 1){
	    				//로트 수량으로 입고
        	    		c.setItemQty(barcodeQty);
        	    		c = stockMasterService.purchaseItem(c,m.getCustCd(),m.getWhCd(),m.getSlipDt());     
        	    		
	    			}else{
	    				if(itemQty.compareTo(new BigDecimal(0)) != 0){
            	    		c.setItemQty(itemQty);
            	    		stockMasterService.purchaseItem(c,m.getCustCd(),m.getWhCd(),m.getSlipDt());        
	    				}	    	
        	    		break;    	    	
	    			}
    	    		itemQty = itemQty.subtract(barcodeQty);
	    		}    	    	
	    	}
	    	
	    	c.setItemQty(itemInQty);
    		save(c);
    	}
    }

    @Transactional
    public void deleteDetail(String slipCd) {        
    	BooleanBuilder builder = new BooleanBuilder();
    	if (isNotEmpty(slipCd)) { 
           	builder.and(qPurchaseDetail.slipCd.eq(slipCd));
        }
        delete(qPurchaseDetail).where(builder).execute();
    }
    

    //전체삭제
    @Transactional
    public void deleteAll(Purchase t) {    	
    	if(isNotEmpty(t.getSlipCd())){
           	delete(qPurchase).where(qPurchase.slipCd.eq(t.getSlipCd())).execute();
           	delete(qPurchaseDetail).where(qPurchaseDetail.slipCd.eq(t.getSlipCd())).execute();
    	}
    }
    
}