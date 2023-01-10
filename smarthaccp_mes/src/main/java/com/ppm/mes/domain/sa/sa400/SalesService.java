package com.ppm.mes.domain.sa.sa400;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.domain.sa.sa410.SalesDetail;
import com.ppm.mes.domain.sa.sa410.SalesDetailService;

@Service
public class SalesService extends BaseService<Sales, Sales.SalesId> {
    private SalesRepository repository;

    @Inject private SalesMapper salesMapper;
    @Inject private SalesDetailService salesDetailService;
    @Inject private WorkKeyManagementService workKeyManagementService;  

    @Inject
    public SalesService(SalesRepository repository) {
        super(repository);
        this.repository = repository;
    }
    //저장
    @Transactional
    public Sales saveForm(Sales m) {
    	
    	List<SalesDetail> list = m.getItemDetail();
    	
    	if (null!=m) {  
    		String slipCd = "";

    		if(isEmpty(m.getSlipCd())){
				slipCd = workKeyManagementService.getYymmCode("SA400" ,"SL", 3);    
				m.setSlipCd(slipCd);
			}

			if(isNotEmpty(list)){
		    	for (SalesDetail c : list) {
		    		c.setCompany(m.getCompany());
		    		c.setSlipCd(m.getSlipCd());
		    	}
		    	salesDetailService.saveItemDetail(list);
			}

			save(m);  
		}
    	
    	return m;
    }
        
    public List<SalesVO> header(RequestParams<SalesVO> vo){
    	return salesMapper.header(vo);
    }
    
    public List<SalesVO> itemDetail(RequestParams<SalesVO> vo){
    	return salesMapper.itemDetail(vo);
    }    
    

    //기간별_연별_월
    public List<SalesListVO> itemDetailGroupByYearMon(RequestParams<SalesListVO> vo){
    	return salesMapper.itemDetailGroupByYearMon(vo);
    }
    //기간별_연별_분기
    public List<SalesListVO> itemDetailGroupByYearQuater(RequestParams<SalesListVO> vo){
    	return salesMapper.itemDetailGroupByYearQuater(vo);
    }
    //기간별_지역별_연
    public List<SalesListVO> itemDetailGroupByYearCust(RequestParams<SalesListVO> vo){
    	return salesMapper.itemDetailGroupByYearCust(vo);
    }
    //기간별_지역별_연월별
    public List<SalesListVO> itemDetailGroupByMonthCust(RequestParams<SalesListVO> vo){
    	return salesMapper.itemDetailGroupByMonthCust(vo);
    }
    //기간별_지역별_연별_TOP20
    public List<SalesListVO> itemDetailGroupByYearCust20(RequestParams<SalesListVO> vo){
    	return salesMapper.itemDetailGroupByYearCust20(vo);
    }
    
}