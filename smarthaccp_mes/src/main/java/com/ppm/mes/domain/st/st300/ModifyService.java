package com.ppm.mes.domain.st.st300;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.domain.st.st310.ModifyDetail;
import com.ppm.mes.domain.st.st310.ModifyDetailService;

@Service
public class ModifyService extends BaseService<Modify, Modify.ModifyId> {
    private ModifyRepository repository;

    @Inject private ModifyMapper modifyMapper;
    @Inject private ModifyDetailService modifyItemDetailService;
    @Inject private WorkKeyManagementService workKeyManagementService;  
    
    @Inject
    public ModifyService(ModifyRepository repository) {
        super(repository);
        this.repository = repository;
    }

    
    @Transactional
    public Modify saveModify(Modify m) {
    	
    	List<ModifyDetail> list = m.getItemDetail(); 
		String slipCd = ""; 
    	if (null!=m) {  

    		//신규 
			if(isEmpty(m.getSlipCd())){
				slipCd = workKeyManagementService.getYymmCode("ST300","MD", 3);   
				m.setSlipCd(slipCd);
			}

			if(isNotEmpty(list)){
		    	for (ModifyDetail c : list) {
		    		c.setCompany(m.getCompany());
		    		c.setSlipCd(m.getSlipCd());
		    	}
				modifyItemDetailService.saveItemDetail(list,m);
			}
			
			save(m);  
    	}
    	return m; 
    }
        

    public List<ModifyVO> header(RequestParams<ModifyVO> vo){
    	return modifyMapper.header(vo);
    }   

    public List<ModifyVO> itemDetail(RequestParams<ModifyVO> vo){
    	return modifyMapper.itemDetail(vo);
    }
}