package com.ppm.mes.domain.st.st500;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.st.st000.StockMasterService;

@Service
public class StockBoxService extends BaseService<StockBox, StockBox.StockBoxId> {
    private StockBoxRepository repository;

    @Inject private StockMasterService stockMasterService;
    @Inject private StockBoxMapper stockBoxMapper;
    @Inject
    public StockBoxService(StockBoxRepository repository) {
        super(repository);
        this.repository = repository;
    }  

    public List<StockBoxVO> getStockBoxList(RequestParams<StockBoxVO> vo){
    	return stockBoxMapper.getStockBoxList(vo);
    }
    
    @Transactional
    public void saveStockBox(List<StockBox> list){
    	if (isNotEmpty(list)){
        	for (StockBox c : list) {

        		if(c.getBoxYn().equals("N")){
            		//발행취소
        			if (c.isDeleted()) {
        				stockMasterService.barcodeCancelDivision(c);    	    
                	}else{
        				c = stockMasterService.barcodeDivision(c);    
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
        		
        		c.setRefBarcode(c.getRefBarcode());
    	    	save(c);
        	}
    	}
    }
}