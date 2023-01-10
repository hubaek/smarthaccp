package com.ppm.mes.domain.pr.pr100;


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
public class PcPriceManagementService extends BaseService<PcPriceManagement, PcPriceManagement.PurchasePriceManagementId> {
    private PcPriceManagementRepository repository;

	@Inject private ItemMasterService itemMasterService;
	@Inject private PcPriceManagementMapper pcPriceManagementMapper;
	
    @Inject
    public PcPriceManagementService(PcPriceManagementRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    public List<PcPriceVO> getPcPriceList(RequestParams<PcPriceVO> requestParams) {
    	return pcPriceManagementMapper.getPcPriceList(requestParams);
    }
    

    //거래처별 구매 단가 가져오기 - 없을시 품목마스터 단가
    public ItemMaster getPcUnitPrice(RequestParams requestParams) {
    	
        String custCd = requestParams.getString("custCd", "");
        String itemCd = requestParams.getString("itemCd", "");
        String useYn = requestParams.getString("useYn", ""); 
     
        ItemMaster itemMaster = itemMasterService.getItemMaster(itemCd);     
        
        
        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(custCd)) { 
            builder.and(qPcPriceManagement.custCd.eq(custCd));
        }
        if (isNotEmpty(itemCd)) { 
            builder.and(qPcPriceManagement.itemCd.eq(itemCd));
        }
        if (isNotEmpty(useYn)) { 
            builder.and(qPcPriceManagement.useYn.eq(useYn));
        }
        
        PcPriceManagement pcPriceManagement = 
        		select().from(qPcPriceManagement).where(builder).fetchOne();
    
        if(null != pcPriceManagement){
        	itemMaster.setPcPrice(pcPriceManagement.getUnitPrice());
        }
        
        return itemMaster;
        
    }
    @Transactional
    public void savePcPrice(List<PcPriceManagement> list){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String regDt = sdf.format(cal.getTime());
        
    	if (isNotEmpty(list)) {  
    		for (PcPriceManagement m : list) {
    			m.setRegDt(regDt);
            }
			save(list);
    	}
    }
}