package com.ppm.mes.domain.pr.pr200;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.item.item000.ItemMaster;
import com.ppm.mes.domain.item.item000.ItemMasterService;
import com.querydsl.core.BooleanBuilder;

@Service
public class SaPriceManagementService extends BaseService<SaPriceManagement, SaPriceManagement.SalesPriceManagementId> {
    private SaPriceManagementRepository repository;

	@Inject private ItemMasterService itemMasterService;
	@Inject private SaPriceManagementMapper saPriceManagementMapper;
	
    @Inject
    public SaPriceManagementService(SaPriceManagementRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    public List<SaPriceVO> getSaPriceList(RequestParams<SaPriceVO> requestParams) {
    	return saPriceManagementMapper.getSaPriceList(requestParams);
    }
    
    //거래처별 구매 단가 가져오기 - 없을시 품목마스터 단가
    public ItemMaster getSaUnitPrice(RequestParams requestParams) {
        String custCode = requestParams.getString("custCode", "");
        String itemCode = requestParams.getString("itemCode", "");
        String useYn = requestParams.getString("useYn", ""); 
     
        ItemMaster itemMaster = itemMasterService.getItemMaster(itemCode);     
        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(custCode)) { 
            builder.and(qSaPriceManagement.custCd.eq(custCode));
        }
        if (isNotEmpty(itemCode)) { 
            builder.and(qSaPriceManagement.itemCd.eq(itemCode));
        }
        if (isNotEmpty(useYn)) { 
            builder.and(qSaPriceManagement.useYn.eq(useYn));
        }
        
        SaPriceManagement saPriceManagement = select().from(qSaPriceManagement).where(builder).fetchOne();
    
        if(null != saPriceManagement){
        	
        	itemMaster.setSaPrice(saPriceManagement.getUnitPrice());
        }
        
        return itemMaster;        
    }
    
    @Transactional
    public void saveSaPrice(List<SaPriceManagement> list){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String regDt = sdf.format(cal.getTime());
        
    	if (isNotEmpty(list)) {  
    		for (SaPriceManagement m : list) {
    			m.setRegDt(regDt);
            }
			save(list);
    	}
    }
}