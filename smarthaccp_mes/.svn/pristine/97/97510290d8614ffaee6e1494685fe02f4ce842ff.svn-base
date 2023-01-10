package com.ppm.mes.domain.eq.manu;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

 
@Service
public class ManuEquipService extends BaseService <ManuEquip,ManuEquip.ManuEquipId>{
	
    private ManuEquipRepository repository;
    
    @Inject private ManuEquipMapper manuEquipMapper;
    
    @Inject
    public ManuEquipService(ManuEquipRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    
  //조회
    public List<ManuEquipVO> getEquipList(RequestParams<ManuEquipVO> requestParams) {
    	return manuEquipMapper.getEquipList(requestParams);
    }
  //저장   
    @Transactional
    public void saveManuEquip(ManuEquip list){
    	if (null!=list) {  
    		String equipCode = "";
			if(isEmpty(list.getEquipCode())){
				//equipCode = workKeyManagementService.getYymmCode("BOARD_CODE", "BD", 3);   
				equipCode = "10";
				list.setEquipCode(equipCode);
				list.setCompany("1000");
			}
			if(isNotEmpty(list.getTempFileCd())){
				update(qCommonFile)
		        .set(qCommonFile.targetId , list.getEquipCode())
	        		.where(qCommonFile.targetId.eq(list.getTempFileCd())
		        			.and(qCommonFile.targetType.eq("EQUIP_CODE"))
		        			.and(qCommonFile.tempYn.eq("Y"))).execute();		
			}
			
			save(list);  
		}
    }
    //삭제
    @Transactional
    public void deleteAll(ManuEquip m){
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.and(qManuEquip.company.eq(m.getCompany()));
    	builder.and(qManuEquip.equipCode.eq(m.getEquipCode()));
    	builder.and(qManuEquip.manageNo.eq(m.getManageNo()));
    	delete(qManuEquip).where(builder).execute();
    	
    }


	public List<ManuEquip> getManageCheck(RequestParams<ManuEquip> requestParams) {
		String manageNo = requestParams.getString("manageNo", "");
		String equipCode = requestParams.getString("equipCode", "");
		 BooleanBuilder builder = new BooleanBuilder();
		 
		 builder.and(qManuEquip.manageNo.eq(manageNo));
		 builder.and(qManuEquip.equipCode.eq(equipCode));
		 
		 return findAll(builder);
	}

}