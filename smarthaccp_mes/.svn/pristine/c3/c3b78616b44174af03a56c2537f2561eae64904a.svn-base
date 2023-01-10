package com.ppm.mes.domain.st.st410;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.st.st000.StockMasterService;
import com.ppm.mes.domain.st.st400.MoveInout;

@Service
public class MoveInoutDetailService extends BaseService<MoveInoutDetail, MoveInoutDetail.MoveInoutDetailId> {
    private MoveInoutDetailRepository repository;

    @Inject private StockMasterService stockMasterService;
    @Inject
    public MoveInoutDetailService(MoveInoutDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Transactional
    public void saveItemDetail(List<MoveInoutDetail> list,MoveInout m) {    
    	for (MoveInoutDetail c : list) {
    		Long slipSeq = new Long(1);
    		if(null == c.getSlipSeq()){
    			slipSeq = select().select(qMoveInoutDetail.slipSeq.max()).distinct()
				.from(qMoveInoutDetail).where(qMoveInoutDetail.slipCd.eq(c.getSlipCd())).fetchOne();

    			if(null==slipSeq){
    				slipSeq = new Long(1);
    			}else{
    				slipSeq = slipSeq + new Long(1);
    			}    			
    			
    			c.setSlipSeq(slipSeq);
    		}

        	//자재창고로 들어올경우 환입.
        	if(m.getWhCd().equals("10")){
        		c = stockMasterService.moveItem(c,m.getWhCd(),"Y");   
        	}else{
        		c = stockMasterService.moveItem(c,m.getWhCd(),"N");   
        	}
        	
        	
    		save(c);
    	}
    }
}