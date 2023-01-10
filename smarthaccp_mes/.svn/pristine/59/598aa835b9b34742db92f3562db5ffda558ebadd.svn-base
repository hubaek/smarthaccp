package com.ppm.mes.domain.qc.qc110;

import java.util.List;

import javax.inject.Inject;
import javax.jdo.annotations.Transactional;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class QcGroupItemService extends BaseService<QcGroupItem, QcGroupItem.QcGroupItemId> {
 
	private QcGroupItemRepository repository;
    
    @Inject
    public QcGroupItemService(QcGroupItemRepository repository) {
        super(repository);
        this.repository = repository;
    }    

    public List<QcGroupItem> getQcGroupItemList(RequestParams requestParams) {        

    	String qcGroupCd = requestParams.getString("qcGroupCd", "");
        String qcCd = requestParams.getString("qcCd", "");
        String qcNm = requestParams.getString("qcNm", "");
    	String useYn = requestParams.getString("useYn", "");


        BooleanBuilder builder = new BooleanBuilder();
        
        if (isNotEmpty(qcGroupCd)) { 
            builder.and(qQcGroupItem.qcGroupCd.eq(qcGroupCd));
        }

        if (isNotEmpty(qcCd)) { 
            builder.and(qQcGroupItem.qcCd.eq(qcCd));
        }
        
        
        if (isNotEmpty(useYn)) {   
            builder.and(qQcGroupItem.useYn.eq(useYn));
        }
        
        
        List<QcGroupItem> list = select().from(qQcGroupItem).where(builder).fetch();
        
        return list;
    }    

    @Transactional
    public void saveQcGroupItem(List<QcGroupItem> list) {    	
		save(list);
    }
}