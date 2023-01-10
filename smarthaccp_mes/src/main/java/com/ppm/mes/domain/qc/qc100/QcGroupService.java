package com.ppm.mes.domain.qc.qc100;

import java.util.List;

import javax.inject.Inject;
import javax.jdo.annotations.Transactional;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.company.CompanyKeyManagementService;
import com.ppm.mes.domain.qc.qc110.QcGroupItem;
import com.ppm.mes.domain.qc.qc110.QcGroupItemService;

@Service
public class QcGroupService extends BaseService<QcGroup, QcGroup.QcGroupId> {
   
	private QcGroupRepository repository;
	
	@Inject private QcGroupItemService qcGroupItemService;
    @Inject private CompanyKeyManagementService companyKeyManagementService;
    @Inject private QcGroupMapper qcGroupMapper;
    
    @Inject
    public QcGroupService(QcGroupRepository repository) {
        super(repository);
        this.repository = repository;
    }    

    public List<QcGroupVO> getQcGroupList(RequestParams<QcGroupVO> vo) {   
    	return qcGroupMapper.getQcGroupList(vo);   
    }    

    @Transactional
    public QcGroup saveQcGroup(QcGroup m) {    	
    	
    	List<QcGroupItem> list = m.getQcGroupItem();

    	if (null != m) {  

    		String qcGroupCd = "";
			
			if(isEmpty(m.getQcGroupCd())){
				qcGroupCd = companyKeyManagementService.getCommonCode(m.getCompany(),"QC100" ,"", 5);    
				m.setQcGroupCd(qcGroupCd);
			}
			
			if(isNotEmpty(list)){
		    	for (QcGroupItem c : list) {
		    		c.setCompany(m.getCompany());
		    		c.setQcGroupCd(m.getQcGroupCd());
		    	}
		    	qcGroupItemService.save(list);
			}
			
			save(m);  
    	}
    	
    	return m;
    }
}