package com.ppm.mes.domain.item.item100;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.company.CompanyKeyManagementService;
 
@Service
public class ItemGroupMainService extends BaseService <ItemGroupMain,ItemGroupMain.ItemGroupMainId>{

    private ItemGroupMainRepository repository;    
    
    @Inject private ItemGroupMainMapper itemGroupMainMapper;
    @Inject private CompanyKeyManagementService companyKeyManagementService;
    
    @Inject
    public ItemGroupMainService(ItemGroupMainRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<ItemGroupMainVO> getItemMainList(RequestParams<ItemGroupMainVO> vo){
    	return itemGroupMainMapper.getItemMainList(vo);
    }

    public List<ItemGroupMainVO> getItemSubList(RequestParams<ItemGroupMainVO> vo){
    	return itemGroupMainMapper.getItemSubList(vo);
    }
  
    /*                  
	20.07.13 김재민 
	신규 formView 와 gridView02가 함께 저장 되게끔 수정
    */
    @Transactional
    public ItemGroupMain saveItemMain(ItemGroupMain m) {

    	if (null!=m) {  
    		String itemMainCd = ""; 
			if(isEmpty(m.getItemMainCd())){
				itemMainCd = companyKeyManagementService.getCommonCode(m.getCompany(),"ITEM100" ,"M", 4);    
				m.setItemMainCd(itemMainCd);
			}
			save(m);  
    	}
		return m;
    }
    
 
    @Transactional
    public void deleteItemMain(ItemGroupMain m) {
    	if(null != m){
    		
        	String company = m.getCompany();
        	String itemMainCd = m.getItemMainCd();
        	delete(qItemGroupMain).where(qItemGroupMain.company.eq(company).and(qItemGroupMain.itemMainCd.eq(itemMainCd))).execute(); 
        	delete(qItemGroupSub).where(qItemGroupSub.company.eq(company).and(qItemGroupSub.itemMainCd.eq(itemMainCd))).execute(); 
    	}
    }
    
}