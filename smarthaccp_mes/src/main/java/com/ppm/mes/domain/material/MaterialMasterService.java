package com.ppm.mes.domain.material;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

@Service
public class MaterialMasterService extends BaseService<MaterialMaster,MaterialMaster.MaterialMasterId>{
	
	private MaterialMasterRepository repository;
	
	@Inject private MaterialMasterMapper materialMasterMapper;
	
	@Inject
    public MaterialMasterService(MaterialMasterRepository repository){
		super(repository);
        this.repository = repository;
	}
	
	// 조회
	public List<MaterialMasterVO> getMaterialList(RequestParams<MaterialMasterVO> requestParams){
		return materialMasterMapper.getMaterialList(requestParams);
	}
	
	public List<MaterialMaster> getMaterialCheckInDate(RequestParams<MaterialMaster> requestParams){
		 String inDate = requestParams.getString("inDate", "");
		 BooleanBuilder builder = new BooleanBuilder();
		 if (isNotEmpty(inDate)) {  
             builder.and(qMaterialMaster.inDate.eq(inDate));
         }
		 return findAll(builder);
	}
	
	//저장
	@Transactional
	public void saveMaterialMaster(MaterialMaster m){
		if(isNotEmpty(m.getTempFileCd())){
			update(qCommonFile)
	        .set(qCommonFile.targetId , m.getInDate())
        		.where(qCommonFile.targetId.eq(m.getTempFileCd())
	        			.and(qCommonFile.targetType.eq("IN_DATE"))
	        			.and(qCommonFile.tempYn.eq("Y"))).execute();		
		}
		if(m != null){
			for(int i = 0; i<2; i++){
				m.setCompany("1000");
				if(i == 0){
					m.setItemType("10");
				}else{
					m.setItemType("20");
				}
				save(m);
			}
		}
	}
	//삭제
	@Transactional
	public void deleteAll(MaterialMaster m) {
		for(int i = 0 ; i<2; i++){
			BooleanBuilder builder = new BooleanBuilder();
			builder.and(qMaterialMaster.company.eq(m.getCompany()));
			builder.and(qMaterialMaster.inDate.eq(m.getInDate()));
			if(i == 0){
				builder.and(qMaterialMaster.itemType.eq("10"));
			}else{
				builder.and(qMaterialMaster.itemType.eq("20"));
			}
			delete(qMaterialMaster).where(builder).execute();
		}
	}
}
