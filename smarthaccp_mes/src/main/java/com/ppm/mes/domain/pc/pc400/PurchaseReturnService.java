package com.ppm.mes.domain.pc.pc400;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.domain.pc.pc410.PurchaseReturnDetail;
import com.ppm.mes.domain.pc.pc410.PurchaseReturnDetailService;

@Service
public class PurchaseReturnService extends BaseService<PurchaseReturn, PurchaseReturn.PurchaseReturnId> {
    private PurchaseReturnRepository repository;

    @Inject private PurchaseReturnMapper purchaseReturnMapper;    
    @Inject private PurchaseReturnDetailService purchaseReturnDetailService;    
    @Inject private WorkKeyManagementService workKeyManagementService;  

    
    
    @Inject
    public PurchaseReturnService(PurchaseReturnRepository repository) {
        super(repository);
        this.repository = repository;
    }

    
    @Transactional
    public PurchaseReturn savePurchaseReturn(PurchaseReturn m) {
    	
    	List<PurchaseReturnDetail> list = m.getItemDetail();
    	
    	if (null!=m) {  
    		String slipCd = "";
			if(isEmpty(m.getSlipCd())){
				slipCd = workKeyManagementService.getYymmCode("PC400" ,"PR", 3);   
				m.setSlipCd(slipCd);
			}

			if(isNotEmpty(list)){
		    	for (PurchaseReturnDetail c : list) {
		    		c.setCompany(m.getCompany());
		    		c.setSlipCd(m.getSlipCd());
		    	}
		    	purchaseReturnDetailService.saveItemDetail(list);
			}
			
			save(m);  
    	}
    	
    	return m;
    }

    public List<PurchaseReturnVO> header(RequestParams<PurchaseReturnVO> vo){    	
    	return purchaseReturnMapper.header(vo);
    }  
    
    public List<PurchaseReturnVO> itemDetail(RequestParams<PurchaseReturnVO> vo){
    	return purchaseReturnMapper.itemDetail(vo);
    }
}