package com.ppm.mes.domain.sa.sa310;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.sa.sa300.Order;
import com.querydsl.core.BooleanBuilder;

@Service
public class OrderDetailService extends BaseService<OrderDetail, OrderDetail.OrderDetailId> {

	private OrderDetailRepository repository;
    
    @Inject
    public OrderDetailService(OrderDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }

    
    @Transactional
    public void saveItemDetail(List<OrderDetail> list) {    
    	
    	for (OrderDetail c : list) {
    		Long slipSeq = new Long(1);
    		if(null == c.getSlipSeq()){
    			slipSeq = select().select(qOrderDetail.slipSeq.max()).distinct()
				.from(qOrderDetail).where(qOrderDetail.slipCd.eq(c.getSlipCd())).fetchOne();
    			

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
           	builder.and(qOrderDetail.slipCd.eq(slipCd));
        }
        delete(qOrderDetail).where(builder).execute();
    }


    //전체삭제
    @Transactional
    public void deleteAll(Order t) {    	
    	if(isNotEmpty(t.getSlipCd())){
           	delete(qOrder).where(qOrder.slipCd.eq(t.getSlipCd())).execute();
           	delete(qOrderDetail).where(qOrderDetail.slipCd.eq(t.getSlipCd())).execute();
    	}
    }
}