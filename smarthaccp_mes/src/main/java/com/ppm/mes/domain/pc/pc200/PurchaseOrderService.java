package com.ppm.mes.domain.pc.pc200;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.domain.pc.pc210.PurchaseOrderDetail;
import com.ppm.mes.domain.pc.pc210.PurchaseOrderDetailService;

@Service
public class PurchaseOrderService extends BaseService<PurchaseOrder, PurchaseOrder.PurchaseOrderId> {
    private PurchaseOrderRepository repository;

    @Inject private PurchaseOrderMapper purchaseOrderMapper;    
    @Inject private PurchaseOrderDetailService purchaseOrderDetailService;    
    @Inject private WorkKeyManagementService workKeyManagementService;  
    
    @Inject
    public PurchaseOrderService(PurchaseOrderRepository repository) {
        super(repository);
        this.repository = repository;
    }

    
    @Transactional
    public PurchaseOrder saveOrderRequest(PurchaseOrder m) {    	
    	List<PurchaseOrderDetail> list = m.getItemDetail();    
    	
    	if (null != m) {  
    		
    		String slipCd = "";
			if(isEmpty(m.getSlipCd())){
				slipCd = workKeyManagementService.getYymmCode("PC200" ,"PO", 3);      
				m.setSlipCd(slipCd);
			}
			
			if(isNotEmpty(list)){
		    	for (PurchaseOrderDetail c : list) {
		    		c.setCompany(m.getCompany());
		    		c.setSlipCd(m.getSlipCd());
		    	}
		    	purchaseOrderDetailService.saveItemDetail(list);
			}
			
			save(m);  
    	}    	
    	return m;
    }   
    
    public List<PurchaseOrderVO> header(RequestParams<PurchaseOrderVO> vo){
    	return purchaseOrderMapper.header(vo);
    }  

    public List<PurchaseOrderVO> itemDetail(RequestParams<PurchaseOrderVO> vo){
    	return purchaseOrderMapper.itemDetail(vo);
    }
}