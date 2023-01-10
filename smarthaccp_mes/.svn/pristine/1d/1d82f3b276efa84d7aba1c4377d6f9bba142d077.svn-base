package com.ppm.mes.domain.st.st600;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.st.st000.StockMasterService;

@Service
public class StockBox2Service extends BaseService<StockBox2, StockBox2.StockBox2Id> {
    private StockBox2Repository repository;

    @Inject private StockMasterService stockMasterService;
    @Inject private StockBox2Mapper stockBox2Mapper;
    @Inject
    public StockBox2Service(StockBox2Repository repository) {
        super(repository);
        this.repository = repository;
    }  

    public List<StockBox2VO> getStockBox2List(RequestParams<StockBox2VO> vo){
    	return stockBox2Mapper.getStockBox2List(vo);
    }
    
    @Transactional
    public void saveStockBox2(List<StockBox2> list){
    	if (isNotEmpty(list)){
        	for (StockBox2 c : list) {

        		if(c.getBoxYn().equals("N")){
            		//발행취소
        			if (c.isDeleted()) {
        				stockMasterService.barcodeCancelDivision2(c);    	    
                	}else{
        				c = stockMasterService.barcodeDivision2(c);    
                	}
        		}

        		Long stockSeq = new Long(1);
        		
        		if(null == c.getStockSeq()){
        			stockSeq = select().select(qStockBox.stockSeq.max()).distinct()
    				.from(qStockBox).where(qStockBox.stockCd.eq(c.getStockCd())).fetchOne();
        			

        			if(null==stockSeq){
        				stockSeq = new Long(1);
        			}else{
        				stockSeq = stockSeq + new Long(1);
        			}    			
        			c.setStockSeq(stockSeq);
        		}
        		
        		
    	    	save(c);
        	}
    	}
    }
}