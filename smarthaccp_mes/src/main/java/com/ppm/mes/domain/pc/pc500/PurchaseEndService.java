package com.ppm.mes.domain.pc.pc500;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.domain.pc.pc510.PurchaseEndDetail;
import com.ppm.mes.domain.pc.pc510.PurchaseEndDetailService;

@Service
public class PurchaseEndService extends BaseService<PurchaseEnd, PurchaseEnd.PurchaseEndId> {
   
	private PurchaseEndRepository repository;

    @Inject private PurchaseEndMapper purchaseEndMapper;    
    @Inject private PurchaseEndDetailService purchaseEndDetailService;    
    @Inject private WorkKeyManagementService workKeyManagementService;  
    
    
    @Inject
    public PurchaseEndService(PurchaseEndRepository repository) {
        super(repository);
        this.repository = repository;
    }

    
    @Transactional
    public PurchaseEnd savePurchaseEnd(PurchaseEnd m) {
    	
    	List<PurchaseEndDetail> list = m.getItemDetail();
    	
    	if (null!=m) {  
    		String slipCd = "";
			if(isEmpty(m.getSlipCd())){
				slipCd = workKeyManagementService.getYymmCode("PC500" ,"PE", 3);
				m.setSlipCd(slipCd);
			}


			if(isNotEmpty(list)){
		    	for (PurchaseEndDetail c : list) {
		    		c.setCompany(m.getCompany());
		    		c.setSlipCd(m.getSlipCd());
		    	}
		    	purchaseEndDetailService.saveItemDetail(list);
			}
			
			save(m);  
    	}
    	
    	return m;
    }    
    

    public List<PurchaseEndVO> header(RequestParams<PurchaseEndVO> vo){
    	return purchaseEndMapper.header(vo);
    }  

    public List<PurchaseEndVO> itemDetail(RequestParams<PurchaseEndVO> vo){
    	return purchaseEndMapper.itemDetail(vo);
    }
    
}