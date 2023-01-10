package com.ppm.mes.domain.st.st050;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.domain.st.st000.StockMaster;

@Service
public class StockDetailService extends BaseService<StockDetail, StockDetail.StockDetailId> {
    private StockDetailRepository repository;

    @Inject private WorkKeyManagementService workKeyManagementService;
    @Inject private StockDetailMapper stockDetailMapper;
    
    @Inject
    public StockDetailService(StockDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }  

    @Transactional
    public StockMaster inOutProcess(StockMaster m, String refStockCd, String inoutType, String inoutTypeDetail, BigDecimal itemQty, String inoutDt){
    	
    	if (isEmpty(inoutDt)){
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            inoutDt = sdf.format(cal.getTime());
    	}

    	StockDetail d = new StockDetail();
    	d.setCompany(m.getCompany());
    	d.setInoutDt(inoutDt);
    	d.setInoutSeq(workKeyManagementService.setWorkSeqKey("INOUT"));
    	d.setInoutType(inoutType);
    	d.setInoutTypeDetail(inoutTypeDetail);
    	d.setStockCd(m.getStockCd());
    	d.setRefStockCd(refStockCd);
    	d.setItemCd(m.getItemCd());    	
    	d.setItemQty(itemQty);
    	d.setBarcode(m.getBarcode());
    	
    	BigDecimal prevStockQty = m.getStockQty() == null ? new BigDecimal(0) : m.getStockQty();
    	BigDecimal stockQty = new BigDecimal(0);
    	
    	if (inoutType.equals("IN")){
        	stockQty = prevStockQty.add(itemQty);
    	}else if  (inoutType.equals("OUT")){
        	stockQty = prevStockQty.subtract(itemQty);
    	}else if  (inoutType.equals("USE")){
        	stockQty = prevStockQty.subtract(itemQty);
    	}
    	m.setStockQty(stockQty);
    	save(d);
    	return m;
    }
    @Transactional
    public void insertIncomingData(Map map){
    	stockDetailMapper.insertIncomingData(map);
    }
    @Transactional
    public Map testQuery(Map map){
    	return stockDetailMapper.testQuery(map); 
    }
    //바코드 분할시 
    
 // 20.09.09 kjm pop 화면 입출고
    @Transactional
    public StockMaster popInOutProcess(StockMaster m, String refStockCd, String inoutType, String inoutTypeDetail, BigDecimal itemQty, String inoutDt){
    	
    	BigDecimal num = new BigDecimal(0);
    	if (isEmpty(inoutDt)){
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            inoutDt = sdf.format(cal.getTime());
    	}

    	StockDetail d = new StockDetail();
    	d.setCompany("1000");
    	d.setInoutDt(inoutDt);
    	d.setInoutSeq(workKeyManagementService.setWorkSeqKey("INOUT"));
    	d.setInoutType(inoutType);
    	d.setInoutTypeDetail(inoutTypeDetail);
    	d.setStockCd(m.getStockCd());
    	d.setRefStockCd(refStockCd);
    	d.setItemCd(m.getItemCd());    	
    	d.setItemQty(itemQty);
    	
    	BigDecimal prevStockQty = m.getStockQty() == null ? new BigDecimal(0) : m.getStockQty();
    	BigDecimal stockQty = new BigDecimal(0);
    	
    	if (inoutType.equals("IN")){
    			stockQty = prevStockQty.add(itemQty);
    	}else if  (inoutType.equals("OUT")){
        	stockQty = prevStockQty.subtract(itemQty);
    	}else if  (inoutType.equals("USE")){
        	stockQty = prevStockQty.subtract(itemQty);
    	}
    	m.setStockQty(stockQty);
    	save(d);
    	return m;
    }

}