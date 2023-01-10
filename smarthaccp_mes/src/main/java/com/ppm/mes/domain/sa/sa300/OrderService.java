package com.ppm.mes.domain.sa.sa300;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.domain.sa.sa310.OrderDetail;
import com.ppm.mes.domain.sa.sa310.OrderDetailService;

@Service
public class OrderService extends BaseService<Order, Order.OrderId> {
    private OrderRepository repository;

    @Inject private OrderMapper orderMapper;    
    @Inject private OrderDetailService orderDetailService;    
    @Inject private WorkKeyManagementService workKeyManagementService;      
    
    @Inject
    public OrderService(OrderRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    //저장
    @Transactional
    public Order saveForm(Order m) {
    	
    	List<OrderDetail> list = m.getItemDetail();
    	
    	if (null!=m) {  
    		String slipCd = "";

    		if(isEmpty(m.getSlipCd())){
				slipCd = workKeyManagementService.getYymmCode("SA300" ,"OD", 3); 
				m.setSlipCd(slipCd);
			}

			if(isNotEmpty(list)){
		    	for (OrderDetail c : list) {
		    		c.setCompany(m.getCompany());
		    		c.setSlipCd(m.getSlipCd());
		    	}
		    	orderDetailService.saveItemDetail(list);
			}

			save(m);  
    	}    	
    	return m;
    }
    
    
    public List<OrderVO> header(RequestParams<OrderVO> vo){
    	return orderMapper.header(vo);
    }

    public List<OrderVO> itemDetail(RequestParams<OrderVO> vo){
    	return orderMapper.itemDetail(vo);
    }   
    
	public List<OrderVO> excelDataDownLoad(RequestParams<OrderVO> vo) {
		return orderMapper.excelDataDownLoad(vo);
	} 
}