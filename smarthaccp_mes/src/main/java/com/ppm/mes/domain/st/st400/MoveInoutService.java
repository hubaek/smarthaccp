package com.ppm.mes.domain.st.st400;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.domain.st.st410.MoveInoutDetail;
import com.ppm.mes.domain.st.st410.MoveInoutDetailService;

@Service
public class MoveInoutService extends BaseService<MoveInout, MoveInout.MoveInoutId> {
    private MoveInoutRepository repository;

    @Inject private MoveInoutMapper moveInoutMapper;
    @Inject private MoveInoutDetailService moveInoutItemDetailService;
    @Inject private WorkKeyManagementService workKeyManagementService;  
    
    
    @Inject
    public MoveInoutService(MoveInoutRepository repository) {
        super(repository);
        this.repository = repository;
    }

    
    @Transactional
    public MoveInout saveMoveInout(MoveInout m) {
    	
    	List<MoveInoutDetail> list = m.getItemDetail(); 
 
		String slipCd = "";
    	if (null!=m) {  

			if(isEmpty(m.getSlipCd())){
				slipCd = workKeyManagementService.getYymmCode("ST400" ,"MW", 3);    
				m.setSlipCd(slipCd);
			}
			

			if(isNotEmpty(list)){
		    	for (MoveInoutDetail c : list) {
		    		c.setCompany(m.getCompany());
		    		c.setSlipCd(m.getSlipCd());
		    	}
		    	moveInoutItemDetailService.saveItemDetail(list,m);
			}

			save(m);  
    	}
    	
    	return m; 
    }
    
    public List<MoveInoutVO> header(RequestParams<MoveInoutVO> vo){
    	return moveInoutMapper.header(vo);
    }

    public List<MoveInoutVO> itemDetail(RequestParams<MoveInoutVO> vo){
    	return moveInoutMapper.itemDetail(vo);
    }
}