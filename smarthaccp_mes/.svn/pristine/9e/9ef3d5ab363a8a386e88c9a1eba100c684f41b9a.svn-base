package com.ppm.mes.domain.item.item150;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.company.CompanyKeyManagementService;
 
@Service
public class ItemGroupSubService extends BaseService <ItemGroupSub,ItemGroupSub.ItemGroupSubId>{

    private ItemGroupSubRepository repository;    
    @Inject private CompanyKeyManagementService companyKeyManagementService;
    
    @Inject
    public ItemGroupSubService(ItemGroupSubRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Transactional
    public void saveItemSub(List<ItemGroupSub> list) {
    	if(isNotEmpty(list)){
	    	for (ItemGroupSub c : list) {
	    		String itemSubCd = "";
				if(isEmpty(c.getItemSubCd())){
					itemSubCd = companyKeyManagementService.getCommonCode(c.getCompany(),"ITEM150" ,"S", 4);    
					c.setItemSubCd(itemSubCd);
				}
				save(c);  
    		} 
    	}
    }
}