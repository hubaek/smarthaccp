package com.ppm.mes.domain.haccp.itemCheck;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;


@Service
public class ItemCheckMasterService extends BaseService<ItemCheckMaster,ItemCheckMaster.ItemCheckMasterId>{

	private ItemCheckMaserRepository repository;
	
	@Inject private ItemCheckMasterMapper itemCheckMasterMapper;
	
	@Inject
    public ItemCheckMasterService(ItemCheckMaserRepository repository){
		super(repository);
        this.repository = repository;
	}
	//리스트 조회
	public List<ItemCheckMaster> getItemCheckList(RequestParams<ItemCheckMasterVO> requestParams) {
		return itemCheckMasterMapper.getItemCheckList(requestParams);
	}
	//중복체크
	public List<ItemCheckMaster> getItemCheckMonth(RequestParams<ItemCheckMaster> requestParams) {
		String inspectionYm = requestParams.getString("inspectionYm", "");
		 BooleanBuilder builder = new BooleanBuilder();
		 builder.and(qItemCheckMaster.inspectionYm.eq(inspectionYm));
		 return findAll(builder);
	}
	
	public ItemCheckMaster getItemCheckPrint(RequestParams<ItemCheckMaster> requestParams) {
		String inspectionYm = requestParams.getString("inspectionYm", "");
		 BooleanBuilder builder = new BooleanBuilder();
		 builder.and(qItemCheckMaster.inspectionYm.eq(inspectionYm));
		 return findOne(builder);
	}
	
	//저장,수정
	@Transactional
	public void saveItemCheckMaster(ItemCheckMaster m) {
		if(isNotEmpty(m.getTempFileCd())){
			update(qCommonFile)
	        .set(qCommonFile.targetId , m.getInspectionYm())
        		.where(qCommonFile.targetId.eq(m.getTempFileCd())
	        			.and(qCommonFile.targetType.eq("INSPECTION_YM"))
	        			.and(qCommonFile.tempYn.eq("Y"))).execute();		
		}
		
		save(m);
	}
	//삭제
    @Transactional
	public void deleteAll(ItemCheckMaster m) {
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qItemCheckMaster.inspectionYm.eq(m.getInspectionYm()));
		builder.and(qItemCheckMaster.company.eq(m.getCompany()));
		delete(qItemCheckMaster).where(builder).execute();
		
		
	}
	
}
