package com.ppm.mes.domain.sa.sa320;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class OrderTempService extends BaseService<OrderTemp, OrderTemp.OrderTempId> {

	private OrderTempRepository repository;
    
    @Inject
    public OrderTempService(OrderTempRepository repository) {
        super(repository);
        this.repository = repository;
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
    public void deleteAll(OrderTemp t) {    	
    	delete(qOrderTemp).execute();
    }
}