package com.ppm.mes.domain.qc.qc450;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.qc.qc400.QcResultBad;
import com.ppm.mes.domain.st.st000.StockMasterService;
import com.querydsl.core.BooleanBuilder;
 
@Service
public class QcResultBadDetailService extends BaseService<QcResultBadDetail, QcResultBadDetail.QcResultBadDetailId> {
    private QcResultBadDetailRepository repository;
    
    @Inject private StockMasterService stockMasterService;
    
    
    @Inject
    public QcResultBadDetailService(QcResultBadDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }
    

    public List<QcResultBadDetail> get(RequestParams requestParams) {
    	//품목
        String itemCd = requestParams.getString("itemCd", "");
        //발생일
        String fromDate = requestParams.getString("fromDate", "");
        String toDate = requestParams.getString("toDate", "");
        String stockCd = requestParams.getString("stockCd", "");
        Long badSeq = requestParams.getLong("badSeq", new Long(0));
        
        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(stockCd)) { 
            builder.and(qQcResultBadDetail.stockCd.eq(stockCd));
        }        
        
        if (badSeq!=0) { 
            builder.and(qQcResultBadDetail.badSeq.eq(badSeq));
        }
        
        if(isNotEmpty(fromDate) || isNotEmpty(toDate)){
            builder.and(qQcResultBadDetail.regDt.between(fromDate, toDate));
        }

        if (isNotEmpty(itemCd)) { 
            builder.and(qQcResultBadDetail.itemCd.eq(itemCd));
        }        
        List<QcResultBadDetail> list = select().from(qQcResultBadDetail).where(builder).fetch();
        return list;
    }

    @Transactional
    public void saveInspectionBadDetail(List<QcResultBadDetail> list, QcResultBad header) {    
    	deleteDetail(header.getSlipCd(),header.getBadSeq());
    	for (QcResultBadDetail c : list) {
    		c.setSlipCd(header.getSlipCd());
    		c.setBadSeq(header.getBadSeq());
    		c.setStockCd(header.getStockCd());
    		c.setItemCd(header.getItemCd());
    		//재처리 일경우
    		if(c.getBadItemPrc().equals("10")){ 
    			stockMasterService.insertBadItemPrc(c);
    		}
    	}    	
		save(list);		
    }

    @Transactional
    public void deleteDetail(String slipCd, Long badSeq) {        
    	BooleanBuilder builder = new BooleanBuilder();
    	if (isNotEmpty(slipCd)) { 
           	builder.and(qQcResultBadDetail.slipCd.eq(slipCd));
           	builder.and(qQcResultBadDetail.badSeq.eq(badSeq));
        }    	
        delete(qQcResultBadDetail).where(builder).execute();
    }
}


