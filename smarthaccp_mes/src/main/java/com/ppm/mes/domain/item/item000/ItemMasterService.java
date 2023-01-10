package com.ppm.mes.domain.item.item000;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.company.CompanyKeyManagementService;
import com.querydsl.core.BooleanBuilder;

@Service
public class ItemMasterService extends BaseService<ItemMaster, ItemMaster.ItemMasterId> {
	
    private ItemMasterRepository repository;

    
    @Inject private CompanyKeyManagementService companyKeyManagementService;  
    @Inject private ItemMasterMapper itemMasterMapper;
    
    @Inject
    public ItemMasterService(ItemMasterRepository repository) {
        super(repository);
        this.repository = repository;
    }

    //한건 조회
    public ItemMaster getItemMaster(String itemCd) {	    
		BooleanBuilder builder = new BooleanBuilder();  

		if (isNotEmpty(itemCd)) {
	       	builder.and(qItemMaster.itemCd.eq(itemCd));
	    }
		 
		ItemMaster itemMaster = select()
	            .from(qItemMaster)  
	            .where(builder)
	            .fetchOne();
	
	    return itemMaster;
    }

    //한건 조회
    public ItemMaster getItemMaster(String partNo,String itemType) {	    
		BooleanBuilder builder = new BooleanBuilder();  

		if (isNotEmpty(itemType)) {
	       	builder.and(qItemMaster.itemType.eq(itemType));
	    }

		if (isNotEmpty(partNo)) {
	       	builder.and(qItemMaster.partNo.eq(partNo));
	    }
		 
		ItemMaster itemMaster = select()
	            .from(qItemMaster)  
	            .where(builder)
	            .fetchOne();
	
	    return itemMaster;
    }

    //한건 조회
    public List<ItemPnMasterVO> getItemMasterInfo(List<ItemPnMasterVO> list) {	    
    	if (isNotEmpty(list)) {  
    		for (ItemPnMasterVO m : list) {
    			if(isNotEmpty(m.getPartNo())){
        			ItemMaster i = getItemMaster(m.getPartNo(),m.getItemType());
        			if(null != i){
        				m.setItemCd(i.getItemCd());
        				m.setItemNm(i.getItemNm());
        				m.setUnit(i.getUnit());
        				m.setSpec(i.getSpec());
        			}
    			}
            }
    	}
    	return list;
    }
    
    //품목 조회
    public List<ItemMasterVO> getList(RequestParams<ItemMasterVO> requestParams) {
    	return itemMasterMapper.getList(requestParams);
    }
    

    //품목 조회:라우팅별
    public List<ItemMasterVO> getRoutingItemList(RequestParams<ItemMasterVO> requestParams) {
    	return itemMasterMapper.getRoutingItemList(requestParams);
    }

    //품목 조회:라우팅별::공정별
    public List<ItemMasterVO> getRoutItemList(RequestParams<ItemMasterVO> requestParams) {
    	return itemMasterMapper.getRoutItemList(requestParams);
    }

    
    //단건 저장
    @Transactional
    public ItemMaster saveItem(ItemMaster master) {
    	
    	if (null!=master) {  
    		String itemCd = ""; 
			//신규
			if(isEmpty(master.getItemCd())){
				itemCd = companyKeyManagementService.getCommonCode("ITEM","I",master.getCompany(),5);
				master.setItemCd(itemCd);
			}
			
			if(isNotEmpty(master.getTempFileCd())){
				update(qCommonFile)
		        .set(qCommonFile.targetId , master.getItemCd())
	        		.where(qCommonFile.targetId.eq(master.getTempFileCd())
		        			.and(qCommonFile.targetType.eq("ITEM_CD"))
		        			.and(qCommonFile.tempYn.eq("Y"))).execute();		
			}
			
			save(master);  
    	}
    	return master;
    }
    
    //POP 품목조회 
    public List<ItemMasterVO> getPopList(RequestParams<ItemMasterVO> requestParams) {
    	return itemMasterMapper.getPopList(requestParams);
    }

    //구매,판매단가 저장
    @Transactional
    public void saveItemOptions(List<ItemMaster> list) {
    	if (null!=list) {  
			save(list);
    		//List<ItemMaster> saveList = ModelMapperUtils.mapList(list, ItemMaster.class);
    		//save(saveList);
			
			//List<HaccpCarMaster> masterList = ModelMapperUtils.mapList(list,  HaccpCarMaster.class);
			//masterService.save(masterList);
    	}
    }
}