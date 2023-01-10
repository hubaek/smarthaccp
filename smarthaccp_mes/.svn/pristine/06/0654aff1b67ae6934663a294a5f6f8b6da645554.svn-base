package com.ppm.mes.domain.qc.qc000;

import java.util.List;

import javax.inject.Inject;
import javax.jdo.annotations.Transactional;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class QcMasterService extends BaseService<QcMaster, QcMaster.QcMasterId> {
  
	private QcMasterRepository repository;
    
    @Inject
    public QcMasterService(QcMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }    

    public List<QcMaster> getQcMaster(RequestParams requestParams) {        

        String qcCd = requestParams.getString("qcCd", "");
        String qcNm = requestParams.getString("qcNm", "");
    	String qcEquipYn = requestParams.getString("qcEquipYn", "");
    	String qcRoutYn = requestParams.getString("qcRoutYn", "");
    	String useYn = requestParams.getString("useYn", "");


        BooleanBuilder builder = new BooleanBuilder();


        if (isNotEmpty(qcCd)) { 
            builder.and(qQcMaster.qcCd.like("%"+qcCd+"%"));
        }
        
        if (isNotEmpty(qcNm)) { 
            builder.and(qQcMaster.qcNm.like("%"+qcNm+"%"));
        }

        if (isNotEmpty(qcEquipYn)) {   
            builder.and(qQcMaster.qcEquipYn.eq(qcEquipYn));
        }

        if (isNotEmpty(qcRoutYn)) {   
            builder.and(qQcMaster.qcRoutYn.eq(qcRoutYn));
        }

        if (isNotEmpty(useYn)) {   
            builder.and(qQcMaster.useYn.eq(useYn));
        }
        
        List<QcMaster> list = select().from(qQcMaster)
        		.where(builder)
        		.orderBy(qQcMaster.sort.asc()).fetch();
        return list;
    }    

    @Transactional
    public void saveQcMaster(List<QcMaster> list) {    	
		save(list);
    }
}