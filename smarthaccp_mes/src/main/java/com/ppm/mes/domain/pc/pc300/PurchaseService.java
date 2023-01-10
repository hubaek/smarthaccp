package com.ppm.mes.domain.pc.pc300;

import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.domain.pc.pc310.PurchaseDetail;
import com.ppm.mes.domain.pc.pc310.PurchaseDetailService;

@Service
public class PurchaseService extends BaseService<Purchase, Purchase.PurchaseId> {
    private PurchaseRepository repository;

    @Inject private PurchaseMapper purchaseMapper;    
    @Inject private PurchaseDetailService purchaseDetailService;    
    @Inject private WorkKeyManagementService workKeyManagementService;  

    
    
    @Inject
    public PurchaseService(PurchaseRepository repository) {
        super(repository);
        this.repository = repository;
    }

    
    @Transactional
    public Purchase savePurchase(Purchase m) {
    	
    	List<PurchaseDetail> list = m.getItemDetail();
    	
    	if (null!=m) {  
    		
    		String slipCd = "";
			
			//신규
			if(isEmpty(m.getSlipCd())){
				slipCd = workKeyManagementService.getYymmCode("PC300" ,"PS", 3);
				m.setSlipCd(slipCd);
			}

			if(isNotEmpty(list)){
		    	for (PurchaseDetail c : list) {
		    		c.setCompany(m.getCompany());
		    		c.setSlipCd(m.getSlipCd());
		    	}
		    	purchaseDetailService.saveItemDetail(list,m);
			}
			
			save(m);  
    	}
    	
    	return m;
    }

    public List<PurchaseVO> header(RequestParams<PurchaseVO> vo){
    	return purchaseMapper.header(vo);
    }  

    public List<PurchaseVO> itemDetail(RequestParams<PurchaseVO> vo){
    	return purchaseMapper.itemDetail(vo);
    }
    /*
     * 낭만연구소
    public void printbarcode(Map<String, Object> paramMap) {
    	purchaseMapper.printbarcode(paramMap);
    }
    */
}