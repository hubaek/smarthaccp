package com.ppm.mes.domain.wh.wh000;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
 
@Service
public class WarehouseMasterService extends BaseService <WarehouseMaster,WarehouseMaster.WarehouseMasterId>{
	
    private WarehouseMasterRepository repository;

    @Inject private WarehouseMasterMapper warehouseMasterMapper;

    
    @Inject
    public WarehouseMasterService(WarehouseMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }
 
    //조회
    public List<WarehouseMasterVO> getWarehouseList(RequestParams<WarehouseMasterVO> requestParams) {    
    	return warehouseMasterMapper.getWarehouseList(requestParams);
    }
    
    //저장
    @Transactional
    public void saveWarehouse(WarehouseMaster w) {    	
    	if(null!=w){    		
    		if(isNotEmpty(w.getTempFileCd())){
				update(qCommonFile)
		        .set(qCommonFile.targetId , w.getWhCd())
	        		.where(qCommonFile.targetId.eq(w.getTempFileCd())
		        			.and(qCommonFile.targetType.eq("WH_CD"))
		        			.and(qCommonFile.tempYn.eq("Y"))).execute();		
			}    		
     		save(w);  
    	}    	
    }
}