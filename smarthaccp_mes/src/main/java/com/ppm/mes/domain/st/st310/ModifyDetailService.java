package com.ppm.mes.domain.st.st310;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.st.st000.StockMasterService;
import com.ppm.mes.domain.st.st300.Modify;

@Service
public class ModifyDetailService extends BaseService<ModifyDetail, ModifyDetail.ModifyDetailId> {
    private ModifyDetailRepository repository;

    @Inject private StockMasterService stockMasterService;
    
    @Inject
    public ModifyDetailService(ModifyDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Transactional
    public void saveItemDetail(List<ModifyDetail> list,Modify m) {  
    	
    	for (ModifyDetail c : list) {    		
    		Long slipSeq = new Long(1);

    		if(null == c.getSlipSeq()){
    			slipSeq = select().select(qModifyDetail.slipSeq.max()).distinct()
				.from(qModifyDetail).where(qModifyDetail.slipCd.eq(m.getSlipCd())).fetchOne();

    			if(null==slipSeq){
    				slipSeq = new Long(1);
    			}else{
    				slipSeq = slipSeq + new Long(1);
    			}    			
    			c.setSlipSeq(slipSeq);
    		}
    		
    		c.setSlipCd(m.getSlipCd());
			c = stockMasterService.modifyItem(c,m.getWhCd(),m.getSlipDt());
    		save(c);
    	}
    	
    }
}