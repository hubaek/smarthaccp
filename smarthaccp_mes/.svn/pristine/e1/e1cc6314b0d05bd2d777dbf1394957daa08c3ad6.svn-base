package com.ppm.mes.domain.report;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.domain.BaseService;
import com.querydsl.core.BooleanBuilder;

import javax.inject.Inject;
import com.chequer.axboot.core.parameter.RequestParams;
import java.util.List;

@Service
public class DailyReport020Service extends BaseService<DailyReport020, DailyReport020.DailyReport020Id> {
    private DailyReport020Repository dailyReport020Repository;

    @Inject
    public DailyReport020Service(DailyReport020Repository dailyReport020Repository) {
        super(dailyReport020Repository);
        this.dailyReport020Repository = dailyReport020Repository;
    }

    public List<DailyReport020> gets(RequestParams<DailyReport020> requestParams) {
    	
    	String company = requestParams.getString("company");
    	String templateId = requestParams.getString("templateId");
    	String startDate = requestParams.getString("startDate");
    	String reportDate = requestParams.getString("reportDate");
    	
    	BooleanBuilder builder = new BooleanBuilder();
    	
    	if(isNotEmpty(company)){
    		builder.and(qDailyReport020.company.eq(company));
    	}
    	
    	if(isNotEmpty(templateId)){
    		builder.and(qDailyReport020.templateId.eq(templateId));
    	}
    	
    	if(isNotEmpty(startDate)){
    		builder.and(qDailyReport020.startDate.eq(startDate));
    	}
    	
    	if(isNotEmpty(reportDate)){ 
    		builder.and(qDailyReport020.reportDate.eq(reportDate));
    	}
    	
    	List<DailyReport020> list = select().from(qDailyReport020).where(builder).orderBy(qDailyReport020.dSeq.asc()).fetch();
    	
        return list;
    }
    
    @Transactional
    public void saveReport020(List<DailyReport020> list){
    	for(DailyReport020 c: list){
    		Integer dSeq = new Integer(1);
    		
    		BooleanBuilder builder = new BooleanBuilder();
        	
        	
        	builder.and(qDailyReport020.company.eq(c.getCompany()));
        	builder.and(qDailyReport020.templateId.eq(c.getTemplateId()));
        	builder.and(qDailyReport020.startDate.eq(c.getStartDate()));
        	builder.and(qDailyReport020.reportDate.eq(c.getReportDate()));
        	
    		
    		if(null == c.getDSeq()){
    			dSeq = select().select(qDailyReport020.dSeq.max()).distinct()
    					.from(qDailyReport020).where(builder).fetchOne();
    			if(null==dSeq){
    				dSeq = new Integer(1);
    			}else{
    				dSeq = dSeq + new Integer(1);
    			}
    			
    			c.setDSeq(dSeq);
    			
    		}
    		save(c);
    	}
    	
    	
    }
}