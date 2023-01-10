package com.ppm.mes.domain.eq.eq000;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;
 
 
@Service
public class EquipMasterService extends BaseService<EquipMaster,EquipMaster.EquipMasterId> {
   
	private EquipMasterRepository repository;   

    @Inject private EquipMasterMapper equipMasterMapper;
    
    
    @Inject
    public EquipMasterService(EquipMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }    

    //조회
    public List<EquipMasterVO> getEquipList(RequestParams<EquipMasterVO> requestParams) {
    	return equipMasterMapper.getEquipList(requestParams);
    }

    //저장
    @Transactional
    public void saveEquip(EquipMaster m) {    	
    	if(null!=m){
    		
    		if(isNotEmpty(m.getTempFileCd())){
				update(qCommonFile)
		        .set(qCommonFile.targetId , m.getEquipCd())
	        		.where(qCommonFile.targetId.eq(m.getTempFileCd())
		        			.and(qCommonFile.targetType.eq("EQUIP_CD"))
		        			.and(qCommonFile.tempYn.eq("Y"))).execute();		
			}
    		
     		save(m);  
    	}
    }

	public List<EquipMaster> getCheckEquipCd(RequestParams<EquipMaster> requestParams) {
		 String equipCd = requestParams.getString("equipCd", "");
		 BooleanBuilder builder = new BooleanBuilder();
		 builder.and(qEquipMaster.equipCd.eq(equipCd));
		 return findAll(builder);
	}    
}